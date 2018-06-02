package org.dipesh.concurrent;

public class EvenChecker implements Runnable{

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while(!generator.isCancel()){
            int val = generator.next();
            if(val%2 != 0){
                System.out.println(val + " is not even");
                generator.setCancel();
            }
        }
    }
}


