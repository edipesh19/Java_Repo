package eorg.dipesh.treeparent;

import java.util.concurrent.Callable;

public class Multiplication implements IOperator {
    private int a,b;

    public Multiplication(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int evaluate() {
        return a*b;
    }
}
