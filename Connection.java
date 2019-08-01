import java.io.BufferedReader;
import java.io.PrintWriter;

public class Connection extends Thread{
    private String requestedHtml="";
    ServerMessageSender serverMessageSender = null;
    ServerMessageReceiver serverMessageReceiver = null;
    BufferedReader dataIn = null;
    PrintWriter dataOut = null;
    int count=0;
    static int connectionCount=1;
    public Connection(BufferedReader dataIn, PrintWriter dataOut, int count)
    {
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        serverMessageSender = new ServerMessageSender(dataOut);
        serverMessageReceiver = new ServerMessageReceiver(dataIn);
        this.count = count;
        System.out.println(count + " inConnection " + connectionCount);
        connectionCount++;
    }
    @Override
    public void run()
    {
            try {
                String request = serverMessageReceiver.getRequest();
                ResponseFileFactory responseFileFactory = new ResponseFileFactory();
                request = responseFileFactory.generate(request);
                serverMessageSender.setHtmlString(request);
                serverMessageSender.postResponse(request);
                this.dataOut.close();
                this.dataIn.close();

            }catch (Exception e)
            {
                System.out.println(e.getMessage()+"inConnection");
            }

    }

}
