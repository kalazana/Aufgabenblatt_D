import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Florian Eimann
public class MediaContentHandler implements ContentHandler {

    private String currentValue;
    private MediaSeite website = null;
    private MediaMeta websiteDaten = null;
    private MediaUserData websiteUserData = null;

    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }

    public void startElement(String uri, String localname, String qName, Attributes atts) throws SAXException {
        switch (localname) {
            case "page":
                website = new MediaSeite();
                websiteDaten = new MediaMeta();
                break;
            case "contributor":
                websiteUserData = new MediaUserData();
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (websiteUserData != null) {
            switch (localName) {
                case "ip":
                    websiteUserData.setIp(currentValue);
                    break;
                case "username":
                    websiteUserData.setUsername(currentValue);
                    break;
                case "contributor":
                    websiteDaten.setContributor(websiteUserData);
                    websiteUserData = null;
                    break;
            }
        } else if (websiteDaten != null) {
            switch (localName) {
                case "timestamp":
                    SimpleDateFormat datum = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    try {
                        Date date = datum.parse(currentValue);
                        websiteDaten.setTimestamp(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "revision":
                    website.setNeuesteMediaDaten(websiteDaten);
                    websiteDaten = null;
                    break;
            }
        } else if (website != null) {
            switch (localName) {
                case "title":
                    website.setTitel(currentValue);
                    break;
            }
        }
    }

    public MediaSeite getWebsite() throws Exception {
        if (website == null) {
            throw new Exception("Website nicht gefunden!");
        }
        return website;
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
