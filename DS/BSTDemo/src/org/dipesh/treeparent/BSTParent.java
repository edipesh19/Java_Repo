package org.dipesh.treeparent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BSTParent {
    public Node root;



    public Node closestNode;

    public BSTParent(int key) {
        root = new Node(key);
    }

    public BSTParent() {
    }

    //Insert
    public void insertRecursive(int key) {
        root = insert(root, key);
    }

    public void insertIterative(int key) {
        Node n = new Node(key);
        if (root == null) {
            root = n;
            return;
        }
        Node focusNode = root;
        Node parent;
        while (true) {
            parent = focusNode;
            if (key < focusNode.key) {
                focusNode = focusNode.left;
                if (focusNode == null) {
                    parent.left = n;
                    n.parent = parent;
                    return;
                }
            } else if (key > focusNode.key) {
                focusNode = focusNode.right;
                if (focusNode == null) {
                    parent.right = n;
                    n.parent = parent;
                    return;
                }
            } else {
                return;
            }
        }
    }

    private Node insert(Node r, int key) {
        if (r == null) {
            r = new Node(key);
            return r;
        }

        if (key < r.key) {
            r.left = insert(r.left, key);
            r.left.parent = r;
        } else if (key > r.key) {
            r.right = insert(r.right, key);
            r.right.parent = r;
        }
        return r;
    }


    //Delete
    public Node delete(Node root, int val) {
        if (root == null) return root;
        if (val < root.key) root.left = delete(root.left, val);
        else if (val > root.key) root.right = delete(root.right, val);
        else {
            //case1
            if (root.left == null && root.right == null)
                return null;
            //case2
            else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }
            //case3
            Node min = min(root.right);
            root.key = min.key;
            root.right = delete(root.right, min.key);
        }
        return root;
    }

    //Find
    public Node findRec(int key) {
        return find(root, key);
    }

    public Node findItr(int key) {
        Node focusNode = root;
        while (focusNode != null && focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
        }
        return focusNode;
    }

    private Node find(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key > key) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    //minimum
    public Node min(Node x) {
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    //maximum
    public Node max(Node x) {
        while (x.right != null) {
            x = x.right;
        }
        return x;
    }

    //successor -> Just greater than x
    // Logic if right subtree is there then minimum of right subtree
    // else keep traveling up towards extreme left.Parent of that
    public Node findSuccessor(Node x) {
        if (x.right != null) {
            return min(x.right);
        }
        Node p = x.parent;
        Node n = x;
        while (p != null && p.right == n) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    //prederssor -> Just smaller than x
    public Node findPredessor(Node x) {
        if (x.left != null) {
            return max(x.left);
        }
        Node p = x.parent;
        Node n = x;
        while (p != null && p.left == n) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    //Traversal - Inorder Recursive
    public List<Integer> inOrderRec() {
        List<Integer> list = new ArrayList<>();
        list = inOrderTraversal(root, list);
        return list;
    }

    // Traversal - PostOrder Recursive
    public List<Integer> postOrderRec(){
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    // Traversal - PostOrder Iterative
    public List<Integer> postOrderIterative(){
        List<Integer> list = new ArrayList<>();
        Node cur = root;
        Node prev = null;
        Stack<Node> st = new Stack<>();
        while(cur != null || !st.isEmpty()){
            if(cur != null){
                st.push(cur);
                cur = cur.left;
            }
            else{
                Node temp = st.peek();
                if(temp.right == null){
                    st.pop();
                    list.add(temp.key);
                    prev = temp;
                }else{
                    if(prev == temp.right){
                        st.pop();
                        list.add(temp.key);
                        prev = temp;
                    }else {
                        cur = temp.right;
                    }
                }
            }
        }
        return list;
    }
    //Misc
    //1.Find closest value
    public int findClosestValue(Node node, int key) {
        int minDiff = findMinDiff(node, key);
        return minDiff + key;
    }

    private int findMinDiff(Node p, int key) {
        if (p == null) {
            return Integer.MAX_VALUE;
        }
        if (key > p.key) {
            int rv = findMinDiff(p.right, key);
            if (rv == Integer.MAX_VALUE)
                closestNode = p;
            return getMinAbs(p.key - key, rv);
        } else {
            int lv = findMinDiff(p.left, key);
            if (lv == Integer.MAX_VALUE)
                closestNode = p;
            return getMinAbs(p.key - key, lv);
        }
    }

    private int getMinAbs(int a, int b) {
        if (Math.abs(a) > Math.abs(b)) {
            return b;
        }
        return a;
    }

    public boolean rootToLeafSum(Node root, int sum, List<Integer> result){
        if(root == null) return false;
        if(sum - root.key == 0){
            if(root.left == null && root.right == null){
                result.add(root.key);
                return true;
            }else{
                return false;
            }
        }
        if(rootToLeafSum(root.left, sum- root.key, result)){
            result.add(root.key);
            return true;
        }
        if(rootToLeafSum(root.right, sum- root.key, result)){
            result.add(root.key);
            return true;
        }
        return false;

    }

    public Node getMirrorImage(Node root){
        Node temp;
        if(root != null){
            getMirrorImage(root.left);
            getMirrorImage(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public boolean areMirrorImage(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.key != r2.key) return false;
        else{
            return areMirrorImage(r1.left, r2.right) && areMirrorImage(r1.right, r2.left);
        }
    }

    private List<Integer> inOrderTraversal(Node node, List<Integer> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.key);
            inOrderTraversal(node.right, list);
        }
        return list;
    }

    private void postOrderTraversal(Node root, List<Integer> list) {
        if(root != null) {
            postOrderTraversal(root.left, list);
            postOrderTraversal(root.right, list);
            list.add(root.key);
        }
    }
}
