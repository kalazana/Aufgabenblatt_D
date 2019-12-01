public class WikiBuch extends Buch{
    //Florian Eimann                                                                                                                    //setzt Kapitel bzw Regal
    private String regal;
    private String kapitel;

    public String getRegal() {
        return regal;
    }

    public void setRegal(String regal) {
        this.regal = regal;
    }

    public String getKapitel() {
        return kapitel;
    }

    public void setKapitel(String kapitel) {
        this.kapitel = kapitel;
    }

    @Override
    public String toString(){
        return "Regal: " + this.regal + " \nKapitel: " + this.kapitel;
    }
}
