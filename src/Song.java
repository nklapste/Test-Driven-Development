/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 *
 * Name: Nathan Klapstein
 * ID: 1449872
 */
public class Song {
    // Assignment 6 -- complete this Song class to pass the tests
    private String artist, title;
    private Double length;

    public Song(String artist, String title, float length){
        this.artist = artist;
        this.title = title;
        this.length = (double) length;
    }
    public Song(String artist, String title, double length){
        this.artist = artist;
        this.title = title;
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public Double getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public boolean isArtist(String testArtist){
        return this.artist.toLowerCase().equals(testArtist.toLowerCase());
    }

    public boolean isTitle(String testTitle){
        return this.title.toLowerCase().equals(testTitle.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        } else {
            Song s = (Song) obj;
            return (this.isArtist(s.getArtist()) && this.isTitle(s.getTitle()) && this.length.equals(s.getLength()));
        }

    }

    @Override
    public int hashCode() {
        int hash = 7;
        // double primitive will never be null (init to 0.0 normally)
        hash = 31 * hash ^ this.artist.toLowerCase().hashCode();
        hash = 31 * hash ^ this.title.toLowerCase().hashCode();
        hash = 31 * hash ^ this.length.hashCode();
        return hash;
    }
}
