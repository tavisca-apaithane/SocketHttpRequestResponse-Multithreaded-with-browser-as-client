import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseFileFactory {
    private String command="";
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
        }
        return htmlString;
    }

    private String getHomeFile() {

        byte[] b=null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\apaithane\\Desktop\\home.html");
            b = new byte[300];
            in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }

    private String getIndexFile() {
        byte[] b = null;
        try {
            InputStream in = new FileInputStream("C:\\Users\\apaithane\\Desktop\\index.html");
            b = new byte[300];
            in.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }
}
