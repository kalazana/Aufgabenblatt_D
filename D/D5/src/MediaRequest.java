import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MediaRequest {

   public static MediaSeite readPageInfo(String title) throws Exception {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MediaContentHandler pageInfoContentHandler = new MediaContentHandler();
        xmlReader.setContentHandler(pageInfoContentHandler);
        URL url = new URL("https://de.wikibooks.org/wiki/Spezial:Exportieren/" + title);
        URLConnection connection = url.openConnection();
        // setting user-agent isn't needed, it works also without setting it
        // connection.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");
        connection.setDoInput(true);
        InputStream inputStream = connection.getInputStream();
        InputSource inputSource = new InputSource(inputStream);
        xmlReader.parse(inputSource);
        MediaSeite page = pageInfoContentHandler.getWebsite();
        page.setUrl(url.toString());
        return page;
    }
}
