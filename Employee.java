package code;

import java.util.Scanner;

class Employee {
    String empName;
    int empId;
    String address;
    String mailId;
    String mobileNo;

    Employee(String empName, int empId, String address, String mailId, String mobileNo) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.mobileNo = mobileNo;
    }
}

class Programmer extends Employee {
    double basicPay;

    Programmer(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);
        System.out.println("Pay Slip for " + empName);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
    }
}

class TeamLead extends Employee {
    double basicPay;

    TeamLead(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);
        System.out.println("Pay Slip for " + empName);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
    }
}

class AssistantProjectManager extends Employee {
    double basicPay;

    AssistantProjectManager(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);
        System.out.println("Pay Slip for " + empName);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
    }
}

class ProjectManager extends Employee {
    double basicPay;

    ProjectManager(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        super(empName, empId, address, mailId, mobileNo);
        this.basicPay = basicPay;
    }

    void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - (pf + staffClubFund);
        System.out.println("Pay Slip for " + empName);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Employee Type (Programmer/TeamLead/AssistantProjectManager/ProjectManager): ");
        String type = scanner.nextLine();
        
        System.out.println("Enter Employee Name: ");
        String empName = scanner.nextLine();
        
        System.out.println("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        
        System.out.println("Enter Mail ID: ");
        String mailId = scanner.nextLine();
        
        System.out.println("Enter Mobile No: ");
        String mobileNo = scanner.nextLine();
        
        System.out.println("Enter Basic Pay: ");
        double basicPay = scanner.nextDouble();
        
        Employee employee = null;
        
        switch (type) {
            case "Programmer":
                employee = new Programmer(empName, empId, address, mailId, mobileNo, basicPay);
                break;
            case "TeamLead":
                employee = new TeamLead(empName, empId, address, mailId, mobileNo, basicPay);
                break;
            case "AssistantProjectManager":
                employee = new AssistantProjectManager(empName, empId, address, mailId, mobileNo, basicPay);
                break;
            case "ProjectManager":
                employee = new ProjectManager(empName, empId, address, mailId, mobileNo, basicPay);
                break;
            default:
                System.out.println("Invalid Employee Type");
                return;
        }
        
        if (employee instanceof Programmer) {
            ((Programmer) employee).generatePaySlip();
        } else if (employee instanceof TeamLead) {
            ((TeamLead) employee).generatePaySlip();
        } else if (employee instanceof AssistantProjectManager) {
            ((AssistantProjectManager) employee).generatePaySlip();
        } else if (employee instanceof ProjectManager) {
            ((ProjectManager) employee).generatePaySlip();
        }
        
        scanner.close();
    }
}
