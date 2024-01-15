package ITP3;
import java.util.LinkedList;

public class HashTable {
    private LinkedList<LinkedList<Object>> Table;

    public HashTable(){
        this.Table = new LinkedList<>();
    }
    public void put(int add_key, Object add_value){
        LinkedList<Object> addlist = new LinkedList<>();
        addlist.add(add_key);
        addlist.add(add_value);
        for(int i = 0; i < Table.size(); i++){
            if ((Integer)Table.get(i).get(0) == add_key){
                this.Table.get(i).add(add_value);
            }
            else{
                this.Table.add(addlist);
                break;
            }
        }
        if (Table.size() == 0){
            this.Table.add(addlist); 
        }
    }
    public LinkedList<Object> get(int key){
        for(int i = 0; i < Table.size(); i++){
            if ((Integer)Table.get(i).get(0) == key){
                return Table.get(i);
            }
        }
        return null;
    }
    public void remove(int key){
         for(int i = 0; i < Table.size(); i++){
            if ((Integer)Table.get(i).get(0) == key){
                this.Table.remove(Table.get(i));
            }
        }
    }
    public int size(){
        return Table.size();
    }
    public Boolean isEmpty(){
        return Table.size() != 0;
    }

    public static void main(String[] args){

        HashTable orders = new HashTable();
        orders.put(2, new Order("Shampoo", "Chinatown", "1000$"));
        orders.put(2, new Order("Things", "Chinatown", "121000$"));
        orders.put(1, new Order("Chopsticks", "Japan", "20000$")); 

        System.out.println(orders.get(2).get(0).toString()+ ", " + Order.class.cast(orders.get(2).get(1)).getproduct() + ", "
        + Order.class.cast(orders.get(2).get(2)).getproduct());
        System.out.println(Order.class.cast(orders.get(1).get(1)).getproduct().toString());

        orders.remove(1);
        System.out.println(orders.get(1));
    }
}
