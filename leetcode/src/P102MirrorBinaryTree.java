public class P102MirrorBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }

        if(left == null || right == null) {
            return false;
        }

        return (left.val == right.val && isMirror(left.right, right.left) && isMirror(right.left, left.right));
    }
}
