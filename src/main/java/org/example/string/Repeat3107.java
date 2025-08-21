package org.example.string;

import java.util.*;

public class Repeat3107 {
    public static void main(String[] args) {
        System.out.println(isValid("["));
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

        static class LinkedNode {
            int val;
            LinkedNode next;
            public LinkedNode() {
            }
            public LinkedNode(int val) {this.val = val;}
            public LinkedNode(int val, LinkedNode next) {this.val = val; this.next = next;}
        }
        public LinkedNode mergeTwoSortedLists(LinkedNode list1, LinkedNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            LinkedNode list = new LinkedNode();
            LinkedNode res = list;
            while(list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    res.next = list1;
                    list1 = list1.next;
                } else {
                    res.next = list2;
                    list2 = list2.next;
                }
                res = res.next;
                res.next = (list1 != null) ? list1 : list2;
            }
            return list.next;
        }

        public boolean isReflection(int[][] points) {
            int minX = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            Set<List<Integer>> set = new HashSet<>();
            for (int[] point : points) {
                minX = Math.min(minX, point[0]);
                maxX = Math.max(maxX, point[0]);
                set.add(List.of(point[0], point[1]));
            }
            int sum = minX + maxX;
            for (int[] point : points) {
                if (!set.contains(List.of(sum - point[0], point[1]))) {
                    return false;
                }
            }
            return true;

        }

        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i]) || map.get(nums[i]) <= map.get(k)) {
                    return true;
                }
                map.put(nums[i], i);
            }
            return false;
        }

        // + Duplicate Contains I on LeetCode)

    }
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
    public static int singleNumber1(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words) {
            StringBuilder sb = new StringBuilder(word).reverse();
            result.append(sb).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '?' : stack.pop();
                if (map.get(c) != top) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
