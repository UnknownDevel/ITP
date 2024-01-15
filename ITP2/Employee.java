package ITP2;

abstract public class Employee {
    private int age;
    private String name;
    private int salary;
    private static int createdObjects;
    public Employee(int age, String name, int salary){
        this.age = age;
        this.name = name;
        this.salary = salary;
        createdObjects++;
    }
    public Employee(int age, String name){
        this.age = age;
        this.name = name;
        this.salary = 5000;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public String getGeneralInfo(){
        return ("Name: " + name + "   Age: " + age + "   Salary (no bonus): " + salary);
    }
    public int getCreatedObjects(){
        return createdObjects;
    }
    abstract public String getFullInfo();
    abstract public int getFullSalary();
}
