import java.util.Date;
//Florian Eimann
public class ParserContent {
    private String link;                                                                    //Attribute nach denen geprüft wird/gesucht
    private String title;
    private String description;
    private String channel;
    private String rss;
    private String language;
    private String copyright;
    private String guid;

    public String getGuid() {                                                                           //getter und setter für alle Strings
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannel() {
         return channel;
   }

   public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
     this.rss = rss;
  }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }


    @Override
    public String toString(){                                                       //für die Ausgabe
        return this.title;
    }
}
