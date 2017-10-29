import java.util.Comparator;
import java.util.HashSet;

/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
@SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.Vector<E> {
    // TODO: Assignment 6 -- complete this Playlist class to pass the tests
    java.util.Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!

    private String title;

    public Playlist(String Title){
        super(0, 1);
        this.title = Title;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean addtoPlist(E addSong){
        // ensure song added is not null
        if(addSong == null){
            return false;
            // ensure no adding of duplicates
        } else if (this.findSong(addSong) >= 0){
            return false;
        }
        return this.add(addSong);
    }

    public boolean removeFromPlist(E removeSong){
        return  this.remove(removeSong);
    }

    public Song getSong(int songIndex){
        return this.elementAt(songIndex);
    }

    public boolean hasTitle(String testTitle){
        return this.title.equals(testTitle);
    }

    public boolean hasArtist(String testArtist){
        for (E song : this) {
            if (song.isArtist(testArtist)) {
                return true;
            }
        }
        return false;
    }

    public int numberOfSongs(){
        int count = 0;
        for (E song : this) {
            count++;
        }
        return count;
    }

    public int numberOfArtists(){
        HashSet<String> noDupSet = new HashSet<>();
        for (E song : this) {
            noDupSet.add(song.getArtist());
        }
        return noDupSet.size();
    }

    public int numberOfTitles() {
        HashSet<String> noDupSet = new HashSet<>();
        for (E song : this) {
            noDupSet.add(song.getTitle());
        }
        return noDupSet.size();
    }

    public Double playTime() {
        Double playTime = 0.0;
        for (E song : this) {
            playTime += song.getLength();
        }
        return playTime;
    }

    public int findSong(E song) {
        return this.indexOf(song);
    }

    public void sortByArtist() {
        this.sort(new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.getArtist().compareTo(s2.getArtist());
            }
        });
    }

    public void sortByTitle() {
        this.sort(new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.getTitle().compareTo(s2.getTitle());
            }
        });
    }
}
