package LinkedLists;

public class LL {
    private  Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void display(){
        Node temp = head;
        while (temp !=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public  void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail==null){
            tail = head;
        }
        size+=1;
    }

    public void insertAt(int val, int index){
        if(index ==0){
            insertFirst(val);
            return;
        }else if (index ==size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index-1; i++) {
         temp = temp.next;
        }

        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;
    }

    public void insertLast(int val){
        if (tail ==null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return  val;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.value;
        tail = secondLast;
        secondLast.next = null;
        size--;
        return val;
    }

    public int deleteAt(int index){
        if(index ==0){
            return deleteFirst();
        }else if(index == size-1){
            return deleteLast();
        }
        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public void  insertRecVoid(int val, int index){
    head = insertRec(val,index,head);
    }

    private Node insertRec(int val, int index,Node node){
        if(index ==0){
            Node temp = new Node(val,node);
            size++;
            return temp;
        }

         node.next = insertRec(val,index-1,node.next);
        return  node;
    }

    public Node find(int value){
        Node node = head;
        while (node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
       private int value;
       private  Node next;

       public Node(int value) {
           this.value = value;
       }

       public Node( int value,Node next) {
           this.value = value;
           this.next = next;
       }
   }

    public static void main(String[] args) {
        LL list = new  LL();
        list.insertFirst(8);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertAt(5,1);
        list.insertLast(6);
        list.display();
        list.insertRecVoid(44,2);
        list.display();
    }
}
