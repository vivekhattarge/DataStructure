package com.tree.bfs.level.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

    public static void main(String[] args) {
        TreeNodeWithNext root = new TreeNodeWithNext(12);
        root.left = new TreeNodeWithNext(7);
        root.right = new TreeNodeWithNext(1);
        root.left.left = new TreeNodeWithNext(9);
        root.right.left = new TreeNodeWithNext(10);
        root.right.right = new TreeNodeWithNext(5);
        root.left.left.left = new TreeNodeWithNext(3);
        List<Integer> result = RightViewOfBinaryTree.traverse(root);
        for (int nodeVal : result) {
            System.out.print(nodeVal + " ");
        }
    }

    private static List<Integer> traverse(TreeNodeWithNext root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNodeWithNext> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNodeWithNext currentNode = queue.poll();

                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }

            }

        }


        return result;
    }

}
