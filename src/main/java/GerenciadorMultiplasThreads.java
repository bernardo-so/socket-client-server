import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GerenciadorMultiplasThreads extends Thread {

    private Socket socket;
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;

    public GerenciadorMultiplasThreads(Socket socket) throws IOException {
        this.socket = socket;
        setEntrada();
        setSaida();
    }

    @Override
    public void run() {
        try {
            Estudante estudante = (Estudante) this.entrada.readObject();

            CalculaMediaEstudante calculaMediaEstudante = new CalculaMediaEstudante(estudante.getNotas());
            estudante.setMediaNotas(calculaMediaEstudante.getMedia());

            this.saida.writeObject(estudante);

            fechaStreams();

            this.socket.close();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.toString());
        } catch (ClassNotFoundException  e) {
            throw new RuntimeException(e);
        }
    }

    private void setEntrada() throws IOException{
        this.entrada = new ObjectInputStream(this.socket.getInputStream());
    }

    private void setSaida() throws IOException{
        this.saida = new ObjectOutputStream(this.socket.getOutputStream());
    }

    private void fechaStreams(){
        try {
            this.entrada.close();
            this.saida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
