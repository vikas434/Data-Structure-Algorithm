import java.util.*;

public class P102LevelOrdertraversal {

    static List<List<Integer>> levelOrderList = new ArrayList<>();
    static Map<Integer, List<Integer>> levelMap = new HashMap<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {

        if (null == root) {
            return levelOrderList;
        }
        Queue<Level> queue = new LinkedList<>();
        queue.add(new Level(root, 0));
        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            var currentNodeLevel = currentNode.level;
            // Update map
            if (!levelMap.containsKey(currentNodeLevel)) {
                var newList = new ArrayList<Integer>();
                newList.add(currentNode.node.val);
                levelMap.put(currentNodeLevel, newList);
            } else {
                var currentList = levelMap.get(currentNodeLevel);
                currentList.add(currentNode.node.val);
                levelMap.put(currentNodeLevel, currentList);
            }
            // Imp - the catch is to add both the nodes and add correct current level.
            if (currentNode.node.left != null) {
                queue.add(new Level(currentNode.node.left, currentNode.level+1));
            }

            if (currentNode.node.right != null) {
                queue.add(new Level(currentNode.node.right, currentNode.level+1));
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : levelMap.entrySet()) {
            levelOrderList.add(entry.getValue());
        }
        return levelOrderList;
    }

    private static class Level {
        TreeNode node;
        int level;

        public Level(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        levelOrder(node);
    }
}
