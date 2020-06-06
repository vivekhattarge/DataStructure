package com.linkedlist;

public class ExchangeAdjacentNodes {

    Node head;
    public static class Node{
        int data;
        Node next;
        public Node(int d){
            data = d;
            next = null;
        }
    }


    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {

         /* The constructed linked list is:
         1->2->3->4->5->6->7 */
        ExchangeAdjacentNodes list = new ExchangeAdjacentNodes();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
    }
}
