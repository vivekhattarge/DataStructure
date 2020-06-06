package com.linkedlist;

public class IntersectionOfTwoLists {

    // Java program to get intersection point of two linked list
    static Node head1, head2;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /*function to get the intersection point of two linked
    lists head1 and head2 */
    int getNode() {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return _getIntesectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return _getIntesectionNode(d, head2, head1);
        }
    }

    /* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
    int _getIntesectionNode(int d, Node node1, Node node2) {
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    /*Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(Node node) {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLists list = new IntersectionOfTwoLists();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + list.findIntersectionOfLists(list.head1,list.head2).data);
    }

    private static int getLength(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }

    private static Node findIntersectionOfLists(Node current1, Node current2){

        int count1 = getLength(current1);
        int count2 = getLength(current2);

        Node resultNode;
        int d;
        if(count1 > count2){
            d= count1 - count2;
            resultNode = getIntersectedNode(d,head1,head2);
        }else{
            d = count2 - count1;
            resultNode = getIntersectedNode(d,head2,head1);
        }
        return  resultNode;
    }

    private static Node getIntersectedNode(int d,Node current1, Node current2){

        for(int i=0;i<d;i++){
            current1 = current1.next;
        }
        while (current1 != null && current2 != null){
            if(current1.data == current2.data){
                return  current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return  null;
    }

}


