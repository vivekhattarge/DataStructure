package com.binarytree;

public class BinaryTreeSearchElementWithRecursion {

    Node root;

    public static void main(String[] args) {

        BinaryTreeSearchElementWithRecursion binaryTree = new BinaryTreeSearchElementWithRecursion();

        binaryTree.root = new Node(2);
        binaryTree.root.left = new Node(7);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.right = new Node(6);
        binaryTree.root.left.right.left = new Node(1);
        binaryTree.root.left.right.right = new Node(11);
        binaryTree.root.right.right = new Node(9);
        binaryTree.root.right.right.left = new Node(4);

        boolean findingStatus = findElementInBinaryTree(binaryTree.root, 10);

        if (findingStatus) {
            System.out.println("Element Found");
        } else {
            System.out.println("Element not Found");
        }

    }

    private static boolean findElementInBinaryTree(Node root, Integer key) {

        if (root == null) {
            return false;
        }
        if (key == root.data) {
            return true;
        }
        boolean leftResult = findElementInBinaryTree(root.left, key);

        if (leftResult) {
            return true;
        }
        boolean rightResult = findElementInBinaryTree(root.right, key);

        if (rightResult) {
            return true;
        } else {
            return false;
        }

    }

}
