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
            System.out.println(requestMetadataFromClient);
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
        else if(requestMetadataFromClient.contains("/deathNote.jpg")) {
            HtmlFile = "/deathNote.jpg";
            System.out.println("in SErverMessageSEnder deathNote.jpg");
        }
        else if(requestMetadataFromClient.contains("/naruto.png")) {
            HtmlFile = "/naruto.png";
            System.out.println("in ServerMessageSender naruto.png");
        }
        else
            HtmlFile = "undefined";

        return HtmlFile;
    }

}