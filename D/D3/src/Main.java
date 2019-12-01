import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.net.*;
import java.io.*;

//Florian Eimann

public class Main {
    public static void main(String[] args) {                                                        //Aus Vorlesung übernommen und erweitert, stellt Verbdinunsg zum RSS Feed der Tagesschau her
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();                               // ersfellt neuen XML Reader
            ParserContentHandler parserZeugContentHandler = new ParserContentHandler();             //erstellt neuen ContentHandler
            xmlReader.setContentHandler(parserZeugContentHandler);                                  //setzt Reader auf den ContenHandler
            URL url = new URL("http://www.tagesschau.de/xml/rss2");                            //setzt die URL
            URLConnection connection = url.openConnection();                                        //stellt Verbidnung her
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();                                      //holt die Daten
            InputSource inputSource = new InputSource(inStream);
            xmlReader.parse(inputSource);                                                            //parsed die InpoutSource
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

