package yandex.easy;


public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedNode link = new LinkedNode(1,
                new LinkedNode(5,
                        new LinkedNode(9,
                                new LinkedNode(10, new LinkedNode(11)))));
        System.out.println(LinkedNode.reverseList(link));
    }

    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode() {}

        public LinkedNode(int val) {this.val = val;}

        public LinkedNode(int val, LinkedNode next) {this.val = val; this.next = next;}

//        @Override
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            LinkedNode current = this;
//            while (current != null) {
//                sb.append(current.val);
//                if (current.next != null) {
//                    sb.append("->");
//                }
//                current = current.next;
//            }
//            return sb.toString();
//        }


        @Override
        public String toString() {
            return "" +
                    "val=" + val +
                    ", next=" + next;
        }

        public static LinkedNode reverseList(LinkedNode link) {
            if (link == null) {
                return null;
        }
            LinkedNode newHead = link;
            if (link.next != null) {
                newHead = reverseList(link.next);
                link.next.next = link;
            }
            link.next = null;
            return newHead;
        }

    }
}
