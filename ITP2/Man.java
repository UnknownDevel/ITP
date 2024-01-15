package ITP2;

public class Man {
    public static void main(String[] args){
        Manager arget = new Manager(25, "mitch");
        System.out.println(arget.getFullInfo());
        Programist man = new Programist(24, "Jake", 12000);
        Programist woman = new Programist(24, "Jaake", 12000);
        System.out.println(man.getGeneralInfo());
        System.out.println(man.getCreatedObjects());
        System.out.println(arget.getCreatedObjects());
        System.out.println(woman.getFullSalary());
        man.setSalary(11000);
        System.out.println(man.getSalary());
    }
}
