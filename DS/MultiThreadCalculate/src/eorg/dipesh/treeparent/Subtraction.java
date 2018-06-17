package eorg.dipesh.treeparent;

public class Subtraction implements IOperator {

    private  int a,b;

    public Subtraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int evaluate() {
        return a-b;
    }
}
