import java.text.SimpleDateFormat;
import java.util.Date;
//Florian Eimann
public class MediaDaten { //revision

    private Date timestamp;
    private MediaUserDaten contributor;


    public MediaUserDaten getContributor() {
        return contributor;
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
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm 'Uhr' (z)");
        return "Urheber: " + this.contributor + System.lineSeparator() + "Letzte Änderung: " + dateFormat.format(timestamp);
    }
}
