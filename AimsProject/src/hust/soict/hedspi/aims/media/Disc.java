package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    private int length;      // Length of the disc (in minutes or seconds)
    private String director; // Director of the disc (for DVDs)

    // Constructor for Disc
    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);  // Call correct constructor of Media
        this.director = director;
        this.length = length;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }

    // Override toString to return appropriate format for Disc
    @Override
    public String toString() {
        return "Disc [Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ", Director: " + director + ", Length: " + length + " mins]";
    }

}