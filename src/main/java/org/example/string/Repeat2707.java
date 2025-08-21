package org.example.string;

import yandex.easy.MergeTwoLinkedList;

import java.util.*;

public class Repeat2707 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        int[] arr = new int[]{1, 0, 0, 5, 0, 9, 6, 3, 0, 6, 9, 0, 0, 5};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

        LinkedNode root = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3, new LinkedNode(4))));
        System.out.println(LinkedNode.reverseLinkedList(root));

        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(2)),
                new TreeNode(2, new TreeNode(2), new TreeNode(4)));
        System.out.println(TreeNode.isSymmetric(root1));

        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 6, 1}));

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

        public static boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);
        }

        public static boolean isMirror(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null) {
                return true;
            }
            if (r1 == null || r2 == null) {
                return false;
            }
            return (r1.val == r2.val && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left));


        }
    }

        static class LinkedNode {
            int val;
            LinkedNode next;

            public LinkedNode() {
            }

            public LinkedNode(int val) {
                this.val = val;
            }

            public LinkedNode(int val, LinkedNode next) {
                this.val = val;
                this.next = next;
            }

            @Override
            public String toString() {
                return val + "->" + next;
            }

            public static LinkedNode reverseLinkedList(LinkedNode root) {
                if (root == null) {
                    return null;
                }
                LinkedNode newHead = root;
                if (root.next != null) {
                    newHead = reverseLinkedList(root.next);
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
                LinkedNode result = list;
                while (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        result.next = list1;
                        list1 = list1.next;
                    } else {
                        result.next = list2;
                        list2 = list2.next;
                    }
                    result = result.next;
                }
                result.next = (list1 != null) ? list1 : list2;
                return list.next;
            }
        }


    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || (nums[i] != nums[i - 1] + 1)) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return result;
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
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {
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

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer num : nums1) {
            set1.add(num);
        }
        for (Integer num : nums2) {
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

    public static String reverseWord(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word).reverse();
            result.append(sb).append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static int singleNumber1(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
    public static int singleNumber2(int[] nums) {
     Map<Integer, Integer> map = new HashMap<>();
     for (Integer num : nums) {
         map.put(num, map.getOrDefault(num,0) + 1);
     }
     for (Map.Entry<Integer,Integer> entrySet : map.entrySet()) {
         if (entrySet.getValue() == 1) {
             return entrySet.getKey();
         }
        }
     return 0;
    }

    public static boolean containsDuplicate(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (Integer num : nums) {
          map.put(num, map.getOrDefault(num,0) + 1);
      }
      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
          if(entry.getValue() > 1) {
              return true;
          }
      }
     return false;
    }

    public static boolean isParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '?' : stack.pop();
                if(top != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
