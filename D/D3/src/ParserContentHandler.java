import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

//Florian Eimann
public class ParserContentHandler implements ContentHandler {

    //Gurndaufbau übernommen aus der Vorlesung
    private String currentValue;
    private ParserContent parserContent = null;

    public void characters(char[] ch, int start, int length) {

        currentValue = new String(ch, start, length);
    }
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (localName.equals("item")) {                                                                 //"Startbedingung" zum parsen
            parserContent = new ParserContent();
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (parserContent != null) {                                                                       //falls ParserConten nicht null ist geht er das XML Dokument durch und setzt den jeweiligen Text für jeden Treffer
            if (localName.equals("link")) {
                parserContent.setLink(currentValue);
            }

            if (localName.equals("title")) {
                parserContent.setTitle(currentValue);
            }

            if (localName.equals("description")) {
                parserContent.setDescription(currentValue);
            }

            if (localName.equals("channel")) {
                parserContent.setDescription(currentValue);
            }

            if (localName.equals("rss")) {
                parserContent.setDescription(currentValue);
            }

            if (localName.equals("language")) {
                parserContent.setDescription(currentValue);
            }

            if (localName.equals("copyright")) {
                parserContent.setDescription(currentValue);
            }
            if (localName.equals("content")) {
                parserContent.setDescription(currentValue);
            }
            if (localName.equals("item")) {
                System.out.println(parserContent.getTitle());
                parserContent = null;
            }
        }
    }

    public void endDocument(){}
    public void endPrefixMapping(String prefix){}
    public void ignorableWhitespace(char[] ch, int start, int length){}
    public void processingInstruction(String target, String data){}
    public void setDocumentLocator(Locator locator) {}
    public void skippedEntity(String name) {}
    public void startDocument() {}
    public void startPrefixMapping(String prefix, String uri){}
}