import java.io.BufferedReader;
import java.io.PrintWriter;

public class Connection extends Thread {
    ServerMessageSender serverMessageSender = null;
    ServerMessageReceiver serverMessageReceiver = null;
    BufferedReader dataIn = null;
    PrintWriter dataOut = null;

    public Connection(BufferedReader dataIn, PrintWriter dataOut) {
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        serverMessageSender = new ServerMessageSender(dataOut);
        serverMessageReceiver = new ServerMessageReceiver(dataIn);
    }

    @Override
    public void run() {
        try {
            String request = serverMessageReceiver.getRequest();
            ServerLogger.log("Client requested for "+ request +"...");
            ResponseFileFactory responseFileFactory = new ResponseFileFactory();
            request = responseFileFactory.generate(request);
            serverMessageSender.postResponse(request);
            ServerLogger.log("Client request Complete...");
            this.dataOut.close();
            this.dataIn.close();

        } catch (Exception e) {
            ServerLogger.log("Exception in...");
        }

    }
}