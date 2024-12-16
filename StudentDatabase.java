package code;

import java.io.*;
import java.util.*;

class Student {
    int studentId;
    String name;
    String rollNo;
    String className;
    double marks;
    String address;

    public Student(int studentId, String name, String rollNo, String className, double marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.className = className;
        this.marks = marks;
        this.address = address;
    }

    @Override
    public String toString() {
        return studentId + "," + name + "," + rollNo + "," + className + "," + marks + "," + address;
    }
}

public class StudentDatabase {
    private static final String FILE_NAME = "students.txt";
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Delete Record");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createDatabase(scanner);
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    deleteRecord(scanner);
                    break;
                case 4:
                    updateRecord(scanner);
                    break;
                case 5:
                    searchRecord(scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void createDatabase(Scanner scanner) throws IOException {
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Roll No: ");
            String rollNo = scanner.nextLine();
            System.out.print("Enter Class: ");
            String className = scanner.nextLine();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();

            students.add(new Student(studentId, name, rollNo, className, marks, address));
        }

        saveToFile();
    }

    private static void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Student student : students) {
            writer.write(student.toString());
            writer.newLine();
        }
        writer.close();
    }

    private static void displayDatabase() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        System.out.println("Student Records:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    private static void deleteRecord(Scanner scanner) throws IOException {
        System.out.print("Enter Student ID to delete: ");
        int studentId = scanner.nextInt();
        students.removeIf(student -> student.studentId == studentId);
        saveToFile();
    }

    private static void updateRecord(Scanner scanner) throws IOException {
        System.out.print("Enter Student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.print("Enter new Name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter new Roll No: ");
                student.rollNo = scanner.nextLine();
                System.out.print("Enter new Class: ");
                student.className = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                student.marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new Address: ");
                student.address = scanner.nextLine();
                break;
            }
        }
        saveToFile();
    }

    private static void searchRecord(Scanner scanner) throws IOException {
        System.out.print("Enter Student ID to search: ");
        int studentId = scanner.nextInt();
        for (Student student : students) {
            if (student.studentId == studentId) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}