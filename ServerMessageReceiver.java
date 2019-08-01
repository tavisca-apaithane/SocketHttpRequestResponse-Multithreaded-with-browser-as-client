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
        String HtmlFile="";
            try {
                char[] buffer = new char[300];
                dataIn.read(buffer);
                String message = new String(buffer);
                System.out.println(message);
                System.out.println("*******************");
                if(message.contains("/index.html"))
                    HtmlFile = "/index.html";
                else if(message.contains("/home.html"))
                    HtmlFile = "/home.html";
                else if(message.split(" ")[1].equals("/"))
                    HtmlFile = "/index.html";
                else
                    HtmlFile = "undefined";
            } catch (IOException e) {
                e.printStackTrace();
        }
            return HtmlFile;
    }

}
