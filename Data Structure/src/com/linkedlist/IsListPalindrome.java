package com.linkedlist;

public class IsListPalindrome {

    Node head;
    Node slowPtr,fastPtr,prevOfSlowPtr,midNode,secondHalf;
    public class Node{
        char data;
        Node next;
        Node slow_ptr,fast_ptr,second_half;

        Node(char c){
            data = c;
            next = null;
        }
    }

    public void push(char data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;

    }
    public void printList(Node node){

        while(node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public boolean isPalindrome(Node head){
        slowPtr = head;
        fastPtr = head;
        prevOfSlowPtr = head;
        midNode = null;
        boolean result = true;
        if(head != null && head.next !=null){

            while(fastPtr != null && fastPtr.next != null){
                fastPtr = fastPtr.next.next;
                prevOfSlowPtr = slowPtr;
                slowPtr = slowPtr.next;
            }
            //if list is off then fastPtr will not be null
            if(fastPtr != null){
                midNode = slowPtr;
                slowPtr = slowPtr.next;
            }
            //start of second list
            secondHalf = slowPtr;
            //this splits list in two lists
            prevOfSlowPtr.next = null;

            reverse();
            result = compareLists(head,secondHalf);

            if (midNode != null) {
                // If there was a mid node (odd size case) which
                // was not part of either first half or second half.
                prevOfSlowPtr.next = midNode;
                midNode.next = secondHalf;
            }
            else {
                prevOfSlowPtr.next = secondHalf;
            }
        }

        return result;
    }

    public void reverse(){
        Node prev= null;
        Node current = secondHalf;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        secondHalf = prev;
    }

    /* Function to check if two input lists have same data*/
    boolean compareLists(Node head1, Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                return false;
        }

        /* Both are empty reurn 1*/
        if (temp1 == null && temp2 == null)
            return true;

        /* Will reach here when one is NULL
           and other is not */
        return false;
    }

    public static void main(String[] args) {

        /* Start with the empty list */
        IsListPalindrome llist = new IsListPalindrome();

        char str[] = { 'a', 'b', 'a', 'c', 'a', 'b', 'a' };
        for (int i = 0; i < 7; i++) {
            llist.push(str[i]);
            llist.printList(llist.head);
            if (llist.isPalindrome(llist.head) != false) {
                System.out.println("Is Palindrome");
                System.out.println("");
            }
            else {
                System.out.println("Not Palindrome");
                System.out.println("");
            }
        }

    }
}
