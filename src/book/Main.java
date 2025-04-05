package book;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book b2 = new Book("1984", "George Orwell", 1949);
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        Library books = new Library();

        books.printAllBooks();

        books.addBook(b1);
        books.addBook(b2);
        books.addBook(b3);


        System.out.println(books.findBookByTitle("To Kill a MockingbirD"));


        books.printAllBooks();


    }
}
