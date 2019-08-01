import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class ServerMessageSender {

    private PrintWriter dataOut = null;
    private String requestedHtml = "";
    public ServerMessageSender(PrintWriter dataOut)
    {
        this.dataOut = dataOut;
    }
    public void setHtmlString(String htmlString)
    {
        this.requestedHtml = htmlString;
    }
    public void postResponse(String response)
    {
        dataOut.print(requestedHtml);
        dataOut.flush();
    }
}