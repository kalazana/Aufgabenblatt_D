import java.util.Formatter;

//Florian Eimann
public class CD extends Medium {
    private String label;
    private String kuenstler;

    /**
     * Gibt den Künstler der CD zurück
     * @return Künstler der CD
     */
    public String getKuenstler() {
        return kuenstler;
    }

    /**
     * Setzt den Künstler der CD
     * @param kuenstler Künstler
     */
    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }

    /**
     * Gibt das Label der CD zurück
     * @return Label der CD
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setzt das Label der CD
     * @param label Label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gibt die Text-Repräsentation der CD zurück
     * @return Text-Repräsentation der CD
     * @see Medium#calculateRepresentation()
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        // Titel
        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // Label
        formatter.format("Label: %s", this.getLabel());
        stringBuilder.append(System.getProperty("line.separator"));

        // Künstler
        formatter.format("Künstler: %s", this.getKuenstler());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }

    /**
     * validate if all fields are valid
     * @throws ValidationException thrown when at least one field isn't valid
     */
    @Override
    public void validate() throws ValidationException {
        // validate fields inherited from superclass
        super.validate();

        // validate field label
        if (this.label == null || this.label.trim().equals("")) {
            throw new ValidationException("empty label not allowed");
        }

        // validate field kuenstler
        if (this.kuenstler == null || this.kuenstler.trim().equals("")) {
            throw new ValidationException("empty kuenstler not allowed");
        }
    }
}