package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (length > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length + " minutes");
        } else {
            System.out.println("Cannot play track: " + title + ". Length is zero or invalid.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.title.equalsIgnoreCase(other.getTitle()) && this.length == other.getLength();
        }
        return false;
    }

    // toString method
    @Override
    public String toString() {
        return "Track [Title: " + title + ", Length: " + length + " mins]";
    }
}