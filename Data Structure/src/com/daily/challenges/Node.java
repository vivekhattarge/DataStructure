package com.daily.challenges;// Java code for the above approach
import java.io.*;
import java.util.*;

class Node {
int val;
Node left, right;

public Node(int item)
{
	val = item;
	left = right = null;
}

	Node insertLevelOrder(int[] arr, int i)
	{
		Node root = null;
		// Base case for recursion
		if (i < arr.length) {
			root = new Node(arr[i]);

			// insert left child
			root.left = insertLevelOrder(arr, 2 * i + 1);

			// insert right child
			root.right = insertLevelOrder(arr, 2 * i + 2);
		}
		return root;
	}
}

class GFG {
static Node node = null;

// Function for generating
// parent-root relationship
static void findParent(Node root, Node p, Node[] parent,
						int start)
{
	if (root == null)
	return;

	// Store parent of current node
	parent[root.val] = p;

	if (root.val == start) {
	node = root;
	}

	findParent(root.left, root, parent, start);
	findParent(root.right, root, parent, start);
}

// Function to return the minimum amount
// of time require to infect all the
// nodes of binary tree
static int amountOfTime(Node root, int start)
{

	Node[] parent = new Node[100005];
	findParent(root, null, parent, start);

	boolean[] visited = new boolean[100005];
	Arrays.fill(visited, false);

	Queue<Node> q = new LinkedList<>();

	// add special tree node into the
	// queue and make it visited.
	q.add(node);
	visited[start] = true;

	// This store the minimum time require
	// to infect all the tree node.
	int result = -1;

	while (q.size() > 0) {
	int n = q.size();

	for (int i = 0; i < n; i++) {
		Node curr = q.peek();
		int currNode = curr.val;
		q.remove();

		// Check if parent of currNode
		// exist and not visited yet
		// then add this parent of
		// current node into queue.
		if (parent[currNode] != null
			&& visited[parent[currNode].val]
			== false) {
		visited[parent[currNode].val] = true;
		q.add(parent[currNode]);
		}

		// Check if current node left
		// child exist and not
		// visited yet.
		if (curr.left!=null
			&& visited[curr.left.val] == false) {
		visited[curr.left.val] = true;
		q.add(curr.left);
		}

		// Check if current node right
		// child exist and not
		// visited yet.
		if (curr.right!=null
			&& visited[curr.right.val] == false) {
		visited[curr.right.val] = true;
		q.add(curr.right);
		}
	}

	// Increment the time
	result++;
	}

	// Return the result.
	return result;
}

public static void main(String[] args)
{
	/*	 10
		/ \
		12 13
			/ \
			14 15
			/ \ / \
		21 22 23 24

		Let us create Binary Tree as shown
		above */

	Node root = new Node(1);
	root.left = new Node(2);

	root.left.left = new Node(3);

	root.left.left.left = new Node(4);

	root.left.left.left.right = new Node(5);

	int start = 2;

	/*Node t2 = new Node();
	int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
	t2.root = t2.insertLevelOrder(arr, 0);
*/

	// Function call
	int result = amountOfTime(root, start);
	System.out.println(result);
}


}

// This code is contributed by ishankhandelwals.
