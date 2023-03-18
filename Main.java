package MusicPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    private static void play(LinkedList<Song> playlist) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            boolean forward = true;
            ;
            ListIterator<Song> listIterator = playlist.listIterator();

            if (playlist.size() == 0) {
                System.out.println("This playlist have no song");
            } else {
                System.out.println("Now Playing " + listIterator.next().toString());
                printMenu();
            }

            while (!quit) {
                int action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                    case 0:
                        System.out.println("PlayList completed");
                        quit = true;
                        break;

                    case 1:
                        if (!forward) {
                            if (listIterator.hasNext()) {
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing" + listIterator.next().toString());
                        } else {
                            System.out.println("No song available reached end of the list");
                            forward = false;
                        }
                        break;

                    case 2:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                listIterator.previous();
                                forward = false;
                            }
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("There is no previous song");
                            forward = false;
                        }
                        break;

                    case 3:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("We are at the start of the list");
                            }
                        } else {
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We have reached to the end of list");
                            }
                        }
                        break;

                    case 4:
                        printList(playlist);
                        break;

                    case 5:
                        printMenu();

                    case 6:
                        if (playlist.size() > 0) {
                            listIterator.remove();
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next().toString());
                            } else {
                                if (listIterator.hasPrevious())
                                    System.out.println("Now playing " + listIterator.previous().toString());
                            }
                        }

                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list of all songs\n" +
                "5 - to print al available options\n" +
                "6 - to delete current song\n");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("------------------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Album album = new Album("Album1", "AC/Dc");
        album.addSong("TNT", 4.5);
        album.addSong("Highway to hell", 3.5);
        album.addSong("ThunderStruck", 5.5);
        albums.add(album);

        album = new Album("Album2", "Eminem");
        album.addSong("Rap god", 4.5);
        album.addSong("Not Afraid", 6.5);
        album.addSong("Lose Yourself", 4.5);
        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlaylist("TNT", playlist_1);
        albums.get(0).addToPlaylist("Highway to hell", playlist_1);
        albums.get(1).addToPlaylist("Rap god", playlist_1);
        albums.get(1).addToPlaylist("Lose Yourself", playlist_1);

        play(playlist_1);

    }
}
