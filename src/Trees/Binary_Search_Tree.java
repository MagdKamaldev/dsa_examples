class BST{
    public class Node{
        private  int value;
        private  Node left;
        private  Node right;
        private  int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public BST(){}

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean  isEmpty(){
        return root == null;
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        }else{
            node.right = insert(node.right, value);
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public boolean balanced(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }
        System.out.println(details + node.getValue());

        display(node.left, "left of " + node.getValue() + " : ");
        display(node.right, "right of " + node.getValue() + " : ");
    }

    public void populate (int[] nums){
        for(int num : nums){
            this.insert(num);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length - 1);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start > end){
            return;
        }
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid-1);
        populateSorted(nums, mid + 1, end);
    }



    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = {2, 3, 5, 7, 9, 11, 16, 18};
        bst.populateSorted(nums);
        bst.display();
        System.out.println(bst.balanced());
    }

}