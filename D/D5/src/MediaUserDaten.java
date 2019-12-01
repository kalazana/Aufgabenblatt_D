public class MediaUserDaten {
    //Florian Eimann
    private String username;                                                                                                        //Username und IP
    private String ip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {                                                                                                       //Falls weder Username noch IP gesetzt gibt er Fehlermeldung zuürck, falls nur eins vorhanden, gibt er das jeweilige aus, falls beides vorhanden gibt er beides aus
        if (username == null && ip == null) {
            return "Fehler kein Benutzer vorhanden!";
        } else if (ip != null && username == null) {
            return ip + "IP";
        } else if (username != null && ip == null) {
            return username;
        } else {
            return "IP: "+ this.ip + "von Benutzer: " + this.username;
        }
    }
}
