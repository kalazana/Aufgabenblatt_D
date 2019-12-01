import java.text.SimpleDateFormat;
import java.util.Date;
//Florian Eimann
public class MediaDaten { //revision

    private Date timestamp;                                                                                                         //Datum der letzten Änderung
    private MediaUserDaten contributor;//Autor
    private WikiBuch lagerOrt;

    public MediaUserDaten getContributor() {
        return contributor;
    }

    public WikiBuch getLagerOrt() {
        return lagerOrt;
    }

    public void setLagerOrt(WikiBuch lagerOrt) {
        this.lagerOrt = lagerOrt;
    }

    public void setContributor(MediaUserDaten contributor) {
        this.contributor = contributor;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {                                                                                                      //String Builder für Autor, Zeit und Lagerort
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm 'Uhr' (z)");
        return lagerOrt + "\nUrheber: " + this.contributor + System.lineSeparator() + "Letzte Änderung: " + dateFormat.format(timestamp);
    }
}
