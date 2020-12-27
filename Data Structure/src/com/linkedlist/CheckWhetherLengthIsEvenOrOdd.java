package com.linkedlist;

public class CheckWhetherLengthIsEvenOrOdd {

    Node head;

    static class Node{
        int data;
        Node next;
        public Node(int newData){
            this.data = newData;
        }
    }

    public static void printSinglyLinkedList(CheckWhetherLengthIsEvenOrOdd.Node node,
                                             String sep) {
        while (node != null) {
            System.out.print(String.valueOf(node.data) + sep);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        CheckWhetherLengthIsEvenOrOdd list = new CheckWhetherLengthIsEvenOrOdd();

        list.head = new CheckWhetherLengthIsEvenOrOdd.Node(3);
        list.head.next = new CheckWhetherLengthIsEvenOrOdd.Node(9);
        list.head.next.next = new CheckWhetherLengthIsEvenOrOdd.Node(15);
        list.head.next.next.next = new CheckWhetherLengthIsEvenOrOdd.Node(30);
        list.head.next.next.next.next = new CheckWhetherLengthIsEvenOrOdd.Node(60);

        printSinglyLinkedList(list.head," ");

        Node resultNode = checkWhetherLengthIsEvenOrOdd(list.head);

        if(resultNode == null){
            System.out.println("Linked list is even");
        }else{
            System.out.println("Linked list is odd");
        }

    }

    static Node checkWhetherLengthIsEvenOrOdd(Node head){

    while (head != null && head.next != null){
        head = head.next.next;
    }
       return head;
    }

}
