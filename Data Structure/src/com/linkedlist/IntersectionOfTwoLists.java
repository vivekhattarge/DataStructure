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


    public static void main(String[] args) {
        IntersectionOfTwoLists list = new IntersectionOfTwoLists();

        // creating first linked list
        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);

        // creating second linked list
        IntersectionOfTwoLists list2 = new IntersectionOfTwoLists();
        list2.head2 = new Node(10);
        list2.head2.next = new Node(15);
        list2.head2.next.next = new Node(30);

        if (list.findIntersectionOfLists(list.head1, list.head2) != null) {
            System.out.println("The node of intersection is " + list.findIntersectionOfLists(list.head1, list2.head2).data);
        } else {
            System.out.println("No Intersection of lists");
        }

    }

    private static int getLength(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count += 1;
        }
        return count;
    }

        /* function to get the intersection point of two linked
    lists head1 and head2 where head1 has d more nodes than
    head2 */
    private static Node findIntersectionOfLists(Node current1, Node current2){
        int count1 = getLength(current1);
        int count2 = getLength(current2);

        if(count1 == 0 || count2 == 0){
            return null;
        }
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


