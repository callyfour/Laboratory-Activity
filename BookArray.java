package library;

import java.util.ArrayList;
import java.util.List;

public class BookArray {
    private List<Book> books;

    // Constructor
    public BookArray() {
        books = new ArrayList<>();
    }

 // Add a book
    public void addBook(String title, String author, String isbn, String category) {
        books.add(new Book(title, author, isbn, category));
    }

    // Remove a book by index
    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }
    // Get a book by index
    public Book getBook(int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }

}
