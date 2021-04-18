package com.tree.bfs.level.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigZagTraversal.traverse(root);
        System.out.println("ZigZag Level order traversal : "+result);
    }

    private static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()){

            int levelSize = queue.size();

            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                 TreeNode currentNode = queue.poll();

                 if(leftToRight){
                     currentLevel.add(currentNode.val);
                 }else{
                     currentLevel.add(0, currentNode.val);
                 }

                 if(currentNode.left != null){
                     queue.add(currentNode.left);
                 }
                 if(currentNode.right != null){
                     queue.add(currentNode.right);
                 }

            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
