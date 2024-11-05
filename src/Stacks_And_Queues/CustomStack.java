package Stacks_And_Queues;

public class CustomStack {
    protected int[] data;
    private static  final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
     this.data = new int[size];
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from an empty stack !");
        }
       return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("The stack is empty !");
        }
        return  data[ptr];
    }



    public boolean push (int item){
        if(isFull()){
            System.out.println("Stack is full !");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean isFull() {
        return  ptr == data.length-1;
    }

    private boolean isEmpty() {
        return  ptr == -1;
    }

    public static void main(String[] args) throws StackException {
        CustomStack stack = new DynamicStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
    }
}
