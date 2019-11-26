import java.util.ArrayList;

public class D4Main {


    public static void main(String[] args) {

        String[] team = { "team\n" };
        final String person = "person";
        final String vorname = "vorname";
        final String nachname = "nachname";
        final String alias = "alias";

        String test = "<team>\n" +
                "<person><vorname>Norrin</vorname><nachname>Radd</nachname><alias>Silver\n" +
                "Surfer</alias></person>\n" +
                "<person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das\n" +
                "Ding</alias></person></team>";

        String testohnetabs = test.replaceAll("[\\s]+", "");

        ArrayList<String> Zeichen = new ArrayList<>();

        for (int i = 0; i < testohnetabs.length(); i++) {
            Zeichen.add(String.valueOf(testohnetabs.charAt(i)));
        }

        int e =
        int c = testohnetabs.indexOf("<vorname>")+9;
        int d = testohnetabs.indexOf("</vorname>");
        System.out.println(testohnetabs.substring(c,d));
        ArrayList<String> Personen = new ArrayList<>();
        ArrayList<String> Vorname = new ArrayList<>();
        ArrayList<String> Nachname = new ArrayList<>();
        ArrayList<String> Alias = new ArrayList<>();

        }
    }

