package org.example.string;


import java.util.*;

public class Repeat2807 {
    public static void main(String[] args) {
        System.out.println(isParetenses("{()}"));
        System.out.println(summaryRanges(new int[]{1, 2, 3, 5, 6, 7, 9}));
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(ListNode.reverseListNode(root));
        int[] arr = new int[]{1,0,0,5,3,0,7,0,7,5,0,8};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(isParetenses("["));
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(2)),
                new TreeNode(2, new TreeNode(2), new TreeNode(4)));
        System.out.println(root1.isSymmetric(root1));
        System.out.println(reverseWord1("my dear Masha"));
        System.out.println(containsDuplicate(new int[]{1, 2, 3}));
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(){}
        public boolean isSymmetric(TreeNode root) {
          return isMirror(root, root);
        }
        public boolean isMirror(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null) {
                return true;
            }
            if (r1 == null || r2 == null) {
                return false;
            }
            return (r1.val == r2.val && isMirror(r1.left,r2.right) && isMirror(r1.right, r2.left));

        }
    }
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {this.val = val;}
        public ListNode(int val, ListNode next) {this.val = val; this.next = next;}

        public static ListNode reverseListNode(ListNode root) {
            if (root == null) {
                return null;
            }
            ListNode newHead = root;
            if (root.next != null) {
                newHead = reverseListNode(root.next);
                root.next.next = root;
            }
            root.next = null;
            return newHead;
        }

        public String toString() {
            return val + "," + next;
        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null && list2 == null) {
                return null;
            }
         ListNode list = new ListNode();
         ListNode res = list1;
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

    public static boolean isParetenses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
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

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return res;
    }
    public static void moveZeroes(int[] nums) {
        int NullPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(nums[i] != 0) {
                nums[i] = nums[NullPointer];
                nums[NullPointer] = temp;
                NullPointer++;
                //    for (int i = 0; daite mne vivesti massive please, snachala 0 vperedi a potom tcifry) {}
            }
        }
    }
    public static boolean isParantheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
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

    public static boolean isPalindrome(String s) {
        for(int l = 0, r = s.length() - 1; l < r; l++, r--) {
            while(l < r & !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }
        return true;
    }
    public String reverseWord(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word).reverse();
            res.append(sb).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
    public int singleNumber1(int[] nums) {
        int n = 0;
        for (int i = 0; i <= nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
    public static String reverseWord1(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> list = new ArrayList<>(List.of(words));
        Collections.reverse(list);
        return String.join(" ", list);
    }
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean lineReflection(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<List<Integer>> result = new HashSet<>();
        for(int[] point : points) {
            minX = Math.min(minX,point[0]);
            maxX = Math.max(maxX,point[0]);
            result.add(List.of(point[0],point[1]));
        }
        int sum = maxX + minX;
        for(int[] point : points) {
            if(!result.contains(List.of(sum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }
    public int[] intersectionArrays(int[] nums1, int[] nums2) {
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
        for (Integer num : set2) {
            arr[i++] = num;
        }
        return arr;
    }
}
