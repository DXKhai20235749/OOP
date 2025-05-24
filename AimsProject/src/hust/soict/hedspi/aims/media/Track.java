package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

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
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length + " minutes");
        } else {
        	throw new PlayerException("ERROR: DVD length is non-positive!");
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