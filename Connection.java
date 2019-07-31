import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Connection extends Thread{
    private String requestedHtml="";
    ServerMessageSender serverMessageSender = null;
    ServerMessageReceiver serverMessageReceiver = null;


    public Connection(BufferedReader dataIn, PrintWriter dataOut)
    {
        serverMessageSender = new ServerMessageSender(dataOut);
        serverMessageReceiver = new ServerMessageReceiver(dataIn);
    }
    @Override
    public void run()
    {
        while(true) {
                String request =serverMessageReceiver.getRequest();
                ResponseFileFactory responseFileFactory = new ResponseFileFactory();
                request = responseFileFactory.generate(request);
                serverMessageSender.postResponse(request);
        }
    }

}
