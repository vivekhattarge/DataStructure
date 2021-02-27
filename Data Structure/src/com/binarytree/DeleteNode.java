package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {

    private static Node root;

    public static void main(String[] args) {

        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.println(root);

        int key = 11;

        delete(root, key);

        System.out.println(root);


    }

    private static void delete(Node root, int key) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;
        Node keyNode = null;

        while (!queue.isEmpty()) {

            temp = queue.poll();

            if (temp.data == key) {
                keyNode = temp;
            }
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        System.out.println("queue :" + queue);

        //temp is last node here
        if (keyNode != null) {
            //copy temp data so that this will be copied in the node which is to be deleted
            int x = temp.data;

            //this will delete last node.... rightmost node will be given priority
            deleteDeepest(root, temp);

            //copy last node data which got deleted
            keyNode.data = x;
        }

    }

    private static void deleteDeepest(Node root, Node deleteNode) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        Node temp = null;

        while (!queue.isEmpty()) {

            temp = queue.poll();

            if (temp == deleteNode) {
                temp = null;
                return;
            }
            if (temp.right != null) {
                if (temp.right == deleteNode) {
                    temp.right = null;
                    return;

                } else {
                    queue.add(temp.right);
                }
            }
            if (temp.left != null) {
                if (temp.left == deleteNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
        }

    }


}
