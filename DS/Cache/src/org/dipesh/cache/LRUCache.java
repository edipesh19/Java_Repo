package org.dipesh.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class LRUCache<K, V> extends LinkedHashMap<K, V> implements Cache<K, V> {

    private static int DEFAULT_SIZE = 20;

    private int capacity;

    public LRUCache(){
        super(DEFAULT_SIZE,1.0f,true);
        this.capacity = DEFAULT_SIZE;
    }

    public LRUCache(int capacity){
        super(capacity,1.0f,true);
        this.capacity = capacity;
    }
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > capacity;
    }

    @Override
    public V retrive(K key){
        V value = get(key);
        if(value == null){
            value = getFromSource(key);
            put(key,value);
        }
        return value;
    }

    @Override
    public V insert(K key, V value){
        return this.put(key,value);
    }

    @Override
    public Set<Map.Entry<K,V>> getAll(){
        return entrySet();
    }

    public abstract V getFromSource(K key);
}
