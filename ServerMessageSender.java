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
        dataOut.print(response);
        dataOut.flush();

    }
}