import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class Connection extends Thread {
    ServerMessageSender serverMessageSender = null;
    ServerMessageReceiver serverMessageReceiver = null;
    BufferedReader dataIn = null;
    DataOutputStream dataOut = null;

    public Connection(BufferedReader dataIn, DataOutputStream dataOut) {
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        serverMessageSender = new ServerMessageSender(dataOut);
        serverMessageReceiver = new ServerMessageReceiver(dataIn);
    }

    @Override
    public void run() {
            String request = getRequest();
            sendResponse(request);
            closeStreams();
    }

    public void sendResponse(String request)
    {
        ResponseFileFactory responseFileFactory = new ResponseFileFactory();
        byte[] htmlFileBuffer = responseFileFactory.generate(request);
        serverMessageSender.postResponse(htmlFileBuffer);
        ServerLogger.log("Client request Complete...");
    }

    public String getRequest()
    {
        return serverMessageReceiver.getRequestedFileName();
    }

    public void closeStreams()
    {
        try {
            this.dataOut.close();
            this.dataIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}