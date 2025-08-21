package org.example.string;

import java.util.*;

public class Repeat0908 {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,2,3,5,6,7,9}));

        System.out.println(isReflection(new int[][]{
                {0, 0},
                {1, 1},
                {-1, 1},
                {-10,0},
                {0, -10}
        }));


        int[] arr = new int[]{1,2,0,0,5,0,9,0,1,3,0,0,6,9,4,0,0};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(isPalindrome("сжечь костёр"));

        System.out.println(singleNumber(new int[]{1,1,2,2,3,3,4,4,5}));

        char[] word = new char[]{'s','e','k','s'};
        reverseString(word);
        System.out.println(word);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}
        public TreeNode(int val){}

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static boolean  isSymmetric(TreeNode root) {
           return isMirror(root,root);
        }
        public static boolean isMirror(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null) {return true;}
            if(r1 == null || r2 == null) {return false;}
            return (r1.val == r2.val && isMirror(r1.left,r2.right) && isMirror(r1.right,r2.left));
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

    static class LinkedNode {
        int val;
        LinkedNode next;
        public LinkedNode(){}
        public LinkedNode(int val) {
            this.val = val;
        }
        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }
        public LinkedNode reverseLinkedNode(LinkedNode root) {
            if (root == null) {
                return root;
            }
            LinkedNode newHead = root;
            if (root.next != null) {
                newHead = reverseLinkedNode(root.next);
                root.next.next = root;
            }
            root.next = null;
            return newHead;
        }

        public LinkedNode mergeTwoLists(LinkedNode list1, LinkedNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            LinkedNode list = new LinkedNode();
            LinkedNode res = list;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    res.next = list1;
                    list1 = list1.next;
                } else {
                    res.next = list2;
                    list2 = list2.next;
                }
                res = res.next;
            }
            res.next = (list1 != null) ? list1 : list2;
            return list.next;
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<String> result = new ArrayList<>();

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add((String.valueOf(start)));
                } else {
                    result.add((start + "->" + nums[i - 1]));
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return result;
    }


    public static boolean isReflection(int[][] points) {
        Set<List<Integer>> result = new HashSet<>();
        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        for (int[] point : points) {
            maxX = Math.max(maxX, point[0]);
            minX = Math.min(minX, point[0]);
            result.add(List.of(point[0],point[1]));
        }
        int sum = maxX + minX;
        for (int[] point : points) {
            if (!result.contains(List.of(sum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }


    public static void moveZeroes(int[] nums) {
        int NullPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[NullPointer];
            if (nums[i] != 0) {
                nums[NullPointer] = nums[i];
                nums[i] = temp;
                NullPointer++;
            }
        }
    }

    public static boolean isPalindrome(String s) {
        for(int l = 0, r = s.length() - 1; l < r; l++, r--) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isParentheses(String s) {
        if (s.length() == 0) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '?' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (Integer num : nums1) {
            set1.add(num);
        }
        for(Integer num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] arr = new int[set2.size()];
        int i = 0;
        for(Integer num : set2) {
            arr[i++] = num;
        }
        return arr;
    }

    public static String reverseWordsInAString3(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(res).reverse();
            res.append(sb).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    public static String reverseWordsInAString1(String s) {
        String[] words = s.trim().split("\\s+ ");
        List<String> list = new ArrayList<>(List.of(words));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }

    public static int singleNumber1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public boolean hasDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return false;
            }
            set.add(num);
        }
        return set.isEmpty();
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void reverseString(char[] s) {
       int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[right] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


}
