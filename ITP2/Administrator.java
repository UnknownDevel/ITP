package ITP2;

public class Administrator extends Employee {
    private int bonus;
    public Administrator(int age, String name, int salary){
        super(age, name, salary);
        bonus = 3000;
    }
    public int getFullSalary(){
        return getSalary() + bonus;
    }
    public int getBonus(){
        return bonus;
    }
    public String getFullInfo(){
        return ("Name: " + getName() + "   Age: " + getAge() + "   Salary: " + getSalary() + "   Position: Administrator");
    };
}