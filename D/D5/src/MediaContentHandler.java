import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;

public class MediaContentHandler{


        //Grundaufbau übernommen von http://blog.mynotiz.de/programmieren/java-sax-parser-tutorial-773/ aus der Vorlesung
        private String currentValue;
        private MediaSeite mediaSeite = null;

        public void characters(char[] ch, int start, int length) {

            currentValue = new String(ch, start, length);
        }
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            if (localName.equals("item")) {
                parserZeug = new ParserZeug();
            }
        }
        public void endElement(String uri, String localName, String qName) {
            if (parserZeug != null) {
                if (localName.equals("link")) {
                    parserZeug.setLink(currentValue);
                }

                if (localName.equals("title")) {
                    parserZeug.setTitle(currentValue);
                }

                if (localName.equals("description")) {
                    parserZeug.setDescription(currentValue);
                }

                if (localName.equals("channel")) {
                    parserZeug.setDescription(currentValue);
                }

                if (localName.equals("rss")) {
                    parserZeug.setDescription(currentValue);
                }

                if (localName.equals("language")) {
                    parserZeug.setDescription(currentValue);
                }

                if (localName.equals("copyright")) {
                    parserZeug.setDescription(currentValue);
                }
                if (localName.equals("content")) {
                    parserZeug.setDescription(currentValue);
                }
                if (localName.equals("item")) {
                    System.out.println(parserZeug.getTitle());
                    parserZeug = null;
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

