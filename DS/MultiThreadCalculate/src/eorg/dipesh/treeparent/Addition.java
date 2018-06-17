package eorg.dipesh.treeparent;

public class Addition implements IOperator {

    private int a,b;

    public Addition(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int evaluate() {
        return a+b;
    }
}
