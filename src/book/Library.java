package book;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(ArrayList<Book> books) {
        // Create a new ArrayList containing all elements from the passed list
        this.books = new ArrayList<>(books);
    }


    public ArrayList<Book> getBooks() {
        return new ArrayList<>(this.books);
    }

    public void addBook(Book book) {
        if (book == null) {
           throw new IllegalArgumentException("Book cannot be null. Try adding a book.");
        }
        books.add(book);
    }


    public Book findBookByTitle(String title) {
        for (Book i : books) {
            if(i.getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return null;
    }


    public void printAllBooks() {
        if(books.isEmpty()) {
            System.out.println("Library contains no books!");
        } else {
            for (Book i : books) {
                System.out.println(i.toString());
            }
        }
    }


    public int removeBookByAuthor(String author) {
        int initialSize = books.size();
        // removeIf iterates safely and removes elements matching the predicate
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
        return initialSize - books.size(); // Calculate removed count
    }

}
