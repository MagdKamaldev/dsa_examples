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