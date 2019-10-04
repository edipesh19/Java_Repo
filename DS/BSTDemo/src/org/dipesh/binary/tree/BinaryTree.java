package org.dipesh.binary.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryTree {
    private Node root;

    public void insert(int data){
        Node n = new Node();
        n.data = data;
        if (root == null){
            root = n;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node tmp = queue.poll();

            if(tmp != null){
                if(tmp.left == null){
                    tmp.left = n;
                    break;
                } else{
                    queue.add(tmp.left);
                }
                if(tmp.right == null){
                    tmp.right = n;
                    break;
                } else {
                    queue.add(tmp.right);
                }
            }
        }
    }

    public List<Integer> printLevelOrdered(){
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        final List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp != null){
                System.out.println(tmp.data);
                list.add(tmp.data);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        return list;
    }

    public Map<Integer, List<Node>> printVerticalOrderTraversal(){
        if(root == null) return null;
        final Map<Integer, List<Node>> map = new HashMap<>();
        fillData(root, 0,map);
        return map;
    }

    void fillData(Node n, int val, Map<Integer, List<Node>> map){
        List<Node> list = map.get(val);
        if(list == null) {
            list = new ArrayList<>();
            map.put(val,list);
        }
        list.add(n);
        if(n.left != null) {
            fillData(n.left, val-1, map);
        }
        if(n.right != null){
            fillData(n.right, val+1, map);
        }
    }

    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        IntStream.rangeClosed(1, 9).forEach(i -> btree.insert(i));
        btree.printLevelOrdered();

        Map<Integer, List<Node>> ll = btree.printVerticalOrderTraversal();

        ll.keySet().stream().forEach(key -> {
            List<Node> l = ll.get(key);
            System.out.print(key + " -> [");
            l.stream().forEach(n -> System.out.print(n.data + ","));
            System.out.println("\b]");
        });

        ll.keySet().stream().forEach(key -> {
            List<Node> l = ll.get(key);
            System.out.print(l.get(0).data + " ");
        });
        System.out.println("\b");

        StringBuilder sb = new StringBuilder();
        for (int k : map.keySet().stream().sorted().collect(Collectors.toList())) {
            sb.append(map.get(k).get(0).data + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
