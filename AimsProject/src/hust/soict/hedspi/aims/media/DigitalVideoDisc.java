package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable {
    private int length;
    private String director;

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    
    @Override
    public void play() throws PlayerException {
        if (length > 0) {
            System.out.println("Playing DVD: " + getTitle());
            System.out.println("DVD length: " + length + " minutes");
        } else {
            throw new PlayerException("ERROR: DVD length is not non-positive!");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "DVD [Title: " + getTitle() + ", Category: " + getCategory() +
               ", Director: " + director + ", Length: " + length + " mins, Cost: " + getCost() + "]";
    }
}