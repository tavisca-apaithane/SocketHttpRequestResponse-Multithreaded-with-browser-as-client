import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket connectionAccepter = null;
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
                acceptConnection();
                initializeInputOutputStreams(server);
                Connection user = new Connection(dataIn, dataOut);
                user.start();
        }
    }

    public static void initializeInputOutputStreams(Socket server)
    {
        try {
            dataOut = new DataOutputStream(server.getOutputStream());
            dataIn = new BufferedReader(new InputStreamReader(server.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Socket acceptConnection()
    {
        ServerLogger.log("server listening...");
        try {
            server = connectionAccepter.accept();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        ServerLogger.log("New Client Connected...");
        return server;
    }

}