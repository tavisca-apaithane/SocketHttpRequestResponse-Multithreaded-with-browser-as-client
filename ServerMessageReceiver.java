import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.Callable;

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
                HtmlFile = message.split(" ")[1];
            } catch (IOException e) {
                e.printStackTrace();
        }
            return HtmlFile;
    }

}
