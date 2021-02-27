package com.binarytree;

public class MirrorOfBinaryTree {

    private static Node root;

    private static void inOrder(Node node)
    {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) {

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Before  : ");
        inOrder(root);
       root = mirror(root);
        System.out.print("After  : ");
       inOrder(root);
    }

    private static Node mirror(Node node) {

        if(node == null){
            return node;
        }

        Node left = mirror(node.left);
        Node right = mirror(node.right);

        //swap nodes
        Node temp = left;
        node.left =  right;
        node.right = temp;

        return node;
    }


}
