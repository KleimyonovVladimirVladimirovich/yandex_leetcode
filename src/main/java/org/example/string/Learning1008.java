package org.example.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Learning1008 {

    public static void main(String[] args) {
    LinkedNode links = new LinkedNode();
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

        public static LinkedNode mergeKSortedLists(LinkedNode[] linked) {
            PriorityQueue<LinkedNode> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.val, b.val)
            );
            for(LinkedNode link : linked) {
                if (link != null) {
                    pq.add(link);
                }
            }
            LinkedNode result = null;
            LinkedNode resultEnd = null;
            while(!pq.isEmpty()) {
                LinkedNode smallest = pq.poll();
                if (result == null) {
                    result = smallest;
                } else {
                    resultEnd.next = smallest;
                }
                resultEnd = smallest;
                if (smallest.next != null) {
                    pq.add(smallest.next);
                }
            }
            return result;
        }

    }

//    public boolean checkInclusion(String s1, String s2) {
//        Map<Character,Character> map = new HashMap<>();
//        map.replace()
//
//    }
}
