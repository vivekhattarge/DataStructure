package com.linkedlist;

public class InsertNodeInSortedLinkedList {
    Node head;

    @Override
    public String toString() {
        return "InsertNodeInSortedLinkedList{" +
                "head=" + head +
                '}';
    }

    static class Node {
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {

        InsertNodeInSortedLinkedList insertNodeInSortedLinkedList = new InsertNodeInSortedLinkedList();

        insertNodeInSortedLinkedList.push(50);
        insertNodeInSortedLinkedList.push(40);
        insertNodeInSortedLinkedList.push(30);
        insertNodeInSortedLinkedList.push(20);
        insertNodeInSortedLinkedList.push(10);

        System.out.println(insertNodeInSortedLinkedList.toString());
        insert(insertNodeInSortedLinkedList.head,25);
        System.out.println(insertNodeInSortedLinkedList.toString());
    }

    private static void insert(Node head, int valueToInsert) {

        //New Node to insert
        InsertNodeInSortedLinkedList.Node newNode = new Node(valueToInsert);
        Node temp = head;
        while (temp.next != null && temp.next.data < newNode.data){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

}
