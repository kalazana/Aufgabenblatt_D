import java.util.Formatter;
//Florian Eimann
/**
 * @author Jasper Roloff, Matrikelnummer 18837
 */
public class Buch extends Medium {
    private Integer erscheinungsjahr;
    private String verfasser;
    private String verlag;
    private String isbn;

    /**
     * Gibt das Erscheinungsjahr des Buches zurück
     * @return Erscheinungsjahr des Buches
     */
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    /**
     * Setzt das Erscheinungsjahr des Buches
     * @param erscheinungsjahr Erscheinungsjahr
     */
    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     * Gibt die ISBN des Buches zurück
     * @return ISBN des Buches
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setzt die ISBN des Buches
     * @param isbn ISBN
     */
    public void setIsbn(String isbn) {
        if (!Buch.checkISBN(isbn)) {
            System.out.println("Fehler: ungültige ISBN!");
        }

        this.isbn = isbn;
    }

    /**
     * Gibt den Verfasser des Buches zurück
     * @return Verfasser des Buches
     */
    public String getVerfasser() {
        return verfasser;
    }

    /**
     * Setzt den Verfasser des Buches
     * @param verfasser Verfasser
     */
    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    /**
     * Gibt den Verlag des Buches zurück
     * @return Verlag des Buches
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     * Setzt den Verlag des Buches
     * @param verlag Verlag
     */
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    /**
     * Gibt die Text-Repräsentation des Buches zurück
     * @return Text-Repräsentation des Buches
     * @see Medium#calculateRepresentation()
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        // Titel
        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // ISBN
        formatter.format("ISBN: %s", this.getIsbn());
        stringBuilder.append(System.getProperty("line.separator"));

        // Erscheinungsjahr
        formatter.format("Erscheinungsjahr: %d", this.getErscheinungsjahr());
        stringBuilder.append(System.getProperty("line.separator"));

        // Verfasser
        formatter.format("Verfasser: %s", this.getVerfasser());
        stringBuilder.append(System.getProperty("line.separator"));

        // Verlag
        formatter.format("Verlag: %s", this.getVerlag());
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

        // validate field erscheinungsjahr
        if (this.erscheinungsjahr == null) {
            throw new ValidationException("erscheinungsjahr cannot be null");
        }

        // validate field isbn
        if (this.isbn == null || this.isbn.trim().equals("")) {
            throw new ValidationException("empty ISBN not allowed");
        }

        // validate field verfasser
        if (this.verfasser == null || this.verfasser.trim().equals("")) {
            throw new ValidationException("empty verfasser not allowed");
        }

        // validate field verlag
        if (this.verlag == null || this.verlag.trim().equals("")) {
            throw new ValidationException("empty verlag not allowed");
        }
    }

    /**
     * Prüft eine ISBN auf Gültigkeit
     * @return true für gültig, false für ungültig
     * @param isbn ISBN als String
     */
    public static boolean checkISBN(String isbn) {
        // TODO: more cleanup
        isbn = isbn.replace("-", "");

        isbn = isbn.replace(" ", "");

        if (isbn.length() == 10) {
            int[] isbn10 = new int[10];

            for (int i = 0; i < 10; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));

                if (digit < 0 || digit > 9) {
                    return false;
                }

                isbn10[i] = digit;
            }

            return checkISBN10(isbn10);
        } else if (isbn.length() == 13) {
            int[] isbn13 = new int[13];

            for (int i = 0; i < 13; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));

                if (digit < 0 || digit > 9) {
                    return false;
                }

                isbn13[i] = digit;
            }

            return checkISBN13(isbn13);
        } else {
            return false;
        }
    }

    /**
     * Prüft eine 10-stellige ISBN auf Gültigkeit
     * @param isbn 10-stellige ISBN als int-Array mit 10 Elementen
     * @return true für gültig, false für ungültig
     */
    private static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Prüft eine 13-stellige ISBN auf Gültigkeit
     * @param isbn 13-stellige ISBN als int-Array mit 13 Elementen
     * @return true für gültig, false für ungültig
     */
    private static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }
}