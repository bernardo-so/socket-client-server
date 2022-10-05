import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Cliente {

    public Cliente(String ip ,int porta) throws IOException, ClassNotFoundException, InterruptedException {
        for (int i = 0; i < 5; i++) {
            Socket cliente = new Socket(ip, porta);
            System.out.println("\n-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Cliente nº: " + i + " \nConectado ao servidor !");

            ObjectOutputStream saida = getSaida(cliente, i);
            ObjectInputStream entrada = getEntrada(cliente);

            fechaStreams(entrada, saida);
            cliente.close();

            Thread.sleep(500);
        }
    }

    private ObjectInputStream getEntrada(Socket cliente) throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
        Estudante estudante = (Estudante) entrada.readObject();
        System.out.println(estudante.getNome() + "      \nMédia: " + estudante.getMediaNotas());
        System.out.println("-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        return entrada;
    }

    private ObjectOutputStream getSaida(Socket cliente, int i) throws IOException{
        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        saida.writeObject(new Estudante(Arrays.asList(1.0+i,1.5+i,7.0),"\nEstudante nº: "+ i));

        return saida;
    }

    private void fechaStreams(ObjectInputStream entrada, ObjectOutputStream saida){
        try {
            entrada.close();
            saida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}