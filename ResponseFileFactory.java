import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseFileFactory {
    public ResponseFileFactory(){}
    public byte[] generate(String command)
    {
        byte[] htmlFileBuffer =null;
        System.out.println("COMMAND :" + command);
        switch (command)
        {
            case "/index.html": htmlFileBuffer = getHtmlFileInByteArray("src/Assets/MyIndex.html");
                break;
            case "/home.html" : htmlFileBuffer = getHtmlFileInByteArray("src/Assets/home.html");
                break;
            case "/": htmlFileBuffer = getHtmlFileInByteArray("src/Assets/MyIndex.html");
                break;
            case "/deathNote.jpg": htmlFileBuffer = getHtmlFileInByteArray("src/Assets/deathNote.jpg");
                break;
            case "/naruto.png": htmlFileBuffer = getHtmlFileInByteArray("src/Assets/naruto.png");
                break;
            case "undefined": htmlFileBuffer = new String("<html><h1>Error 404</h1></html>").getBytes();
                break;
        }
        return htmlFileBuffer;
    }

    private byte[] getHtmlFileInByteArray(String command) {
        byte[] htmlFileBuffer = null;
        try{
            InputStream in = new FileInputStream(new File(command));
            System.out.println();
            htmlFileBuffer = new byte[in.available()];
            in.read(htmlFileBuffer);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlFileBuffer;
    }
}