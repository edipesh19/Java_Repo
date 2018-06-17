package eorg.dipesh.treeparent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private volatile int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        m.parallelCall();
    }

    private void parallelCall() throws InterruptedException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(new AsyncEvaluator(new Addition(10, 5)));
        tasks.add(new AsyncEvaluator(new Division(10, 5)));
        tasks.add(new AsyncEvaluator(new Multiplication(10, 5)));
        tasks.add(new AsyncEvaluator(new Subtraction(10, 5)));
        ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());


        System.out.println(exec.invokeAll(tasks).stream().map(i -> {
            try {
                return i.get();
            } catch (InterruptedException e) {
                System.out.println("Exception " + e.getMessage());
            } catch (ExecutionException e) {
                System.out.println("Exception " + e.getMessage());
            }
            return 0;
        }).reduce(0, (x, y) -> x + y));
        exec.shutdown();
    }
}
