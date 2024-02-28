package stream;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {

    public static void main(String[] args) {
        ArrayList<Book> books = populateLibrary();

        books.stream().filter(book -> {
            return book.getAuthor().startsWith("J");
        }).forEach(System.out::println);

//        books.stream().filter(book -> book.getAuthor().startsWith("J")).forEach(System.out::println);

//        for (Book book : books) {
//            if (book.getAuthor().startsWith("J")) {
//                System.out.println(book);
//            }
//        }


    }

    private static ArrayList<Book> populateLibrary() {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Alice Walker", "The color Purple"));
        books.add(new Book("Alice Walker", "Meridian"));
        books.add(new Book("Toni Morrison", "Beloved"));
        books.add(new Book("Toni Morrison", "Jazz"));
        books.add(new Book("Toni Morrison", "Paradise"));
        books.add(new Book("John Steinbeck", "The Grapes of Wrath"));
        books.add(new Book("John Steinbeck", "East of Eden"));
        books.add(new Book("Kazuo Ishiguro", "The Remains of the Day"));
        books.add(new Book("Kazuo Ishiguro", "Never Let Me Go"));
        books.add(new Book("Kazuo Ishiguro", "The Buried Gaint"));
        books.add(new Book("Jane Austen", "Pride and Prejudice"));
        books.add(new Book("Jane Austen", "Emma"));
        books.add(new Book("Jane Austen", "Persuasion"));
        books.add(new Book("Jane Austen", "Mansfield Park"));
        books.add(new Book("Chinua Achebe", "Things Fall Apart"));
        books.add(new Book("Chinua Achebe", "No Longer at Ease"));
        books.add(new Book("Chinua Achebe", "Home and Exile"));

        return books;

    }

}
