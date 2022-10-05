import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public Servidor(int porta) throws IOException {

        ServerSocket servidor = new ServerSocket(porta);
        System.out.println("A porta "+ porta +" está aberta !");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("\nO Cliente " +
                    cliente.getInetAddress().getHostAddress() + " foi adicionado !"
            );

            GerenciadorMultiplasThreads gerenciadorMultiplasThreads = new GerenciadorMultiplasThreads(cliente);
            gerenciadorMultiplasThreads.start();
            System.out.println("\n-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-");
            System.out.println("Servidor está processando dados do cliente: " + cliente.getInetAddress().getHostAddress());
            System.out.println("-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-");
        }
    }

}