package com.company;

import java.lang.ref.*;
import java.util.LinkedList;

// Garbage collector can collect an object if only weak references are pointing towards it and
// they are eagerly collected, on the other hand Objects with SoftReference are collected when
// JVM absolutely needs memory.
public class ReferenceDemo {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();
    public static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if(inq != null){
            System.out.println("In queue " + inq.get());
        }
    }



    public static void main(String[] args) {

        int size = 10;
        if(args.length > 0){
            size = new Integer(args[0]);
        }

        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();

        for ( int i = 0; i < size; i++){
            sa.add(new SoftReference<>(new VeryBig("Soft " + i), rq));
            System.out.println("Just created " + sa.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();

        for ( int i = 0; i < size; i++){
            wa.add(new WeakReference<>(new VeryBig("Weak " + i), rq));
            System.out.println("Just created " + wa.getLast());
            checkQueue();
        }


        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak"));

        //System.gc();

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for ( int i = 0; i < size; i++){
            pa.add(new PhantomReference<>(new VeryBig("Phantom " + i), rq));
            System.out.println("Just created " + pa.getLast());
            checkQueue();
        }

        System.gc();
    }
}



class VeryBig {
    private static final int SIZE=10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return "VeryBig{" +
                "ident='" + ident + '\'' +
                '}';
    }

    protected void finalize(){
        System.out.println("Finalizing " + ident);
    }
}