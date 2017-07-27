import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ilya on 28.07.17.
 */
public class Server {
    public static final int portNumber = 2828;
    public static void main(String[] args) {
        listenSocket();
    }

    public static void listenSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            out.println("hello client");
            String smth = in.readLine();
            System.out.println(smth);
        } catch (IOException e) {
            System.out.println("Couldn't listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
