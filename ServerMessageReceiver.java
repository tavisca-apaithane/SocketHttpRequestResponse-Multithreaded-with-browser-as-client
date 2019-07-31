import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerMessageReceiver extends Thread {

    private Socket server = null;
    private BufferedReader dataIn = null;
    private BufferedReader br = null;
    public ServerMessageReceiver(Socket server, BufferedReader dataIn)
    {
        this.server = server;
        this.dataIn = dataIn;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run()
    {

            try {
                char[] buffer = new char[300];
                dataIn.read(buffer);
                String message = new String(buffer);
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
