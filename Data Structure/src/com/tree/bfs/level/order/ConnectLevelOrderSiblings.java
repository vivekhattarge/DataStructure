package com.tree.bfs.level.order;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    public static void main(String[] args) {

        TreeNodeWithNext root = new TreeNodeWithNext(12);
        root.left = new TreeNodeWithNext(7);
        root.right = new TreeNodeWithNext(1);
        root.left.left = new TreeNodeWithNext(9);
        root.right.left = new TreeNodeWithNext(10);
        root.right.right = new TreeNodeWithNext(5);
        ConnectLevelOrderSiblings.connect(root);
        ConnectLevelOrderSiblings.printLevelOrder(root);
    }

    private static void printLevelOrder(TreeNodeWithNext root) {

        TreeNodeWithNext nextLevelRoot = root;

        while (nextLevelRoot != null){

            TreeNodeWithNext current = nextLevelRoot;
            nextLevelRoot = null;

            while (current != null){
                System.out.print(current.val+" ");

                if(nextLevelRoot == null){

                    if(current.left != null){
                        nextLevelRoot = current.left;
                    }else if(current.right != null){
                        nextLevelRoot = current.right;
                    }

                }

                current = current.next;

            }
            System.out.println();
        }


    }


    private static void connect(TreeNodeWithNext root) {

        Queue<TreeNodeWithNext> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNodeWithNext previous = null;
            for(int i=0; i<levelSize;i++){

                TreeNodeWithNext currentNode = queue.poll();
                if (previous != null) {
                    previous.next = currentNode;
                }
                previous = currentNode;

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
        }

    }

}
