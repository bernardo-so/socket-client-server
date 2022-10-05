import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        new Cliente("127.0.0.1", 3535);
        System.out.println("Servidor subiu com sucesso !");
    }
}