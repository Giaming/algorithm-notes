package org.algo.树;

import java.util.List;

/**
 * @author giaming
 * @date 2022/2/25
 */
class Node {
    public int val;
    public List<Node> children;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
