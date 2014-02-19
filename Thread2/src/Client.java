
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Thread = " + Thread.currentThread().getName());
		
		Counter counterA = new Counter("CounterA");
		Counter counterB = new Counter("CounterB");

		System.out.println("Exiting From Thread " + Thread.currentThread().getName());
	}

}
