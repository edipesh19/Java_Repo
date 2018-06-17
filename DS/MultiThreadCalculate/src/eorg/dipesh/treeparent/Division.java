package eorg.dipesh.treeparent;

public class Division implements IOperator {

    private int a,b;

    public Division(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int evaluate() {
        if( b == 0) {
            throw new IllegalArgumentException("The divisor should not be zero");
        }
        return a/b;
    }
}
