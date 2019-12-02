import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLPersistency implements Persistency{
    
    @Override
    public void save(Zettelkasten zk, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Zettelkasten.class);
        Marshaller m = context.createMarshaller();
        // pretty print
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(zk, new File(filename));
    }

    @Override
    public Zettelkasten load(String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Zettelkasten.class);
        Unmarshaller um = context.createUnmarshaller();
        return (Zettelkasten) um.unmarshal(new File(filename));
    }
}
