package yandex.easy;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(12), new TreeNode(7)));
        System.out.println(root.sumOfLeftLeaves(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        ;


        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }


        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum += sumOfLeftLeaves(root.left);
            sum += sumOfLeftLeaves(root.right);
            return sum;
        }
    }

}
