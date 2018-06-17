package eorg.dipesh.treeparent;

import java.util.concurrent.Callable;

public class AsyncEvaluator implements Callable<Integer> {
    private IOperator obj;

    public AsyncEvaluator(IOperator obj) {
        this.obj = obj;
    }


    @Override
    public Integer call() throws Exception {
        return obj.evaluate();
    }
}
