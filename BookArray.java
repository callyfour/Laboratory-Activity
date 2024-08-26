package library;

import java.util.ArrayList;
import java.util.List;

public class BookArray {
    private List<Book> books;

  }

 // Add a book
    public void addBook(String title, String author, String isbn, String category) {
        books.add(new Book(title, author, isbn, category));
    }
