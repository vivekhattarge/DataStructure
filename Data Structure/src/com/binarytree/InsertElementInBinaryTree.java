package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElementInBinaryTree {

    static Node root;

    public static void main(String[] args) {

        InsertElementInBinaryTree binaryTree = new InsertElementInBinaryTree();
        binaryTree.root = null;

        //insert root
        insertNode(null, 10);

        insertNode(root, 12);
        insertNode(root, 13);
        insertNode(root, 14);
        insertNode(root, 15);

        System.out.println(root);

        System.out.println("size of binary tree is : "+sizeOfBinaryTree(root));

    }

    private static Integer sizeOfBinaryTree(Node root) {

        if(root == null){
            return 0;
        }
        return (sizeOfBinaryTree(root.left) + 1 + sizeOfBinaryTree(root.right));
    }

    private static void insertNode(Node temp, int element) {

        if (temp == null) {
            InsertElementInBinaryTree.root = new Node(element);
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(temp);

        while (!queue.isEmpty()) {

            temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(element);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(element);
                break;
            } else {
                queue.add(temp.right);
            }
        }

    }

}
