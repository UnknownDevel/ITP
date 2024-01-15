package ITP2;

public class Manager extends Employee {
    private int bonus;
    public Manager(int age, String name, int salary){
        super(age, name, salary);
        bonus = 2000;
    }
    public Manager(int age, String name){
        super(age, name);
        bonus = 2000;
    }
    public int getFullSalary(){
        return getSalary() + bonus;
    }
    public int getBonus(){
        return bonus;
    }
    public String getFullInfo(){
        return ("Name: " + getName() + "   Age: " + getAge() + "   Salary: " + getFullSalary() + "   Position: Manager");
    }
}
