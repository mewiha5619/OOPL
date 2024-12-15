class Employee{
    String name, add, mail;
    float id, mobile,basic;
    void salary()
    {
        float da,hra,pf,cf,gross;
        da = basic * 97/100;
        hra = basic * 10/100;
        pf = basic * 12/100;
        cf = basic * 0.1f/100;
        gross = basic + da + hra - pf - cf;
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basic);
        System.out.println("Gross Salary: " + gross);
    }
}
class Programmer extends Employee{
    Programmer(String name,int sal){
        this.name = name;
        basic = sal;
    }
}
class Assistant_Professor extends Employee{
    Assistant_Professor(String name,int sal){
        this.name = name;
        basic = sal;
    }
}
class Associate_Professor extends Employee{
    Associate_Professor(String name,int sal){
        this.name = name;
        basic = sal;
    }
}
class Professor extends Employee{
    Professor(String name,int sal){
        this.name = name;
        basic = sal;
    }
}
public class Inheritance{
    public static void main(String args[]){
        Assistant_Professor ast = new Assistant_Professor("Jai",40000);
        ast.salary();
        Associate_Professor aso = new Associate_Professor("Satyajeet",60000);
        aso.salary();
        Professor pro = new Professor("Ram",75000);
        pro.salary();
        Programmer pm = new Programmer("Akash",100000);
        pm.salary();
    }
}