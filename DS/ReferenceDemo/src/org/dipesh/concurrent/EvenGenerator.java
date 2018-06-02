package org.dipesh.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenGenerator extends IntGenerator {
    private int currentVal = 0;
    Lock lock = new ReentrantLock();

    // Not thread Safe
    @Override
    public int next() {
        ++currentVal;
        ++currentVal;
        return currentVal;
    }

    // Thread safe
//    @Override
//    public int next() {
//        lock.tryLock();
//        try {
//            System.out.println("Lock Captured");
//            ++currentVal;
//            ++currentVal;
//        }finally{
//            lock.unlock();
//        }
//        return currentVal;
//    }


}
