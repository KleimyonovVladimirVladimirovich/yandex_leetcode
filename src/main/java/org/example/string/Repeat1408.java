package org.example.string;

public class Repeat1408 {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
            ListNode list = new ListNode();
            ListNode result = list;
            if (list1 == null && list2 == null) {
                return null;
            }
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
            return result.next;
        }
    }
    public int scoreOfString(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res += Math.abs(ch - i) + Math.abs(i - ch);
        }
        return res;
    }
}
