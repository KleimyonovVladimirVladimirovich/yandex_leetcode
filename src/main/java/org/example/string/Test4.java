package org.example.string;

import com.sun.source.tree.Tree;

public class Test4 {

    // 4 -> 3 -> 1 -> 5 -> 7  ---------> 7-5-1-3-4

    public static void main(String[] args) {

        LinkedNode root = new LinkedNode(4, new LinkedNode(3, new LinkedNode(1, new LinkedNode(5, new LinkedNode(7)))));
        System.out.println(root.reverseLinkedNode(root));
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
            StringBuilder sb = new StringBuilder();
            LinkedNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append("->");
                }
                current = current.next;
            }
            return sb.toString();
        }

        public LinkedNode reverseLinkedNode(LinkedNode root) {
            if (root == null) {
                return null;
            }
            LinkedNode newHead = root;
            if (root.next != null) {
                newHead = reverseLinkedNode(root.next);
                root.next.next = root;
            }
                root.next = null;
                return newHead;
        }


//        public boolean isSymmetric(TreeNode root) {
//            return isMirror(root, root);
//        }
//
//        public boolean isMirror(TreeNode r1, TreeNode r2) {
//            if (r1 == null && r2 == null) {
//                return true;
//            }
//            if (r1 == null || r2 == null) {
//                return false;
//            }
//
//            return (r1.val == r2.val && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left));
//        }
    }
}
