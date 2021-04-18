package com.tree.bfs.level.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AveragesAtAllLevels {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = AveragesAtAllLevels.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }

    private static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            double currentSum = 0;
            int levelSize = queue.size();

            for(int i =0; i< levelSize ; i++){
                TreeNode currentNode = queue.poll();
                currentSum = currentSum + currentNode.val;

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }

            }
            double levelAverage = currentSum/levelSize;
            result.add(levelAverage);
        }

        return result;
    }

}
