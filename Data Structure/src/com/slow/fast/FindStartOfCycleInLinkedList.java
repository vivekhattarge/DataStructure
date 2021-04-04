package com.slow.fast;

public class FindStartOfCycleInLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;

        ListNode result = findCycleStart(head);

        if (null == result) {
            System.out.println("No Cycle found");
        } else {
            System.out.println("LinkedList cycle start: " + findCycleStart(head).value);
        }
    }

    private static ListNode findCycleStart(ListNode head) {


        int cycleLength = findCycleAndGetLength(head);

        if(cycleLength == 0){
            return null;
        }

        return findStartOfCycle(cycleLength, head);
    }

    private static ListNode findStartOfCycle(int cycleLength, ListNode head) {

        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while (cycleLength > 0) {
            pointer1 = pointer1.next;
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    private static int findCycleAndGetLength(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return getCycleLength(slow);
            }
        }
        return 0;
    }

    private static int getCycleLength(ListNode slow) {

        ListNode current = slow;
        int length = 0;
        do {
            current = current.next;
            length++;
        } while (current != slow);
        return length;
    }

}
