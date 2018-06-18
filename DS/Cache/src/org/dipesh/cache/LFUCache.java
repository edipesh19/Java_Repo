package org.dipesh.cache;

import java.util.*;

public class LFUCache {
    private static final int DEFAULT_SIZE = 10;
    private int capacity;

    public HashMap<String, Node> store;
    private TreeMap<Integer, LinkedList<Node>> frequencies;


    public LFUCache() {
        capacity = DEFAULT_SIZE;
        store = new HashMap<>();
        frequencies = new TreeMap<>();
    }


    public String get(String key) {
        if(!store.containsKey(key))
            return null;
        Node n = store.get(key);

        // Move the node from one frequency list to another
        final int freq = n.getFrequency();
        final int nextFreq = freq + 1;
        n.setFrequency(nextFreq);
        frequencies.get(freq).remove(n);
        removeIfListEmpty(freq);
        frequencies.computeIfAbsent(nextFreq, ll -> new LinkedList<>()).add(n);
        return n.getValue();
    }

    public void set(String key, String value) {
        if(store.containsKey(key))
            return;
        Node n = new Node(1,key,value);
        if(store.size() >= capacity) {
            int lowKey = frequencies.firstKey();
            LinkedList<Node> ll = frequencies.get(lowKey);
            Node nodeDeleted = ll.removeFirst();
            store.remove(nodeDeleted.getKey());
            removeIfListEmpty(lowKey);
        }
        frequencies.computeIfAbsent(1, k->new LinkedList<>()).add(n);
        store.put(key, n);
    }


    private void removeIfListEmpty(int key) {
        LinkedList<Node> ll = frequencies.get(key);
        if(ll == null || ll.isEmpty()) {
            frequencies.remove(key);
        }
    }
}
