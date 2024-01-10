package com.daily.challenges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,5,3,null,4,10,6,9,2], start = 3
 * Output: 4
 * Explanation: The following nodes are infected during:
 * - Minute 0: Node 3
 * - Minute 1: Nodes 1, 10 and 6
 * - Minute 2: Node 5
 * - Minute 3: Node 4
 * - Minute 4: Nodes 9 and 2
 * It takes 4 minutes for the whole tree to be infected so we return 4.
 *
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

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {

        static TreeNode actualStartNode = null;

    public static int amountOfTime(TreeNode root, int start) {
        
        TreeNode[] parents = new TreeNode[100005];
        findParents(root,null,parents,start);

        List<Integer> visited = new ArrayList<>();
        visited.add(start);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(actualStartNode);    
        int result = -1;
        while(!queue.isEmpty()){


        // visited.add(currentNode.val);
         int n = queue.size();    


          for(int i=0; i<n; i++){
              TreeNode currentNode = queue.peek();
              queue.remove();
              //for parent  
              if(parents[currentNode.val] != null && !visited.contains( parents[currentNode.val].val) ){
                 visited.add(parents[currentNode.val].val);
                 queue.add(parents[currentNode.val]);
              }  

              //for left child
              if(currentNode.left != null && !visited.contains(currentNode.left.val)){
                 visited.add(currentNode.left.val);
                 queue.add(currentNode.left);
              }  

              //for right child
              if(currentNode.right != null && !visited.contains(currentNode.right.val)){
                 visited.add(currentNode.right.val);
                 queue.add(currentNode.right);
              }  

          }
            result++;
        }
        return result;

    }

    static void findParents(TreeNode root, TreeNode p, TreeNode[] parents, int start){

            if(root == null){
                return;
            }

          parents[root.val] = p;
          if(root.val == start){
             actualStartNode = root;   
          }
    findParents(root.left,root,parents,start);
    findParents(root.right,root,parents,start);        
    }

    public static void main(String[] args)
    {
    /*      10
           /  \
          12  13
              / \
             14 15
            / \ / \
          21 22 23 24

        Let us create Binary Tree as shown
        above */

/*        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);

        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);

        root.right.left.left = new TreeNode(21);
        root.right.left.right = new TreeNode(22);
        root.right.right.left = new TreeNode(23);
        root.right.right.right = new TreeNode(24);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(3);

        root.left.left.left = new TreeNode(4);

        root.left.left.left.right = new TreeNode(5);




        //[1,2,null,3,null,4,null,5]

        int start = 2;

        // Function call
        int result = amountOfTime(root, start);
        System.out.println(result);
    }


}