public class Bibliothek {
        //Florian Eimann
    public static void main(String[] args) throws Medium.ValidationException, Exception {
        Zettelkasten zettelkasten = new Zettelkasten();                                                          //Aufgabenblatt C von Jasper Roloff übernommen!

        if (args.length < 1) {                                                                                  //guckt ob der Titel gesetzt wurde bzw ob er mindestens 1 Zeichen lang ist
            throw new Exception("Kein Titel angegeben!");
        }
        final String title = args[0];
        System.out.println(title);
        try {
            System.out.println(MediaRequest.readPageInfo(title).getNeusteMediaDaten());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("XML wird gespeichert");                                                               //testen
            new XMLPersistency().save(zettelkasten, "/zettelkasten.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("XML wird geladen");
            for (Medium medium : new XMLPersistency().load("/zettelkasten.xml")) {
                System.out.println(medium.calculateRepresentation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* Buch buch = new Buch();
        buch.setTitel("Duden 01. Die deutsche Rechtschreibung");
        buch.setVerfasser("-");
        buch.setVerlag("Bibliographisches Institut, Mannheim");
        buch.setIsbn("3-411-04013-0");
        buch.setErscheinungsjahr(2004);
        zettelkasten.addMedium(buch);

        CD cd = new CD();
        cd.setTitel("1");
        cd.setLabel("Apple (Bea (EMI)");
        cd.setKuenstler("The Beatles");
        zettelkasten.addMedium(cd);

        Zeitschrift zeitschrift = new Zeitschrift();
        zeitschrift.setTitel("Der Spiegel");
        zeitschrift.setVolume(54);
        zeitschrift.setNummer(6);
        zeitschrift.setIssn("0038-7452");
        zettelkasten.addMedium(zeitschrift);

        ElektronischesMedium elektronischesMedium = new ElektronischesMedium();
        elektronischesMedium.setTitel("Hochschule Stralsund");
        elektronischesMedium.setUrl("http://www.hochschule-stralsund.de");
        zettelkasten.addMedium(elektronischesMedium);

        zettelkasten.sort();

        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());
        }

*/

        /*try {
            new DatabasePersistency("localhost", "lpsw").save(zettelkasten, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("loading:");
            Zettelkasten zkNew = new DatabasePersistency("localhost", "lpsw").load(null);
            for (Medium medium : zkNew) {
                System.out.println(medium.calculateRepresentation());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
