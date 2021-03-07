package com.binary.search.tree;

public class DistanceBetweenTwoNodesInBST {

    Node root;
    static int k1 = 10, k2 = 22;

    public static void main(String[] args) {

        DistanceBetweenTwoNodesInBST tree = new DistanceBetweenTwoNodesInBST();

        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);


       printInBetweenNodes(tree.root,k1,k2);

    }

    private static void printInBetweenNodes(Node root, int k1, int k2) {

        if (root == null) {
            return;
        }
        if (root.data > k1) {
            printInBetweenNodes(root.left, k1, k2);
        }
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(" " + root.data);
        }
        if (root.data < k2) {
            printInBetweenNodes(root.right, k1, k2);
        }

    }

}
