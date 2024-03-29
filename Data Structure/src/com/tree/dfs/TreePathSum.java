package com.tree.dfs;

public class TreePathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));

    }

    private static boolean hasPath(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        if(root.left == null && root.right == null && root.val == sum){
            return true;
        }
        return hasPath(root.left,sum- root.val) || hasPath(root.right,sum- root.val);
    }

}
