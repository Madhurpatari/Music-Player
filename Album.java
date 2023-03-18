package MusicPlayer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    private ArrayList<Song> songs;

    //Empty constructor
    public Album (){

    }
    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){ //add song in am album
        if(findSong(title)==null){
            songs.add(new Song(title, duration));
            //System.out.println(title+" successfully added to the list");
            return true;
        }else{
           // System.out.println("Song with name "+title+" already exist");
            return false;
        }
    }
    public Song findSong(String title){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber-1;
        if(index > 0 && index <= this.songs.size()){
            PlayList.addFirst(this.songs.get(index));
            return true;
        }
        //System.out.println("This album does not have song with trackNumber "+ trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        //System.out.println("This album does not have song with title "+ title);
        return false;
    }
    
}
