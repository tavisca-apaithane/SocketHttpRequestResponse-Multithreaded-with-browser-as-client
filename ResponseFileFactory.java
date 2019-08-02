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
            case "/index.html": htmlString = getIndexFile();
                break;
            case "/home.html" : htmlString = getHomeFile();
                break;
            case "/": htmlString = getIndexFile();
                break;
            case "undefined": htmlString = "<html><h1>Error 404</h1></html>";
                break;
        }
        return htmlString;
    }

    private String getHomeFile() {

        byte[] b=null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\apaithane\\Desktop\\home1.html");
            b = new byte[50000];
            in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }

    private String getIndexFile() {
        byte[] b = null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\apaithane\\Desktop\\index1.html");
            b = new byte[1000];
            in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }
}