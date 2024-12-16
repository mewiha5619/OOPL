package code;
import java.util.Scanner;

// Base class
class Publication {
    protected String title;
    protected double price;
    protected int copies;

    // Constructor
    public Publication(String title, double price, int copies) {
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    // Method to sell copies
    public void saleCopy(int quantity) {
        if (quantity <= copies) {
            copies -= quantity;
            System.out.println(quantity + " copies of " + title + " sold.");
        } else {
            System.out.println("Not enough copies available for " + title);
        }
    }

    // Method to get total sale
    public double getTotalSale() {
        return price * (copies);
    }

    // Method to display publication details
    public void displayDetails() {
        System.out.println("Title: " + title + ", Price: " + price + ", Copies available: " + copies);
    }
}

// Book class
class Book extends Publication {
    private String author;

    // Constructor
    public Book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
    }

    // Method to order copies
    public void orderCopies(int quantity) {
        copies += quantity;
        System.out.println(quantity + " copies of " + title + " ordered.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Author: " + author);
    }
}

// Magazine class
class Magazine extends Publication {
    private String currentIssue;

    // Constructor
    public Magazine(String title, double price, int copies, String currentIssue) {
        super(title, price, copies);
        this.currentIssue = currentIssue;
    }

    // Method to order quantity
    public void orderQty(int quantity) {
        copies += quantity;
        System.out.println(quantity + " copies of " + title + " ordered.");
    }

    // Method to receive issue
    public void receiveIssue(String issue) {
        currentIssue = issue;
        System.out.println("Received issue: " + currentIssue + " for " + title);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Current Issue: " + currentIssue);
    }
}

// Main class to demonstrate functionality
public class PublicationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Book
        System.out.print("Enter the title of the book: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter the price of the book: ");
        double bookPrice = scanner.nextDouble();
        System.out.print("Enter the number of copies of the book: ");
        int bookCopies = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the author of the book: ");
        String bookAuthor = scanner.nextLine();

        // Create Book instance
        Book book1 = new Book(bookTitle, bookPrice, bookCopies, bookAuthor);

        // Input for Magazine
        System.out.print("Enter the title of the magazine: ");
        String magazineTitle = scanner.nextLine();
        System.out.print("Enter the price of the magazine: ");
        double magazinePrice = scanner.nextDouble();
        System.out.print("Enter the number of copies of the magazine: ");
        int magazineCopies = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the current issue of the magazine: ");
        String magazineIssue = scanner.nextLine();

        // Create Magazine instance
        Magazine magazine1 = new Magazine(magazineTitle, magazinePrice, magazineCopies, magazineIssue);

        // Display details
        book1.displayDetails();
        magazine1.displayDetails();

        // Order and sell copies of the book
        System.out.print("Enter the number of copies to order for the book: ");
        int orderBookQty = scanner.nextInt();
        book1.orderCopies(orderBookQty);

        System.out.print("Enter the number of copies to sell for the book: ");
        int sellBookQty = scanner.nextInt();
        book1.saleCopy(sellBookQty);

        // Order and sell copies of the magazine
        System.out.print("Enter the number of copies to order for the magazine: ");
        int orderMagazineQty = scanner.nextInt();
        magazine1.orderQty(orderMagazineQty);

        System.out.print("Enter the number of copies to sell for the magazine: ");
        int sellMagazineQty = scanner.nextInt();
        magazine1.saleCopy(sellMagazineQty);
    }
}