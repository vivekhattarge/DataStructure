package com.binary.search.tree;

public class PrintKthSmallestElement {
    private static int count;

    public static void main(String[] args) {

        Node root = null;
        int keys[] = {20, 8, 22, 4, 12, 10, 14};
        int k = 3;

        for (int key : keys) {
            root = insert(root, key);
        }
        count = 0;
        Node kthSmallest = getKthSmallest(root, k);
        System.out.println("kthSmallest is : " + kthSmallest.data);
    }

    private static Node getKthSmallest(Node root, int k) {

        if (root == null) {
            return null;
        }

        // iterate left subtree
        Node left = getKthSmallest(root.left, k);

        // if k'th smallest is found in left subtree then return it
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root;
        }
        return getKthSmallest(root.right, k);
    }

    private static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.data > key) {
            root.left = insert(root.left, key);
        } else if (root.data < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

}
