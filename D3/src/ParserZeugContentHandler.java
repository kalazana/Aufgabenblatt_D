import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

//Florian Eimann
public class ParserZeugContentHandler implements ContentHandler {


    //Grundaufbau übernommen von http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/ aus der Vorlesung
    private String currentValue;
    private ParserZeug test = null;

    public void characters(char[] ch, int start, int length) {
        currentValue = new String(ch, start, length);
    }
    public void startElement(String uri, String localName, String qName, Attributes atts) {
        if (localName.equals("item")) {
            test = new ParserZeug();
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (test != null) {
            if (localName.equals("link")) {
                test.setLink(currentValue);
            }

            if (localName.equals("title")) {
                test.setTitle(currentValue);
            }

            if (localName.equals("description")) {
                test.setDescription(currentValue);
            }

            if (localName.equals("channel")) {
                test.setDescription(currentValue);
            }

            if (localName.equals("rss")) {
                test.setDescription(currentValue);
            }

            if (localName.equals("language")) {
                test.setDescription(currentValue);
            }

            if (localName.equals("copyright")) {
                test.setDescription(currentValue);
            }
            if (localName.equals("content:encoded")) {
                test.setDescription(currentValue);
            }

            if (localName.equals("item")) {
                System.out.println(test.getTitle());
                test = null;
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