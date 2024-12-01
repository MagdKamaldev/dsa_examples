
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

@SuppressWarnings("unused")
class BFS{
    public static List<List<Integer>> bfs(TreeNode root){
     List<List<Integer>> answer = new ArrayList<>();
     if(root == null){
        return answer;
     }
     Queue<TreeNode> queue = new LinkedList<>();
     queue.offer(root);
     while(!queue.isEmpty()){
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>(levelSize);
        for (int i = 0; i < levelSize; i++) {
            TreeNode currentNode = queue.poll();
            currentLevel.add(currentNode.val);
            if(currentNode.left != null){
              queue.offer(currentNode.left);
            }if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }
        answer.add(currentLevel);
     }
     return answer;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> result = bfs(root);
    }
}

