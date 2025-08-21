package yandex.easy;

public class SymmetricTree {

    // 2 -> 3, 3 -> 2,4; 2,4

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(3, new TreeNode(4), new TreeNode(2)));
        System.out.println(root.isSymmetric(root));

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}
        public TreeNode(int val) {this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right) {this.val = val;this.left = left;this.right = right;}

        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        public boolean isMirror(TreeNode r1, TreeNode r2) {
            if (r1 == null &&  r2 == null) {
                return true;
            }
            if (r1 == null || r2 == null) {
                return false;
            }
            return (r1.val == r2.val) && (isMirror(r1.left, r2.right)) && (isMirror(r1.right, r2.left));
        }
    }
}
