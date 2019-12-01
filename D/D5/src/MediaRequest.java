import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
//Florian Eimann
public class MediaRequest {
                                                                                                                                                      //Grundidee der Struktur mit Jasper Roloff erarbeitet
   public static MediaSeite readPageInfo(String title) throws Exception {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();                                                                                     //siehe Aufgabe 3 für Erklärung
        MediaContentHandler pageInfoContentHandler = new MediaContentHandler();
        xmlReader.setContentHandler(pageInfoContentHandler);
        URL url = new URL("https://de.wikibooks.org/wiki/Spezial:Exportieren/" + title);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");               //setzt User Agent, ist aber anscheinend nicht zwangsläufig notwendig, funktioniert auch ohne
        connection.setDoInput(true);
        InputStream inputStream = connection.getInputStream();
        InputSource inputSource = new InputSource(inputStream);
        xmlReader.parse(inputSource);
        MediaSeite page = pageInfoContentHandler.getMediaSeite();                                                                                     //ruft die Methode getMediaSeite aus der Klasse MediaSeite auf
        page.setUrl(url.toString());
        return page;
    }
}
