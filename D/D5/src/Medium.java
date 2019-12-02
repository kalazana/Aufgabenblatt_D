import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

//Florian Eimann
public abstract class Medium implements Comparable<Medium>, Serializable {
    private String titel;

    @XmlRootElement                                                                                                                              //Speicherung von XML

    /**
     * Gibt den Titel des Mediums zurück
     * @return Titel des Mediums
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setzt den Titel des Mediums
     *
     * @param titel Titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Gibt die Text-Repräsentation des Mediums zurück
     *
     * @return Text-Repräsentation des Mediums
     */
    public abstract String calculateRepresentation();

    /**
     * validate if all fields are valid
     *
     * @throws ValidationException thrown when at least one field isn't valid
     */
    public void validate() throws ValidationException {
        // validate field titel
        if (this.titel == null || this.titel.trim().equals("")) {
            throw new ValidationException("empty title not allowed");
        }
    }

    ;

    @Override
    public int compareTo(Medium o) {
        return this.getTitel().compareTo(o.getTitel());
    }

    static class ValidationException extends Exception {
        ValidationException(String message) {
            super(message);
        }
    }
}