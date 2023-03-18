package MusicPlayer;
public class Song {
    String title;
    double duration;

    Song(){
    }

    Song(String title, double duration){
        this.title = title;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Song: ").append(title).append("\n");
        sb.append("Duration: ").append(duration).append("\n");
        return sb.toString();
    }

}
