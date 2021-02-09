package com.binarytree;

public class BinaryTreeMaximumElement {

    Node root;
    public static void main(String[] args) {

        BinaryTreeMaximumElement binaryTree = new BinaryTreeMaximumElement();

        binaryTree.root = new Node(2);
        binaryTree.root.left = new Node(7);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.right = new Node(6);
        binaryTree.root.left.right.left = new Node(1);
        binaryTree.root.left.right.right = new Node(11);
        binaryTree.root.right.right = new Node(9);
        binaryTree.root.right.right.left = new Node(4);

        System.out.println("Maximum element in binary tree is : "+findMaximumElement(binaryTree.root));

    }

    private static int findMaximumElement(Node root) {

           if(root == null){
               return  Integer.MIN_VALUE;
           }

        int maxElement = root.data;

        int leftMax = findMaximumElement(root.left);

        int rightMax = findMaximumElement(root.right);

        if(leftMax > maxElement){
            maxElement = leftMax;
        }
        if(rightMax > maxElement){
            maxElement = rightMax;
        }

        return  maxElement;
    }

}
