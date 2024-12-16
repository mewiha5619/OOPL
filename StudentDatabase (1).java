import java.io.*;
import java.util.*;

class Student {
    String studentId;
    String name;
    String rollNo;
    String studentClass;
    String marks;
    String address;

    // Constructor to initialize student details
    public Student(String studentId, String name, String rollNo, String studentClass, String marks, String address) {
        this.studentId = studentId;
        this.name = name;
        this.rollNo = rollNo;
        this.studentClass = studentClass;
        this.marks = marks;
        this.address = address;
    }

    // Method to display student details
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Roll No: " + rollNo + ", Class: " + studentClass + ", Marks: " + marks + ", Address: " + address;
    }

    // Method to convert student object to string for file writing
    public String toFileString() {
        return studentId + "," + name + "," + rollNo + "," + studentClass + "," + marks + "," + address;
    }
}

public class StudentDatabase{

    // Create the database (write to file)
    public static void createDatabase() {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fileWriter = new FileWriter("student_database.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            System.out.print("Enter the number of students you want to add: ");
            int numStudents = sc.nextInt();
            sc.nextLine();  // Consume the newline

            for (int i = 0; i < numStudents; i++) {
                System.out.println("\nEnter student details:");
                System.out.print("Enter Student ID: ");
                String studentId = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Roll No: ");
                String rollNo = sc.nextLine();
                System.out.print("Enter Class: ");
                String studentClass = sc.nextLine();
                System.out.print("Enter Marks: ");
                String marks = sc.nextLine();
                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                Student student = new Student(studentId, name, rollNo, studentClass, marks, address);
                writer.write(student.toFileString());
                writer.newLine();
            }

            writer.close();
            System.out.println("\nDatabase Created Successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while creating the database.");
            e.printStackTrace();
        }
    }

    // Display all student records
    public static void displayDatabase() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("student_database.txt"));
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                Student student = new Student(studentData[0], studentData[1], studentData[2], studentData[3], studentData[4], studentData[5]);
                System.out.println(student);
                found = true;
            }

            if (!found) {
                System.out.println("No records found in the database.");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while displaying the database.");
            e.printStackTrace();
        }
    }

    // Delete a student record based on student ID
    public static void deleteRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Student ID to delete: ");
        String studentIdToDelete = sc.nextLine();

        try {
            File inputFile = new File("student_database.txt");
            File tempFile = new File("temp_student_database.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData[0].equals(studentIdToDelete)) {
                    found = true;
                    continue;  // Skip writing this line to delete the record
                }
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            if (found) {
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                } else {
                    System.out.println("Failed to delete the original file.");
                }
                System.out.println("Record Deleted Successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while deleting the record.");
            e.printStackTrace();
        }
    }

    // Update a student record based on student ID
    public static void updateRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Student ID to update: ");
        String studentIdToUpdate = sc.nextLine();

        try {
            File inputFile = new File("student_database.txt");
            File tempFile = new File("temp_student_database.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData[0].equals(studentIdToUpdate)) {
                    found = true;
                    System.out.println("Enter new details for the student:");

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll No: ");
                    String rollNo = sc.nextLine();
                    System.out.print("Enter Class: ");
                    String studentClass = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    String marks = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    Student updatedStudent = new Student(studentIdToUpdate, name, rollNo, studentClass, marks, address);
                    writer.write(updatedStudent.toFileString());
                    writer.newLine();
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();

            if (found) {
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                } else {
                    System.out.println("Failed to delete the original file.");
                }
                System.out.println("Record Updated Successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while updating the record.");
            e.printStackTrace();
        }
    }

    // Search for a student record based on student ID
    public static void searchRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Student ID to search: ");
        String studentIdToSearch = sc.nextLine();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("student_database.txt"));
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                if (studentData[0].equals(studentIdToSearch)) {
                    Student student = new Student(studentData[0], studentData[1], studentData[2], studentData[3], studentData[4], studentData[5]);
                    System.out.println("Record Found:");
                    System.out.println(student);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student ID not found.");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while searching the record.");
            e.printStackTrace();
        }
    }

    // Main Menu function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Student Database Menu:");
            System.out.println("1. Create Database");
            System.out.println("2. Display Database");
            System.out.println("3. Delete Record");
            System.out.println("4. Update Record");
            System.out.println("5. Search Record");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createDatabase();
                    break;
                case 2:
                    displayDatabase();
                    break;
                case 3:
                    deleteRecord();
                    break;
                case 4:
                    updateRecord();
                    break;
                case 5:
                    searchRecord();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

