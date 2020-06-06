package com.linkedlist;

public class DoublyLinkedList {

    private DLLNode head;

    //get value in position
    public int get(int position){
        return  Integer.MIN_VALUE;
    }

    public int getPosition(int data){
        DLLNode temp = head;
        int position = 0;
        while (temp != null){
            if(temp.getData() == data){
                return  position;
            }
            position +=1 ;
            temp = temp.getNext();
        }
        return  Integer.MIN_VALUE;
    }

    public DLLNode getHeadNode(){
        return head;
    }

    public static int getLength(DLLNode headNode){
        int length = 0;
        DLLNode currentNode = headNode;
        while (currentNode != null){
            length += 1;
            currentNode = currentNode.getNext();
        }
        return  length;
    }

    public void insert(int data, int position,int length){
        //fix the position value
        if(position < 0){
            position = 0;
        }
        if(position > length){
            position = length;
        }
        if(head == null){
            head = new DLLNode(data);
            head.setPrev(null);
            return;
        }else if(position == 0){
            DLLNode temp = new DLLNode(data);
            temp.setNext(head);
            temp.setPrev(null);
            head.setPrev(temp);
            head = temp;
        }else{
            DLLNode temp = head;
            for(int i=1; i < position ; i +=1){
                temp = temp.getNext();
            }
        DLLNode newNode = new DLLNode(data);
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        if(newNode.getNext() != null){
        newNode.getNext().setPrev(newNode);
        }
        temp.setNext(newNode);
        }
    }
}
