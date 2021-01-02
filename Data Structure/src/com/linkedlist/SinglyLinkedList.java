package com.linkedlist;

public class SinglyLinkedList {

    private int length = 0;
    private ListNode head;

    public SinglyLinkedList() {
        length = 0;
    }

    // insert node at beginning
    public synchronized ListNode getHeadNode() {
        return head;
    }

    //insert node at beginning
    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length += 1;
    }

    public synchronized void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode p, q;
            for (p = head; (q = p.getNext()) != null; p = q) {
                p.setNext(node);
            }
        }
        length += 1;
    }

    public void insert(int data, int position) {

        // fix position value
        if (position < 0) {
            position = 0;
        }
        if (position > length) {
            position = length;
        }
        //if list is empty
        if (head == null) {
            head = new ListNode(data);
        }
        // if position is zero add new node at first
        else if (position == 0) {
            ListNode temp = new ListNode(data);
            temp.setNext(head);
            head = temp;
        } else {
            ListNode temp = head;
            for (int i = 1; i < position; i += 1) {
                temp = temp.getNext();
            }
            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        length += 1;
    }

    public void remove(int position) {
        //fix position
        if (position < 0) {
            position = 0;
        }
        if (position >= length) {
            position = length - 1;
        }
        // if nothing in list then do nothing
        if (head == null) {
            return;
        } else {
            ListNode temp = head;
            for (int i = 1; i < position; i += 1) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        //reduce length by 1
        length -= 1;
    }

    public static int getLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length += 1;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public int getPosition(int data) {
        ListNode temp = head;
        int position = 0;
        while (temp != null) {
            if (data == temp.getData()) {
                return position;
            }
            temp = temp.getNext();
            position += 1;
        }
        return Integer.MIN_VALUE;
    }

    public ListNode getNthNodeFromEnd(ListNode head, int nthNode) {
        ListNode endPointer = head;
        ListNode resultNode = null;

        for (int i = 0; i < nthNode; i++) {
            if (endPointer != null) {
                endPointer = endPointer.getNext();
            }
        }

        while (endPointer != null) {
            if (resultNode == null) {
                resultNode = head;
            } else {
                resultNode = resultNode.getNext();
            }
            endPointer = endPointer.getNext();
        }

        if (resultNode != null) {
            return resultNode;
        }

        return null;
    }

    private static int counter = 0;

    public static ListNode nthNodeFromEndWithRecursion(ListNode head, int nthNode) {
        ListNode result = head;
        if (head != null) {
            result = nthNodeFromEndWithRecursion(result.getNext(), nthNode);
            counter += 1;
            if (nthNode == counter) {
                result = head;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "ReverseKNodesOfLinkedList{" +
                "length=" + length +
                ", head=" + head +
                '}';
    }
}
