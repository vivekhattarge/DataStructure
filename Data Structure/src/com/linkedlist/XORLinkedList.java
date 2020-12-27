package com.linkedlist;

/*Not  a complete Solution*/
public class XORLinkedList {

   static Node head;

    class Node{
        int data;
        int npx;
        Node(int newData){
            this.data = newData;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", npx=" + npx +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "XORLinkedList{" +
                "head=" + head +
                '}';
    }

    public static void main(String[] args) {

        XORLinkedList xorLinkedList = new XORLinkedList();
        xorLinkedList.push(head,10);
        xorLinkedList.push(head,20);

    }

    int xOR(Node a, Node b){
        return  a==null ? 0 : a.data ^ b.data;
    }

    public void push(Node firstNode, int newData){
        Node node = new Node(newData);
        node.npx =  xOR(firstNode,node);
        head = node;
    }
}
