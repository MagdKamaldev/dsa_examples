# Trees Problems
#
## 1) BFS Problems
#
### // TODO: continue here
### 993 cousins in a binary tree
#### A) First we need to find both nodes that we want to compare using the findNode() method
#### B) Then we compare their level using level() method which returns the level of the node as integer
#### C) If they are at the same level they also must not be siblings which we check using isSiblings() method
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root,xx,0) == level(root,yy,0) && (!isSiblings(root,xx,yy)));
    }
    TreeNode findNode(TreeNode node , int value){
        if(node == null){
            return null;
        }
        if(node.val == value){
            return node;
        }
        TreeNode n = findNode(node.left,value);
        if(n!= null){
            return n;
        }
        return findNode(node.right,value);
    }

    boolean isSiblings(TreeNode node , TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }
        return (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSiblings(node.left,x,y) ||  isSiblings(node.right,x,y);
    
    }

    int level(TreeNode node , TreeNode x, int level){
        if(node == null){
            return 0;
        }
        if(node ==x){
            return level;
        }
        int l = level(node.left,x,level+1);
        if(l!= 0){
            return l;
        }
        return level(node.right,x,level+1);
    }
}
```
#
### 101 Symmetric tree

![Example](../../assets/trees_questions.png)
#### A) We skip the root node for it doesn't affect what we are searching for
#### B) Add left and rigth of the root node to the queue
#### C) while the queue is not empty we poll the last two elments in the queue and make these checks on them 
```java
if(left == null && right == null){
            continue;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
```
#### D)we add next elements to the queue by this order:
##### 1 l.l
##### 2 r.r
##### 3 l.r
##### 4 r.l
#### to have each item and the item i want to compare with behind each others in the stack and compare them in a correct way.
```java
/**
 * Definition for a binary tree node. 
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();
        if(left == null && right == null){
            continue;
        }
        if(left == null || right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        queue.offer(left.left);
        queue.offer(right.right);
        queue.offer(left.right);
        queue.offer(right.left);
        }
        return true;
    }
}
```
#
#
## 2)DFS Problems
#
### 543 Diameter of a binary tree 
### The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
### Example
![Example](../../assets/pre_order.png)
### Input: root = [1,2,3,4,5]
### Output: 3
### Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

#### Solution:
#### Diameter of every Node you pass by is LeftHeight + rightHeight + 1
#### we pass by all nodes to get all diameters in post order traversal
#### so in every node we pass by we compare it's diameter with the value saved in diameter if it's greater we save it 
#### in the end the value of the diameter will be greater than the answer we need by one for we need the path not the number of nodes se we return diameter - 1
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter-1;
    }
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int dia = leftHeight + rightHeight +1;
        diameter = Math.max(diameter , dia);
        
        return Math.max(leftHeight, rightHeight)+1;
    }
}
```
#
### 226. Invert Binary Tree
### Given the root of a binary tree, invert the tree, and return its root.
### Example
![Example](../../assets/invert_binary_tree_example.png)
### Input: root = [4,2,7,1,3,6,9]
### Output: [4,7,2,9,6,3,1]
#### Solution:
#### save left in a variable left then make node.left = node.right and node.right the left variable we saved
#### make recursive calls for root.left and root.right
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
```
#### kunal's approach was to make it in post order traversal :
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right =left;
        return root;
    }
}
```
#
### 108. Convert Sorted Array to Binary Search Tree
### Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
### Example 1:
### Input: nums = [-10,-3,0,5,9]
### Output: [0,-3,9,-10,null,5]
### Explanation: [0,-10,5,null,-3,null,9] is also accepted
#### Solution:
#### we create a helper function to recurse from it and it takes start and end attributes
#### every lap we create a new node with mid value
#### and recurse on it's left and right like this : 
```java
root.left = helper(nums, start, mid - 1);
root.right = helper(nums, mid + 1, end);
```
#### in the end root will be returned
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);

        return root;
    }
}
```
#
### 114. Flatten Binary Tree to Linked List
### Given the root of a binary tree, flatten the tree into a "linked list":
### The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
### The "linked list" should be in the same order as a pre-order traversal of the binary tree.
### Example
![Example](../../assets/flatten_binary_tree_example.png)
### Input: root = [1,2,5,3,4,null,6]
### Output: [1,null,2,null,3,null,4,null,5,null,6]
#### 1) Brute force approach:
#### make normal pre order traversal
#### as you traverse store nodes in a queue
#### in the end add items from the queue to make a linkedlist
#
#### 2) O(1) space complexity approach
#### Save the root node to current variable and move right with a while loop that runs untill cuurent is null
#### if current's left is not null save it in a variable called temp and move right untill temp.right = null and when you come out of this loop you will ena up at the right most element in the left part
#### do this when you come out: 
```java
temp.right = current.right;
current.right = current.left;
current.left = null;
```
#### so the left node with all the other nodes connected to it will move on the right side
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
```
#
###
### 98. Validate Binary Search Tree
### Given the root of a binary tree, determine if it is a valid binary search tree (BST).
### A valid BST is defined as follows:
### The left subtree of a node contains only nodes with keys less than the node's key.
### The right subtree of a node contains only nodes with keys greater than the node's key.
### Both the left and right subtrees must also be binary search trees.
### Example 1:
![Example](../../assets/validate_bst_true_example.png)
### Input: root = [2,1,3]
### Output: true
### Example 2:
![Example](../../assets/validate_bst_false_example.png)
### Input: root = [5,1,4,null,null,3,6]
### Output: false
### Explanation: The root node's value is 5 but its right child's value is 4.
#### Solution:
#### Make a helper recursive function that takes the root, upper and lower limit values which are both initially null
#### check for the value of the current node to be greater than min and less than max
#### for the next left call max will be node.val and next right min will be node.val
![Example](../../assets/validate_bst_answer.png)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }

    public boolean helper(TreeNode node,Integer min,Integer max){
        if(node ==null){
            return true;
        }
        if(min != null && node.val <= min){
            return false;
        }
        if(max != null && node.val>= max){
            return false;
        }
        boolean left = helper(node.left,min,node.val);
        boolean right = helper(node.right,node.val,max);
        return left && right;
    }
}
```