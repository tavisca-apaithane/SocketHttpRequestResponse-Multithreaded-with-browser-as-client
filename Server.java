import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket connectionAccepter;
    private static Socket server = null;
    private static BufferedReader dataIn = null;
    private static DataOutputStream dataOut = null;
    static {
        try {
            connectionAccepter = new ServerSocket(80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        while(true) {
            try {

                ServerLogger.log("server listening...");
                server = connectionAccepter.accept();
                ServerLogger.log("New Client Connected...");

                dataOut = new DataOutputStream(server.getOutputStream());
                dataIn = new BufferedReader(new InputStreamReader(server.getInputStream()));

                Connection user = new Connection(dataIn, dataOut);
                user.start();

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}