import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MediaRequest {

    private static MediaSeite readPageInfo(String title) throws Exception {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        MediaContentHandler pageInfoContentHandler = new MediaContentHandler();
        xmlReader.setContentHandler((ContentHandler) pageInfoContentHandler);
        URL url = new URL("https://de.wikibooks.org/wiki/Spezial:Exportieren/" + title);
        URLConnection connection = url.openConnection();
        // setting user-agent isn't needed, it works also without setting it
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_1) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Safari/605.1.15");
        connection.setDoInput(true);
        InputStream inStream = connection.getInputStream();
        InputSource inputSource = new InputSource(inStream);
        xmlReader.parse(inputSource);
        MediaSeite page = pageInfoContentHandler.getSeite();
        page.setUrl(url.toString());
        return page;
    }
}
