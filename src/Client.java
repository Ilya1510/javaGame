import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ilya on 28.07.17.
 */
public class Client {
    public static void main(String[] args) {
        listenSocket();
    }

    public static void listenSocket() {
        try {
            Socket socket = new Socket("127.0.0.1", 2828);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out.println("hello server");
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.out.println("Can't connect to server");
            System.exit(-1);
        }
    }
}
