package org.dipesh.heap;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class HeapTest {
    private static PriorityQueue<Integer> lower = new PriorityQueue<>();
    private static PriorityQueue<Integer> higher = new PriorityQueue<>((a, b) -> b.compareTo(a));

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("key_1","value_1");



        linkedHashMap.put("key_2","value_2");


        linkedHashMap.put("key_3","value_3");


// Get a set of all the entries (key - value pairs) contained in the LinkesHashMap


        Set entrySet = linkedHashMap.entrySet();


// Obtain an Iterator for the entries Set


        Iterator it = entrySet.iterator();


// Iterate through LinkedHashMap entries



        System.out.println("LinkedHashMap entries : ");



        while(it.hasNext())


            System.out.println(it.next());
        Scanner sc = new Scanner(System.in);
        sc.next();
    }
}
