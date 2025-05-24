package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(int id, String title, String category, String director, String artist, int length, float cost) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "CD [Title: " + getTitle() + ", Category: " + getCategory() + ", Director: " + getDirector() +
               ", Artist: " + artist + ", Length: " + getLength() + " mins, Cost: " + getCost() + "]";
    }
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                throw new PlayerException("ERROR: Failed to play track");
            }
        }
    }

}
