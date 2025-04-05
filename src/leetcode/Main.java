package leetcode;

import leetcode.*;



public class Main {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode e1 = new ListNode(2);
        ListNode e2 = new ListNode(3);
        ListNode e3 = new ListNode(4);
        ListNode e4 = new ListNode(5);

        head.next = e1;
        e1.next = e2;
        e2.next = e3;
        e3.next = e4;

        System.out.println(listReverse(head));



    }

    private static ListNode listReverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {

            next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }
        return prev;
    }
}
