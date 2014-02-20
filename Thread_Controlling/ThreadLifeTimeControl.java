
public class ThreadLifeTimeControl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ControlledThread t1 = new ControlledThread();
		t1.kickStart("Worker");
		
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.terminate();
		
		System.out.println("Exiting Main Thread");
		

	}

}


class ControlledThread implements Runnable{
	private volatile Thread currentThread;
	
	public void kickStart(String name)
	{
		if(null == currentThread){
			currentThread = new Thread(this,name);
			currentThread.start();
		}
	}
	
	public void run()
	{
		while(currentThread == Thread.currentThread())
		{
			System.out.println("In a LOOP");
		}
	}
	
	public void terminate()
	{
		currentThread = null;
	}
}