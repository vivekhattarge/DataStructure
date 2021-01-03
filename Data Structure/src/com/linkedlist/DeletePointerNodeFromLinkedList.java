package com.linkedlist;

public class DeletePointerNodeFromLinkedList {

    Node head;
    
    class Node {
        int data;
        Node next;
        Node(int newData){
            this.data = newData;
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

    @Override
    public String toString() {
        return "DeletePointerNodeFromLinkedList{" +
                "head=" + head +
                '}';
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {

        DeletePointerNodeFromLinkedList deletePointerNodeFromLinkedList = new DeletePointerNodeFromLinkedList();

        deletePointerNodeFromLinkedList.push(40);
        deletePointerNodeFromLinkedList.push(30);
        deletePointerNodeFromLinkedList.push(20);
        deletePointerNodeFromLinkedList.push(10);

        System.out.println(deletePointerNodeFromLinkedList.head);

        deleteNode(deletePointerNodeFromLinkedList.head.next.next);

        System.out.println(deletePointerNodeFromLinkedList.head);
    }

    private static void deleteNode(Node nodeToDelete) {

        if(nodeToDelete == null){
            System.out.println("Can not delete null node");
        }
        if(null == nodeToDelete.next){
            System.out.println("Reached end of list....Can not delete");
        }
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }

}
