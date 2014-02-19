
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter counterA = new Counter();
		
		Thread t1 = new Thread(counterA, "Worker1");
		System.out.println(t1);
		t1.start();
		
		int val;
		
		do{
			val = counterA.getVal();
			System.out.println("Counter Value Read by " + Thread.currentThread().getName() + " = " + val);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(val < 5);
		
		System.out.println("Exiting From " + Thread.currentThread().getName());
	}

}
