import java.io.*;
import java.util.concurrent.Callable;

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
        /*byte[] b=null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\apaithane\\Desktop\\ap.html");
            b = new byte[in.available()];
            in.read(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        dataOut.print(requestedHtml);
        dataOut.flush();
    }
}
