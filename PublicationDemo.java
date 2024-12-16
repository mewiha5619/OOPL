import java.util.Scanner;

// Base class Publication
class Publication {
    protected String title;
    protected double price;
    protected int copies;

    // Constructor to initialize Publication
    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    // Method to calculate the total sale (Price * Copies)
    public void saleCopy() {
        double totalSale = price * copies;
        System.out.println("Total sale for " + title + ": $" + totalSale);
    }
}

// Book class inherits from Publication
class Book extends Publication {
    private String author;

    // Constructor to initialize Book (including the author)
    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    // Method to order additional copies
    public void orderCopies(int additionalCopies) {
        copies += additionalCopies;
        System.out.println(additionalCopies + " copies of \"" + title + "\" have been ordered.");
    }

    // Method to display Book details
    public void displayBookInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Copies Available: " + copies);
    }
}

// Magazine class inherits from Publication
class Magazine extends Publication {
    private String currentIssue;

    // Constructor to initialize Magazine (including current issue)
    public Magazine(String title, double price, int copies, String currentIssue) {
        super(title, price, copies);
        this.currentIssue = currentIssue;
    }

    // Method to order additional quantity of magazines
    public void orderQty(int additionalCopies) {
        copies += additionalCopies;
        System.out.println(additionalCopies + " copies of \"" + title + "\" (Issue: " + currentIssue + ") have been ordered.");
    }

    // Method to receive the issue of the magazine
    public void receiveIssue() {
        System.out.println("New issue of \"" + title + "\" (Issue: " + currentIssue + ") received.");
    }

    // Method to display Magazine details
    public void displayMagazineInfo() {
        System.out.println("Magazine Title: " + title);
        System.out.println("Current Issue: " + currentIssue);
        System.out.println("Price: $" + price);
        System.out.println("Copies Available: " + copies);
    }
}

// Main class to demonstrate the functionality
public class PublicationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a Book object
        System.out.println("Enter Book details:");
        System.out.print("Title: ");
        String bookTitle = sc.nextLine();
        System.out.print("Price: $");
        double bookPrice = sc.nextDouble();
        System.out.print("Copies Available: ");
        int bookCopies = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Author: ");
        String bookAuthor = sc.nextLine();

        Book book = new Book(bookTitle, bookPrice, bookCopies, bookAuthor);

        // Create a Magazine object
        System.out.println("\nEnter Magazine details:");
        System.out.print("Title: ");
        String magazineTitle = sc.nextLine();
        System.out.print("Price: $");
        double magazinePrice = sc.nextDouble();
        System.out.print("Copies Available: ");
        int magazineCopies = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Current Issue: ");
        String currentIssue = sc.nextLine();

        Magazine magazine = new Magazine(magazineTitle, magazinePrice, magazineCopies, currentIssue);

        // Perform operations on Book
        System.out.println("\nBook Info:");
        book.displayBookInfo();
        System.out.print("How many additional copies would you like to order for the book? ");
        int additionalBookCopies = sc.nextInt();
        book.orderCopies(additionalBookCopies);
        book.saleCopy();

        // Perform operations on Magazine
        System.out.println("\nMagazine Info:");
        magazine.displayMagazineInfo();
        System.out.print("How many additional copies would you like to order for the magazine? ");
        int additionalMagazineCopies = sc.nextInt();
        magazine.orderQty(additionalMagazineCopies);
        magazine.receiveIssue();
        magazine.saleCopy();

        sc.close();
    }
}

