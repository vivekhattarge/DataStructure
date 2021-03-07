package com.binary.search.tree;

import java.util.HashSet;
import java.util.Set;

public class CheckIsTwoBSTsAreIndenticalOrNot {

    Node root;
    public static void main(String[] args) {

        CheckIsTwoBSTsAreIndenticalOrNot tree1 = new CheckIsTwoBSTsAreIndenticalOrNot();

        tree1.root = new Node(15);
        tree1.root.left = new Node(10);
        tree1.root.right = new Node(20);
        tree1.root.left.left = new Node(5);
        tree1.root.left.right = new Node(12);
        tree1.root.right.right = new Node(25);

        CheckIsTwoBSTsAreIndenticalOrNot tree2 = new CheckIsTwoBSTsAreIndenticalOrNot();

        tree2.root = new Node(15);
        tree2.root.left = new Node(12);
        tree2.root.right = new Node(20);
        tree2.root.left.left = new Node(5);
        tree2.root.left.right = new Node(10);
        tree2.root.right.right = new Node(25);

        Set<Integer> firstTreeSet = new HashSet<>();
        Set<Integer> secondTreeSet = new HashSet<>();

        insertIntoSet(tree1.root,firstTreeSet);
        insertIntoSet(tree2.root,secondTreeSet);

        if(firstTreeSet.equals(secondTreeSet)){
            System.out.println("Both Trees are identical");
        }else{
            System.out.println("Trees are not identical");
        }

    }

    private static void insertIntoSet(Node root, Set<Integer> set) {
        if(root == null){
            return;
        }
        insertIntoSet(root.left,set);
        set.add(root.data);
        insertIntoSet(root.right,set);
    }

}
