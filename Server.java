import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket connectionAccepter;
    private static Socket server = null;
    private static BufferedReader dataIn = null;
    private static PrintWriter dataOut = null;
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
                dataOut = new PrintWriter(server.getOutputStream());
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