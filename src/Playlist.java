import java.util.HashSet;

/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
@SuppressWarnings("serial")
public class Playlist<E extends Song> extends java.util.Vector<E> {
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
        for (E Song: this){
            if(Song.isArtist(testArtist)){
                return true;
            }
        }
        return false;
    }

    public int numberOfSongs(){
        int count = 0;
        for (E Song: this){
            count++;
        }
        return count;
    }

    public int numberOfArtists(){
        HashSet<String> noDupSet = new HashSet<String>();
        for (E Song: this){
            noDupSet.add(Song.getArtist());
        }
        return noDupSet.size();
    }

    public int numberOfTitles() {
        HashSet<String> noDupSet = new HashSet<String>();
        for (E Song: this){
            noDupSet.add(Song.getTitle());
        }
        return noDupSet.size();
    }

    public Double playTime() {
        Double playTime = 0.0;
        for (E Song: this){
            playTime += Song.getLength();
        }
        return playTime;
    }

    public int findSong(E song) {
        return this.indexOf(song);
    }

    // TODO: Assignment 6 -- complete this Playlist class to pass the tests
}
