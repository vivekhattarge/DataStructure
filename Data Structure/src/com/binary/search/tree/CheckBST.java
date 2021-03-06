package com.binary.search.tree;

public class CheckBST {

    Node root;
    public static void main(String[] args) {

        CheckBST tree = new CheckBST();
      /*  tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);*/

        tree.root = new Node(3);
        tree.root.left =new Node(2);
        tree.root.right =new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);

        boolean isBST = isBST(tree.root);
        boolean isBST2 = isBST2(tree.root,null,null);
        if(isBST){
        System.out.println("Given tree is BST using BST1");
        }else{
            System.out.println("Given tree is not BST using BST1");
        }

        if(isBST2){
            System.out.println("Given tree is BST using BST2");
        }else{
            System.out.println("Given tree is not BST using BST2");
        }


    }

    private static boolean isBST2(Node node, Node l, Node r) {
        if(node == null){
            return true;
        }

        if(l != null && node.data <= l.data){
            return  false;
        }

        if(r != null && node.data >= r.data){
            return false;
        }

        return isBST2(node.left,l,node) &&
                isBST2(node.right,node,r);

    }

    private static boolean isBST(Node node) {
        if(null == node){
            return true;
        }
        if(node.left != null && node.left.data > node.data){
          return false;
        }
        if(node.right != null && node.right.data < node.data){
            return false;
        }
        if(!isBST(node.left) || !isBST(node.right)){
            return false;
        }
        return true;
    }


}
