import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaContentHandler implements ContentHandler {

    private String currentValue;
    private MediaSeite mediaSeite = null; //Website website
    private MediaMeta mediaMeta = null;       //websiteDaten
    private MediaUserData mediaUserData = null;     //websiteuserdata

    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }

    public void startElement(String uri, String localname, String qName, Attributes atts) throws SAXException {
        switch (localname) {
            case "page":
                mediaSeite = new MediaSeite();
                break;
            case "revision":
                mediaMeta = new MediaMeta();
                break;
            case "contributor":
                mediaUserData = new MediaUserData();
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (mediaUserData != null) {
            switch (localName) {
                case "ip":
                    mediaUserData.setIp(currentValue);
                    break;
                case "username":
                    mediaUserData.setUsername(currentValue);
                    break;
                case "contributor":
                    mediaMeta.setContributor(mediaUserData);
                    mediaMeta = null;
                    break;
            }
        } else if (mediaMeta != null) {
            switch (localName) {
                case "timestamp":
                    SimpleDateFormat datum = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    try {
                        Date date = datum.parse(currentValue);
                        mediaMeta.setTimestamp(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "revision":
                    mediaSeite.setNeuesteMediaDaten(mediaMeta);
                    mediaMeta = null;
                    break;
            }
        } else if (mediaSeite != null) {
            switch (localName) {
                case "title":
                    mediaSeite.setTitel(currentValue);
                    break;
            }
        }
    }

    public MediaSeite getWebsite() throws Exception {
        if (mediaSeite == null) {
            throw new Exception("Website nicht gefunden");
        }
        return mediaSeite;
    }

    public void endDocument() throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    public void processingInstruction(String target, String data) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String name) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }
}

