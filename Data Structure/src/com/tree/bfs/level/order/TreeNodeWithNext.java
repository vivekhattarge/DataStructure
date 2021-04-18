package com.tree.bfs.level.order;

public class TreeNodeWithNext {
    int val;
    TreeNodeWithNext left;
    TreeNodeWithNext right;
    TreeNodeWithNext next;

    TreeNodeWithNext(int val) {
        this.val = val;
        left = right = next = null;
    }

}
