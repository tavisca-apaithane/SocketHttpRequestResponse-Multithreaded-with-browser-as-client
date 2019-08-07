import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResponseFileFactory {
    private String indexFilePath="src/Assets/MyIndex.html";
    private String homeFilePath="src/Assets/home.html";
    private String deathNoteImagePath="src/Assets/deathNote.jpg";
    private String narutoImagePath="src/Assets/naruto.png";
    public ResponseFileFactory(){}
    public byte[] generate(String command)
    {
        byte[] htmlFileBuffer = null;
        System.out.println("COMMAND :" + command);
        switch (command)
        {
            case "/index.html": htmlFileBuffer = getHtmlFileInByteArray(indexFilePath);
                break;
            case "/home.html" : htmlFileBuffer = getHtmlFileInByteArray(homeFilePath);
                break;
            case "/": htmlFileBuffer = getHtmlFileInByteArray(indexFilePath);
                break;
            case "/deathNote.jpg": htmlFileBuffer = getHtmlFileInByteArray(deathNoteImagePath);
                break;
            case "/naruto.png": htmlFileBuffer = getHtmlFileInByteArray(narutoImagePath);
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