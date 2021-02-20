package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchElementWithoutRecursion {

    Node root;

    public static void main(String[] args) {

        SearchElementWithoutRecursion binaryTree = new SearchElementWithoutRecursion();

        binaryTree.root = new Node(2);
        binaryTree.root.left = new Node(7);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.right = new Node(6);
        binaryTree.root.left.right.left = new Node(1);
        binaryTree.root.left.right.right = new Node(11);
        binaryTree.root.right.right = new Node(9);
        binaryTree.root.right.right.left = new Node(4);


        boolean isElementPresent = isPresent(binaryTree.root,10);

        if(isElementPresent){
            System.out.println("Element Found");
        }else {
            System.out.println("Element not Found");
        }

    }

    private static boolean isPresent(Node root, int key) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){

            Node element = queue.poll();

            if(key == element.data){
                return true;
            }

            if(element.left != null){
                queue.add(element.left);
            }
            if(element.right != null){
                queue.add(element.right);
            }
        }
        return false;
    }

}
