package com.linkedlist;

public class FindLoopInLinkedList {
    Node head;

    class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public void push(int new_Data){
        Node node = new Node(new_Data);
        node.next = head;
        head = node;
    }

    public static void main(String[] args) {

        FindLoopInLinkedList findLoopInLinkedList = new FindLoopInLinkedList();

        findLoopInLinkedList.push(10);
        findLoopInLinkedList.push(20);
        findLoopInLinkedList.push(30);
        findLoopInLinkedList.push(40);

        findLoopInLinkedList.head.next.next = findLoopInLinkedList.head;

        if(findLoopInLinkedList.detectLoop()){
            Node startOfLoop = findLoopInLinkedList.findBeginOfLoop();
            System.out.println("start of loop is : "+startOfLoop.data);
        }else {
            System.out.println("Loop not found");
        }

    }

    //floyd cycle finding algorithm
    public boolean detectLoop(){
        Node slow_p = head;
        Node fast_p = head;
        boolean loopStatus = false;
        while(slow_p !=null && fast_p != null && fast_p.next != null){
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if(slow_p == fast_p){
                loopStatus = true;
                return loopStatus;
            }
        }
        return loopStatus;
    }

    public Node findBeginOfLoop(){
        Node slow_p = head;
        Node fast_p = head;
        boolean loopStatus = false;
        while(slow_p !=null && fast_p != null && fast_p.next != null){
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if(slow_p == fast_p){
                loopStatus = true;
                break;
            }
        }

        if(loopStatus){
            slow_p = head;
            while(slow_p != fast_p){
            slow_p = slow_p.next;
            fast_p = fast_p.next;
            }
          return  fast_p;
        }else{
            return  null;
        }
    }

}
