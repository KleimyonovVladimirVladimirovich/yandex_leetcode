package org.example.string;

public class TestLinkedListeReverse {
    public static void main(String[] args) {
        LinkedNode root = new LinkedNode(1, new LinkedNode(2, new LinkedNode(3)));
        System.out.println(root.reverseLinkedNode(root));

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

        @Override
        public String toString() {
            return val + "->" + next;
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
    }
}
