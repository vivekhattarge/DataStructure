package com.tree.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindAllPaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> allTreePaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        getAllTreePaths(root,allTreePaths,currentPath,sum);
        System.out.println("Tree paths with sum " + sum + ": " + allTreePaths);
    }

    private static void getAllTreePaths(TreeNode currentNode, List<List<Integer>> allTreePaths, List<Integer> currentPath, int sum) {

        if(currentNode == null){
            return;
        }

        currentPath.add(currentNode.val);

        if(sum == currentNode.val && currentNode.left == null && currentNode.right ==null){
            allTreePaths.add(new ArrayList<>(currentPath));
        }else{

            // traverse left subtree
            getAllTreePaths(currentNode.left,allTreePaths,currentPath,sum- currentNode.val);

            // traverse right subtree
            getAllTreePaths(currentNode.right,allTreePaths,currentPath,sum- currentNode.val);

        }

        currentPath.remove(currentPath.size() -1);

    }

}
