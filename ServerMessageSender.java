import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.file.Files;

public class ServerMessageSender extends Thread {

    private Socket server = null;
    private PrintWriter dataOut = null;
    private BufferedReader br = null;
    public ServerMessageSender(Socket server, PrintWriter dataOut)
    {
        this.server = server;
        this.dataOut = dataOut;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public void run()
    {

        dataOut.print("<html><body><h1>hello world!!!</h1></body></html>");
        dataOut.flush();
    }
}
