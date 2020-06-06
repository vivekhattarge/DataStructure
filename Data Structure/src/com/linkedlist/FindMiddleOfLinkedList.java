package com.linkedlist;

import java.io.IOException;

public class FindMiddleOfLinkedList {

    Node head;

    static class Node{
        int data;
        Node next;
        public Node(int newData){
            this.data = newData;
            next = null;
        }
    }

    public static void printSinglyLinkedList(FindMiddleOfLinkedList.Node node,
                                             String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data) + sep);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        FindMiddleOfLinkedList list = new FindMiddleOfLinkedList();

        list.head = new FindMiddleOfLinkedList.Node(3);
        list.head.next = new FindMiddleOfLinkedList.Node(6);
        list.head.next.next = new FindMiddleOfLinkedList.Node(9);
        list.head.next.next.next = new FindMiddleOfLinkedList.Node(15);
        list.head.next.next.next.next = new FindMiddleOfLinkedList.Node(30);

        printSinglyLinkedList(list.head," ");

        Node resultNode = getMiddleNode(list.head);

        System.out.println("Middle node is : "+resultNode.data);
    }

    private static Node getMiddleNode(Node head){

        Node ptr1,ptr2;
        ptr1 = ptr2 = head;

        while(ptr1.next != null){
            ptr1 = ptr1.next.next;
            ptr2 = ptr2.next;
        }
        return  ptr2;
    }

}
