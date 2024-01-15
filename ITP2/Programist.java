package ITP2;

public class Programist extends Employee {
    private int bonus;
    public Programist(int age, String name, int salary){
        super(age, name, salary);
        bonus = 1000;
    }
    public int getFullSalary(){
        return getSalary() + bonus;
    }
    public int getBonus(){
        return bonus;
    }
    public String getFullInfo(){
        return ("Name: " + getName() + "   Age: " + getAge() + "   Salary: " + getSalary() + "   Position: Programist");
    };
}
