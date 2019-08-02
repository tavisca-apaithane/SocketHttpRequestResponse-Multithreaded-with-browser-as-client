import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseFileFactory {
    public ResponseFileFactory(){}
    public String generate(String command)
    {
        String htmlString="";
        switch (command)
        {
            case "/index.html": htmlString = getHtml("index.html");
                break;
            case "/home.html" : htmlString = getHtml("home.html");
                break;
            case "/": htmlString = getHtml("index.html");
                break;
            case "undefined": htmlString = "<html><h1>Error 404</h1></html>";
                break;
        }
        return htmlString;
    }

    private String getHtml(String command) {
        byte[] b = null;
        try{
            InputStream in = new FileInputStream("C:\\Users\\apaithane\\Desktop\\" + command);
            b = new byte[50000];
            in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }
}