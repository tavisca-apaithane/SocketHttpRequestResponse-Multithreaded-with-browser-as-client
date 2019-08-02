import java.io.BufferedReader;
import java.io.IOException;

public class ServerMessageReceiver  {

    private BufferedReader dataIn = null;
    public ServerMessageReceiver(BufferedReader dataIn)
    {
        this.dataIn = dataIn;
    }

    public String getRequest()
    {
        String HtmlFile = "";
        try {
            char[] buffer = new char[300];
            dataIn.read(buffer);
            String requestMetadataFromClient = new String(buffer);
            HtmlFile = extractRequestedHtml(requestMetadataFromClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return HtmlFile;
    }

    public String extractRequestedHtml(String requestMetadataFromClient)
    {
        String HtmlFile="";

        if(requestMetadataFromClient.contains("/index.html"))
            HtmlFile = "/index.html";
        else if(requestMetadataFromClient.contains("/home.html"))
            HtmlFile = "/home.html";
        else if(requestMetadataFromClient.split(" ")[1].equals("/"))
            HtmlFile = "/index.html";
        else
            HtmlFile = "undefined";

        return HtmlFile;
    }

}