package Stacks_And_Queues;

public class CustomQueue {
    private int[] data;
    private static  final int  DEFAULT_SIZE = 10;
    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return  end == data.length;
    }

    private boolean isEmpty() {
        return  end == 0;
    }

    public  boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return  true;
    }

    public int remove() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty !");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws  Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty !");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i <end ; i++) {
            System.out.print(data[i]+ " ");
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(5);
        queue.insert(3);
        queue.insert(7);
        queue.insert(1);
        queue.insert(8);
        queue.display();
    }
}
