package eorg.dipesh.treeparent.client;

import eorg.dipesh.treeparent.Cache;
import eorg.dipesh.treeparent.LRUCache;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
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

    }

    private static void printCache(Cache<String,String> cache) {
        Set<Map.Entry<String,String>> entrySet = cache.getAll();
        for(Map.Entry<String,String> s : entrySet){
            System.out.println(s.getKey()+ " ====> " + s.getValue());
        }
    }
}
