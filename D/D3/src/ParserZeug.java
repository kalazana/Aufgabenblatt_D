import java.util.Date;
//Florian Eimann
public class ParserZeug {
    private String link;
    private String title;
    private String description;
    private String channel;
    private String rss;
    private String language;
    private String copyright;


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
    public String toString(){
        return this.title;
    }
}
