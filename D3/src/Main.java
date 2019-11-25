import java.net.*;
import java.io.*;

//Florian Eimann

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.tagesschau.de/xml/rss2");
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inStream));
            String line = "";
            while ((line = input.readLine()) != null) System.out.println(line);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

