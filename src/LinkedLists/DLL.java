package LinkedLists;

public class DLL {
    private Node head;
    Node tail;
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.previous = null;
        if(head!=null){
            head.previous = node;
        }
        head = node;
    }

    public  void  display(){
      Node node = head;
      while (node!=null){
          System.out.print(node.value + " -> ");
          node = node.next;
      }
        System.out.println("null");
    }

    public  void  displayReverse(){
        Node node = head;
        Node last = null;
        while (node!=null){
            last = node;
            node = node.next;
        }

        while(last!=null){
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.println("null");
    }

    public  void insertLast(int value){
        Node node = new Node(value);
        Node last = head;
        if(head == null){
            head = node;
            return;
        }
        while (last.next != null){
            last = last.next;
        }
        last.next = node;
        node.previous = last;
    }

    public void insertAfter(int after, int value){
    Node p = find(after);
    if(p == null){
        System.out.println("Doesn't Exist");
        return;
    }
    Node node = new Node(value);
    node.next = p.next;
    p.next = node;
    node.previous = p;
    if(node.next != null){
        node.next.previous = node;
    }
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

    private class Node{
        int value;
        Node next;
        Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    public static void main(String[] args) {
        DLL list = new  DLL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(17);
       // list.insertAt(5,1);
      //  list.insertLast(6);
        list.display();
        list.displayReverse();
        list.insertLast(12);
        list.display();
        list.displayReverse();
        list.insertAfter(5,12);
        list.display();
        list.displayReverse();
    }
}
