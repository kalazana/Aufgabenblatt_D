import java.io.IOException;


public interface Persistency {
    /**
     * @param zk a Zettelkasten instance
     * @param filename path to file where to save
     * @throws IOException e.g. file not found
     */
    public void save(Zettelkasten zk, String filename) throws IOException;

    /**
     * @param filename from which file to load
     * @return a Zettelkasten instance
     * @throws IOException e.g. file not found
     * @throws ClassNotFoundException in case of parsing error
     */
    public Zettelkasten load(String filename) throws IOException, ClassNotFoundException;
}