package org.dipesh.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            ex.ex(new EvenChecker(new EvenGenerator(),1));
        }
        ex.shutdown();
    }
}
