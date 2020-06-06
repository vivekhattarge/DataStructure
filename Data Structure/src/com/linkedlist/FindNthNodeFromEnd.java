package com.linkedlist;

public class FindNthNodeFromEnd {

    // Java program to find n'th node from end using slow and
// fast pointers
        Node head; // head of the list
       static int count;
        int data;

        /* Linked List node */
        class Node {
            int data;
            Node next;
            Node(int d)
            {
                data = d;
                next = null;
            }
            Node(){}
        }

        /* Function to get the nth node from end of list */
        void printNthFromLast(int n)
        {
            Node main_ptr = head;
            Node ref_ptr = head;

            int count = 0;
            if (head != null) {
                while (count < n) {
                    if (ref_ptr == null) {
                        System.out.println(n + " is greater than the no "
                                + " of nodes in the list");
                        return;
                    }
                    ref_ptr = ref_ptr.next;
                    count++;
                }
                while (ref_ptr != null) {
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                System.out.println("Node no. " + n + " from last is " + main_ptr.data);
            }
        }

        /* Inserts a new Node at front of the list. */
        public void push(int new_data)
        {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
            Node new_node = new Node(new_data);

            /* 3. Make next of new Node as head */
            new_node.next = head;

            /* 4. Move the head to point to new Node */
            head = new_node;
        }

        /*Drier program to test above methods */
        public static void main(String[] args)
        {
            FindNthNodeFromEnd llist = new FindNthNodeFromEnd();
            llist.push(20);
            llist.push(4);
            llist.push(15);
            llist.push(35);

            llist.printNthFromLast(4);
            llist.getNthNodeFromLast(3);

        }

        private void getNthNodeFromLast(int n){

            Node main_ptr = head;
            Node ref_ptr = head;
            int count =0;
            if(head != null){
                while(count < n){
                if(ref_ptr == null){
                    System.out.println("number is greater than list length");
                    return;
                }
                ref_ptr = ref_ptr.next;
                count += 1;
                }
                while(ref_ptr != null){
                    main_ptr = main_ptr.next;
                    ref_ptr = ref_ptr.next;
                }
                System.out.println("Nth node from end is : "+main_ptr.data);
            }
        }
}