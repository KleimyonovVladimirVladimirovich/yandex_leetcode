package yandex.easy;

public class MergeTwoLinkedList {

    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(){}
        public LinkedNode(int val) {this.val = val;}
        public LinkedNode(int val, LinkedNode next) {this.val = val; this.next = next;}

        public LinkedNode mergeLists(LinkedNode list1, LinkedNode list2) {
            LinkedNode list = new LinkedNode();
            LinkedNode result = list;
            if (list1 == null && list2 == null) {
                return null;
            }
            while(list1 != null && list2 != null) {
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
}
