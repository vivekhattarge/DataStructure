package com.linkedlist;

public class LinkedListDriver {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insert(10,1);
        linkedList.insert(20,2);
        linkedList.insert(30,3);
        linkedList.insert(40,4);
        System.out.println("length before : "+ SinglyLinkedList.getLength(linkedList.getHeadNode()));
 //       linkedList.remove (1);
 //       System.out.println("length after : "+ SinglyLinkedList.getLength(linkedList.getHeadNode()));
        System.out.println("Linked List position : "+linkedList.getPosition(30));
    //    ListNode listNode = linkedList.getNthNodeFromEnd(linkedList.getHeadNode(),1);
        ListNode listNode = SinglyLinkedList.nthNodeFromEndWithRecursion(linkedList.getHeadNode(),2);
        System.out.println("Nth Node is : "+listNode.getData());

  /*      DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insert(10,1,DoublyLinkedList.getLength(doublyLinkedList.getHeadNode()));
        doublyLinkedList.insert(20,0,DoublyLinkedList.getLength(doublyLinkedList.getHeadNode()));
        doublyLinkedList.insert(30,1,DoublyLinkedList.getLength(doublyLinkedList.getHeadNode()));


        System.out.println("Linked List position : "+doublyLinkedList.getPosition(30));*/

    }
}
