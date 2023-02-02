import java.util.LinkedList;
import java.util.Queue;

public class P104MaxDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        var maxDepth = 0;
        if(root == null) {
            return maxDepth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            var queueSize = queue.size();
            for(int i = 0; i<queueSize; i++) {
                var currentNode = queue.poll();
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            maxDepth++;
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(1);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(-1);
        node.left.left.left = new TreeNode(5);
        node.left.left.right = new TreeNode(1);
        node.right.left.right = new TreeNode(6);
        node.right.right.right = new TreeNode(-8);
        System.out.println(maxDepth(node));
    }
}
