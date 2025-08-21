package org.example.string;

public class test3 {
    public static void main(String[] args) {
        LinkedNote linked = new LinkedNote(1, new LinkedNote(2, new LinkedNote(3, new LinkedNote(7))));
        System.out.println(LinkedNote.reverseNode(linked));
    }

    static class LinkedNote {
        int val;
        LinkedNote next;
        public LinkedNote() {}
        public LinkedNote(int val) {
            this.val = val;
        }

        public LinkedNote(int val, LinkedNote next) {
            this.val = val;
            this.next = next;
        }

        public static LinkedNote reverseNode(LinkedNote linked) {
            if (linked == null) {
                return null;
            }
            LinkedNote newHead = linked;
            if (linked.next != null) {
              newHead = reverseNode(linked.next);
              linked.next.next = linked;
            }
            linked.next = null;
            return newHead;
        }

        @Override
        public String toString() {
            return val + "," + next ;
        }
    }
}
