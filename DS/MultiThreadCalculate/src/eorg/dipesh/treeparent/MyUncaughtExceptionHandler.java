package eorg.dipesh.treeparent;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("MyUncaughtExceptionHandler" + t.getName() + " Throws Exception " + e.getMessage());
    }
}
