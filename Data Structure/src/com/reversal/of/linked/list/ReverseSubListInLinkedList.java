package com.reversal.of.linked.list;

public class ReverseSubListInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubListInLinkedList.reverse(head, 2, 4);
        while (result != null) {
            System.out.print(" " + result.data);
            result = result.next;
        }
    }

    private static ListNode reverse(ListNode head, int p, int q) {
        ListNode current = head;
        ListNode previous = null;
        int i;
        for(i=1; current!=null && i<p; i++){
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = previous;

        ListNode lastNodeOfSecondPart = current;
        ListNode next = null;

       for(int j = i; current != null && j <= q ;j++){
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }

       if(lastNodeOfFirstPart != null){
           lastNodeOfFirstPart.next = previous;
       }else{
           head = previous;
       }
        lastNodeOfSecondPart.next = current;

       return head;
    }

}
