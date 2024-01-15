package ITP6;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        for(int i = 0; i < data.length; i++){
            if(data[i] == null){
                data[i] = element;
                size += 1;
                break;
            }
        }
    }
    public T pop() {
        T ret;
        for(int i = data.length-1; i >= 0; i--){
            if(data[i] != null){
                ret = data[i];
                data[i] = null;
                size -= 1;
                return ret;
            }
        }
        return null;
    }
    public T peek() {
        for(int i = data.length-1; i >= 0; i--){
            if(data[i] != null){
                return data[i];
            }
        }
        return null;
    }
    public static void main(String[] args){
        Stack<Integer> sack = new Stack<>(10);
        sack.push(12);
        sack.push(1);
        sack.push(1);
        System.out.println(sack.pop());
        sack.pop();
        System.out.println(sack.peek());
        System.out.println(sack.size);
    }
}
