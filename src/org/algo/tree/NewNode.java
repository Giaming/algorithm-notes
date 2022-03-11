package org.algo.tree;

/**
 * @author giaming
 * @date 2022/2/25
 */
class NewNode {
    public int val;
    public NewNode left;
    public NewNode right;
    public NewNode next;

    public NewNode() {
    }

    public NewNode(int _val) {
        val = _val;
    }

    public NewNode(int _val, NewNode _left, NewNode _right, NewNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

