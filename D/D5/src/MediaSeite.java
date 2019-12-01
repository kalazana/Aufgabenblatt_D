public class MediaSeite extends ElektronischesMedium {
//Florian Eimann
    private MediaDaten neuesteMediaDaten;                                                                                               //gibt die neuesten Daten zurück die alle in dem ContenHandler gesetzt wurden

    public MediaDaten getNeusteMediaDaten() {
        return neuesteMediaDaten;
    }

    public void setNeuesteMediaDaten(MediaDaten neuesteMediaDaten) {
        this.neuesteMediaDaten = neuesteMediaDaten;
    }
}


