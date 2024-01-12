package com.daily.challenges;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class GetMaxDiffBetweenAncesterAndChildNode {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        return getMaxDiff(root,root.val,root.val);
    }
    int getMaxDiff(TreeNode root,int currentMax,int currentMin){
        if(root == null){
            return currentMax - currentMin;
        }
        currentMax = Math.max(currentMax,root.val);
        currentMin = Math.min(currentMin,root.val);

        int left = getMaxDiff(root.left,currentMax,currentMin);
        int right = getMaxDiff(root.right,currentMax,currentMin);
        return Math.max(left,right);
    }
}
