package com.linkedlist;// Java implementation to recursively
// find the nth node from the last 
// of the linked list 
import java.util.*; 
class GFG 
{ 
static int count = 0, data = 0; 

// a node of a linked list 
static class Node 
{ 
	int data; 
	Node next; 
} 

// function to get a new node 
static Node getNode(int data) 
{ 
	// allocate space 
	Node newNode = new Node(); 

	// put in data 
	newNode.data = data; 
	newNode.next = null; 
	return newNode; 
} 

// funnction to recursively 
// find the nth node from 
// the last of the linked list 
static void findNthFromLast(Node head, int n)
{ 
	// if list is empty 
	if (head == null) 
		return; 

	// recursive call 
	findNthFromLast(head.next, n);

	// increment count 
	count = count + 1; 
	
	// if true, then head is the 
	// nth node from the last 
	if (count == n) 
	{ 
		data = head.data; 
	} 
} 

// utility function to find 
// the nth node from the last 
// of the linked list 
static void findNthFromLastUtil(Node head, int n) 
{ 
	// Initialize 
	Node nth_last = new Node(); 
	count = 0; 

	// find nth node from the last 
	findNthFromLast(head, n);

	// if node exists, then print it 
	if (nth_last != null) 
		System.out.println("Nth node from last is: " + 
												data); 
	else
		System.out.println("Node does not exists"); 
} 

// Driver Code 
public static void main(String args[]) 
{ 
	// linked list: 4.2.1.5.3 
	Node head = getNode(4); 
	head.next = getNode(2); 
	head.next.next = getNode(1); 
	head.next.next.next = getNode(5); 
	head.next.next.next.next = getNode(3); 

	int n = 2; 

	findNthFromLastUtil(head, n); 
} 
} 

// This code is contributed 
// by Arnab Kundu 
