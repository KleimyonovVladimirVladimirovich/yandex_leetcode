package yandex.hard;

import java.util.PriorityQueue;

public class TrappingRainWater {
    public static void main(String[] args) {

    }

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

        public static ListNode mergeKSortedList(ListNode[] lists) {
            if (lists == null) {
                return null;
            }
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    (a,b) -> Integer.compare(a.val,b.val)
            );
            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }
            ListNode result = null;
            ListNode resultEnd = null;
            while (!pq.isEmpty()) {
                ListNode smallest = pq.poll();
                if (result == null) {
                    result = smallest;
                } else {
                    resultEnd.next = smallest;
                }
                resultEnd = smallest.next;
                if (smallest.next != null) {
                    pq.add(smallest);
                }
            }
            return result;
        }
    }
}
