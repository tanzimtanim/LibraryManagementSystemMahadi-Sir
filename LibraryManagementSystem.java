//Salman Hossain Tanim
//id- 42230100454
import java.util.ArrayList;
abstract class Book {
    private String title;
    private String author;
    private double price;

    // Constructor to initialize book details
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
    public abstract void displayDetails();
}

// Subclass for textbooks (Inheritance: Extends the Book class)
class TextBook extends Book {
    private String subject;

    // Constructor to initialize
    public TextBook(String title, String author, double price, String subject) {
        super(title, author, price); // Call the parent constructor
        this.subject = subject;
    }

    @Override
    public void displayDetails() {
        System.out.println("TextBook: " + getTitle() + " by " + getAuthor());
        System.out.println("Subject: " + subject);
        System.out.println("Price: $" + getPrice());
    }
}

//Inheritance: Extends the Book class
class Novel extends Book {
    private String genre;

    // Constructor 
    public Novel(String title, String author, double price, String genre) {
        super(title, author, price); // Call the parent
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("Novel: " + getTitle() + " by " + getAuthor());
        System.out.println("Genre: " + genre);
        System.out.println("Price: $" + getPrice());
    }
}

//Manage Libary
class Library {
    private ArrayList<Book> books = new ArrayList<>(); // Encapsulation: Books list is private
    public void addBook(Book book) {
        books.add(book);
    }

    // Display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) { // Polymorphism
                book.displayDetails();
                System.out.println("---------------------");
            }
        }
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(); // Create a library

        // Add books to the library
        library.addBook(new TextBook("Introduction to Java", "John Doe", 29.99, "Programming")); // Inheritance
        library.addBook(new Novel("Mystery of the Blue Train", "Agatha Christie", 15.50, "Mystery")); // Inheritance
        library.displayBooks(); // Polymorphism
    }
}
