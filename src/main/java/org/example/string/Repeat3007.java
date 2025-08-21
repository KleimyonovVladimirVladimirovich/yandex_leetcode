package org.example.string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Repeat3007 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(5, new TreeNode(15), new TreeNode(20)));
        System.out.println(TreeNode.sumOfLeftLeaves(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){this.val = val;}
        public TreeNode(){}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public static int sumOfLeftLeaves(TreeNode root) {
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
    public static boolean isReflection(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<List<Integer>> set = new HashSet<>();
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX,point[0]);
            set.add(List.of(point[0], point[1]));

        }
        int sum = maxX + minX;

        for(int[] point : points) {
            if (!set.contains(List.of(sum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }
}
