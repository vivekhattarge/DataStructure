package com.tree.bfs.level.order;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {

    public static void main(String[] args) {
        TreeNodeWithNext root = new TreeNodeWithNext(12);
        root.left = new TreeNodeWithNext(7);
        root.right = new TreeNodeWithNext(1);
        root.left.left = new TreeNodeWithNext(9);
        root.right.left = new TreeNodeWithNext(10);
        root.right.right = new TreeNodeWithNext(5);
        ConnectAllLevelOrderSiblings.connect(root);
        ConnectAllLevelOrderSiblings.printTree(root);

    }

    private static void printTree(TreeNodeWithNext root) {

        TreeNodeWithNext current = root;

        while (current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }

    }

    private static void connect(TreeNodeWithNext root) {

        Queue<TreeNodeWithNext> queue = new LinkedList<>();
        queue.add(root);
        TreeNodeWithNext currentNode = null;
        TreeNodeWithNext previousNode = null;
        while (!queue.isEmpty()){

            currentNode = queue.poll();
            if (previousNode != null) {
                previousNode.next = currentNode;
            }
            previousNode = currentNode;

            if(currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if(currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }

    }

}
