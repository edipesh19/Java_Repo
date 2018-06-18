package org.dipesh.cache.client;

import org.dipesh.cache.Cache;
import org.dipesh.cache.LFUCache;
import org.dipesh.cache.LRUCache;
import org.dipesh.cache.Node;

import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.LFUCacheTest();
        m.LFUCacheTest();
    }

    void LRUCacheTest(){
        System.out.println("==== Testing LRU =====");
        Cache<String, String> cache = new LRUCache<String, String>() {
            @Override
            public String getFromSource(String key) {
                return "Value - 11";
            }
        };
        for(int i = 0; i < 10; i++){
            cache.insert("Key - " + i, "Value - " + i );
        }

        printCache(cache);


        System.out.println("After Getting 4");
        System.out.println("================");
        cache.retrive("Key - 4");
        cache.retrive("Key - 11");

        printCache(cache);


        System.out.println("After pushing 10");
        System.out.println("================");
        cache.insert("Key - 10", "Value - 10");
        printCache(cache);
        System.out.println();
        System.out.println();
    }

    void LFUCacheTest(){
        System.out.println("==== Testing LFU =====");
        LFUCache cache = new LFUCache();
        for(int i = 1; i < 11; i ++) {
            cache.set("Key - " + i, "Value - " + i);
        }
        cache.get("Key - 1");
        cache.get("Key - 2");
        cache.get("Key - 4");
        cache.get("Key - 5");
        cache.get("Key - 6");
        cache.get("Key - 7");
        cache.get("Key - 8");
        cache.get("Key - 1");
        cache.get("Key - 8");
        cache.get("Key - 10");
        cache.get("Key - 9");
        cache.get("Key - 3");
        printCache(cache);

        System.out.println("=========================");
        cache.set("Key - 11", "Value - 11");
        printCache(cache);
    }

    private void printCache(LFUCache cache) {
        Set<Map.Entry<String,Node>> entrySet = cache.store.entrySet();
        for(Map.Entry<String,Node> s : entrySet){
            System.out.println(s.getKey()+ " ====> " + s.getValue().getValue() + " ====> " + s.getValue().getFrequency());
        }
    }

    private void printCache(Cache<String,String> cache) {
        Set<Map.Entry<String,String>> entrySet = cache.getAll();
        for(Map.Entry<String,String> s : entrySet){
            System.out.println(s.getKey()+ " ====> " + s.getValue());
        }
    }
}
