package com.reversal.of.linked.list;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = reverse(head);

        while (result != null){
            System.out.print(" "+result.data);
            result = result.next;
        }

    }

    private static ListNode reverse(ListNode head) {

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

}
