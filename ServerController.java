import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    private static ServerSocket connectionAccepter;

    static {
        try {
            connectionAccepter = new ServerSocket(80);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Socket server = null;
    private static BufferedReader dataIn = null;
    private static DataOutputStream dataOut = null;
    public ServerController() {
    }


    public static void main(String[] args)
    {
        int count=1;
        while(true) {
            try {
                System.out.println("server listening...");
                server = connectionAccepter.accept();
                System.out.println("client " + count + " connected...");
                count += 1;
                PrintWriter dataOut = new PrintWriter(server.getOutputStream());
                dataIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
                ServerMessageSender myServerMessageSender = new ServerMessageSender(server, dataOut);
                ServerMessageReceiver myServerMessageReceiver = new ServerMessageReceiver(server, dataIn);
                myServerMessageSender.start();
                myServerMessageReceiver.start();

            } catch (IOException e) {
                System.out.println(e.getMessage() + "*********************");
                e.printStackTrace();
            }
        }
    }
}
