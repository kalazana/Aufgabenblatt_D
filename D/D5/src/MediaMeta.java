import java.text.SimpleDateFormat;
import java.util.Date;
//Florian Eimann
public class MediaMeta { //revision

    private Date timestamp;
    private MediaUserData contributor;

    public MediaUserData getContributor() {
        return contributor;
    }

    public void setContributor(MediaUserData contributor) {
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
