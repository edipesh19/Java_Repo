package org.dipesh.treeparent;

public class Node {
    Node left;
    Node right;
    Node parent;
    int key;

    public Node(int data){
        this.key = data;
        left = null;
        right = null;
        parent = null;
    }
}
