 
import java.util.Scanner;

class BinaryTree{ 

    public BinaryTree(){
    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public void populate(Scanner scanner){
        System.out.println("Enter the root value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner , Node node){
        System.out.println("Do you want to add a left child for "+ node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value for the left child: " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to add a right child for "+ node.value);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value for the right child: " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }
        prettyDisplay(node.right, level + 1);
        if(level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-------" + node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public void preOrder(){
        preOrder(root);
        }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
    private  Node root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.populate(new Scanner(System.in));
        tree.prettyDisplay();
        tree.preOrder();
        System.out.println("");
        tree.inOrder();
        System.out.println("");
        tree.postOrder();
    }

}