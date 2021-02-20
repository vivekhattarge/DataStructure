package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxElementWithoutRecursion {

    Node root;

    public static void main(String[] args) {

        BinaryTreeMaxElementWithoutRecursion binaryTree = new BinaryTreeMaxElementWithoutRecursion();

        binaryTree.root = new Node(2);
        binaryTree.root.left = new Node(7);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.right = new Node(6);
        binaryTree.root.left.right.left = new Node(1);
        binaryTree.root.left.right.right = new Node(11);
        binaryTree.root.right.right = new Node(9);
        binaryTree.root.right.right.left = new Node(4);

        System.out.println("maximum element without recursion is : " + getMaxElement(binaryTree.root));

    }

    private static Integer getMaxElement(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Integer maxElement = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            Node polledNode = queue.poll();

            if (polledNode.data > maxElement) {
                maxElement = polledNode.data;
            }
            if (polledNode.left != null) {
                queue.add(polledNode.left);
            }

            if (polledNode.right != null) {
                queue.add(polledNode.right);
            }

        }
        return maxElement;
    }


}
