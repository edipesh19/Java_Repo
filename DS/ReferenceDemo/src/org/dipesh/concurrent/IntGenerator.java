package org.dipesh.concurrent;

public abstract class IntGenerator {
    private volatile boolean cancel = false;
    public abstract int next();
    public void setCancel(){cancel=true;}

    public boolean isCancel(){return cancel;}
}
