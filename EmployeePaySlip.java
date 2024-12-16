// Base class Employee
class Employee {
    protected String emp_name;
    protected int emp_id;
    protected String address;
    protected String mail_id;
    protected String mobile_no;

    // Constructor to initialize Employee details
    public Employee(String emp_name, int emp_id, String address, String mail_id, String mobile_no) {
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.address = address;
        this.mail_id = mail_id;
        this.mobile_no = mobile_no;
    }
}

// Derived class Programmer
class Programmer extends Employee {
    protected double basicPay;

    public Programmer(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double DA = 0.97 * basicPay;
        double HRA = 0.10 * basicPay;
        double PF = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + DA + HRA + staffClubFund;
        double netSalary = grossSalary - PF;

        // Display Pay Slip
        System.out.println("\nPay Slip for Programmer");
        System.out.println("-------------------------");
        System.out.println("Name: " + emp_name);
        System.out.println("Designation: Programmer");
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA: $" + DA);
        System.out.println("HRA: $" + HRA);
        System.out.println("Staff Club Fund: $" + staffClubFund);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary (after PF): $" + netSalary);
    }
}

// Derived class TeamLead
class TeamLead extends Employee {
    protected double basicPay;

    public TeamLead(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double DA = 0.97 * basicPay;
        double HRA = 0.10 * basicPay;
        double PF = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + DA + HRA + staffClubFund;
        double netSalary = grossSalary - PF;

        // Display Pay Slip
        System.out.println("\nPay Slip for Team Lead");
        System.out.println("-------------------------");
        System.out.println("Name: " + emp_name);
        System.out.println("Designation: Team Lead");
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA: $" + DA);
        System.out.println("HRA: $" + HRA);
        System.out.println("Staff Club Fund: $" + staffClubFund);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary (after PF): $" + netSalary);
    }
}

// Derived class AssistantProjectManager
class AssistantProjectManager extends Employee {
    protected double basicPay;

    public AssistantProjectManager(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double DA = 0.97 * basicPay;
        double HRA = 0.10 * basicPay;
        double PF = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + DA + HRA + staffClubFund;
        double netSalary = grossSalary - PF;

        // Display Pay Slip
        System.out.println("\nPay Slip for Assistant Project Manager");
        System.out.println("----------------------------------------");
        System.out.println("Name: " + emp_name);
        System.out.println("Designation: Assistant Project Manager");
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA: $" + DA);
        System.out.println("HRA: $" + HRA);
        System.out.println("Staff Club Fund: $" + staffClubFund);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary (after PF): $" + netSalary);
    }
}

// Derived class ProjectManager
class ProjectManager extends Employee {
    protected double basicPay;

    public ProjectManager(String emp_name, int emp_id, String address, String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double DA = 0.97 * basicPay;
        double HRA = 0.10 * basicPay;
        double PF = 0.12 * basicPay;
        double staffClubFund = 0.001 * basicPay;
        double grossSalary = basicPay + DA + HRA + staffClubFund;
        double netSalary = grossSalary - PF;

        // Display Pay Slip
        System.out.println("\nPay Slip for Project Manager");
        System.out.println("------------------------------");
        System.out.println("Name: " + emp_name);
        System.out.println("Designation: Project Manager");
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA: $" + DA);
        System.out.println("HRA: $" + HRA);
        System.out.println("Staff Club Fund: $" + staffClubFund);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("Net Salary (after PF): $" + netSalary);
    }
}

// Main class to test the system
public class EmployeePaySlip {
    public static void main(String[] args) {
        // Create objects for different employees
        Programmer programmer = new Programmer("John Doe", 101, "123 Street, City", "john@example.com", "1234567890", 5000);
        TeamLead teamLead = new TeamLead("Jane Smith", 102, "456 Avenue, City", "jane@example.com", "0987654321", 7000);
        AssistantProjectManager apm = new AssistantProjectManager("Alice Brown", 103, "789 Boulevard, City", "alice@example.com", "1122334455", 9000);
        ProjectManager pm = new ProjectManager("Bob Johnson", 104, "101 Road, City", "bob@example.com", "2233445566", 12000);

        // Generate pay slips for each employee
        programmer.generatePaySlip();
        teamLead.generatePaySlip();
        apm.generatePaySlip();
        pm.generatePaySlip();
    }
}

