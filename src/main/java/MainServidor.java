import java.io.IOException;

public class MainServidor {

    public static void main(String[] args) throws IOException {
        new Servidor(3535);
        System.out.println("Servidor executado com êxito !");
    }
}