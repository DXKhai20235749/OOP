package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Add authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists!");
        }
    }

    // Remove authors
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found!");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Book [Title: " + getTitle() + ", Category: " + getCategory() +
               ", Authors: " + authors + ", Cost: " + getCost() + "]";
    }
}