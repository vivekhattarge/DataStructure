package com.binary.search.tree;

public class FindLowestCommonAncestorInBST {

    Node root;

    public static void main(String[] args) {

        FindLowestCommonAncestorInBST tree = new FindLowestCommonAncestorInBST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10,n2=14;
        Node lcaNode = getLca(tree.root,n1,n2);

        System.out.println("LCA : of  n1 :"+n1+" and n2 :"+n2+" is "+lcaNode.data);

         n1 = 14;
         n2=8;
         lcaNode = getLca(tree.root,n1,n2);
        System.out.println("LCA : of  n1 :"+n1+" and n2 :"+n2+" is "+lcaNode.data);
    }

    private static Node getLca(Node node, int n1, int n2) {
        if(null == node){
            return null;
        }
        if(n1 < node.data && n2 < node.data){
           return getLca(node.left,n1,n2);
        }

        if(n1 > node.data && n2 > node.data){
            return getLca(node.right,n1,n2);
        }

        return node;
    }

}
