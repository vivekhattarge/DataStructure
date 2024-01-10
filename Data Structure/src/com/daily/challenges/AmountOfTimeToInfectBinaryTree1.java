package com.daily.challenges;

import java.util.*;
/*
* You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.



Example 1:


Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
*
* */
public class AmountOfTimeToInfectBinaryTree1 {

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        private void convert(TreeNode node, int parent) {
            graph.put(node.val, new HashSet<>());

            if (parent > 0)
                graph.get(node.val).add(parent);

            if (node.left != null) {
                graph.get(node.val).add(node.left.val);
                convert(node.left, node.val);
            }
            if (node.right != null) {
                graph.get(node.val).add(node.right.val);
                convert(node.right, node.val);
            }
        }

        public int amountOfTime(TreeNode root, int start) {
            convert(root, 0);

            var queue = new ArrayDeque<Integer>();
            queue.offer(start);

            var seen = new HashSet<>();
            var min = -1;

            while (!queue.isEmpty()) {
                for (var i = queue.size(); i > 0; i--) {
                    var node = queue.poll();
                    seen.add(node);

                    for (var neighbor : graph.get(node))
                        if (!seen.contains(neighbor))
                            queue.offer(neighbor);
                }
                min++;
            }
            return min;
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
        int result = new AmountOfTimeToInfectBinaryTree1().amountOfTime(root, start);
        System.out.println(result);
    }

}

