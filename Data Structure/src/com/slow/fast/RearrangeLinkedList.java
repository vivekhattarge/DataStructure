package com.slow.fast;

public class RearrangeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        reorderLinkedList(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    private static void reorderLinkedList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow);
        ListNode firstHalf = head;

        while(firstHalf != null && headSecondHalf != null){
            ListNode temp = firstHalf.next;
            firstHalf.next = headSecondHalf;
            firstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = firstHalf;
            headSecondHalf = temp;
        }

        if(firstHalf != null){
            firstHalf.next = null;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
