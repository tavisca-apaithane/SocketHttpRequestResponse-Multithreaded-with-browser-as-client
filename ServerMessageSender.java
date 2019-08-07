import java.io.DataOutputStream;
import java.io.IOException;

public class ServerMessageSender {

    private DataOutputStream dataOut = null;
    private String requestedHtml = "";
    public ServerMessageSender(DataOutputStream dataOut)
    {
        this.dataOut = dataOut;
    }
    public void postResponse(byte[] response)
    {
        try {
            if(response ==null)
                System.out.println("response buffer is null...");
            dataOut.write(response);
            dataOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}