import java.io.*;
//Florian Eimann
public class BinaryPersistency implements Persistency {
    /**
     * @see Persistency
     * @param zk a Zettelkasten instance
     * @param filename path to file where to save
     * @throws IOException e.g. file not found
     */
    @Override
    public void save(Zettelkasten zk, String filename) throws IOException {
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream(filename));
        output.writeObject(zk);
        output.close();
    }

    /**
     * @see Persistency
     * @param filename from which file to load
     * @return a Zettelkasten instance
     * @throws IOException e.g. file not found
     * @throws ClassNotFoundException in case of parsing error
     */
    @Override
    public Zettelkasten load(String filename) throws IOException, ClassNotFoundException {
        ObjectInput input = new ObjectInputStream(new FileInputStream(filename));
        Zettelkasten zk = (Zettelkasten) input.readObject();
        input.close();
        return zk;
    }
}