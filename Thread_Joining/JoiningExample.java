import java.io.IOException;


/*
 * Main Method will wait for counterA and counterB Method.
 */
public class JoiningExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter counterA = new Counter("CounterA");
		Counter counterB = new Counter("CounterB");
		
			try {
				counterA.join();
				counterB.join();
				
				if(!counterA.isAlive()){
					System.out.println("counterA id dead");
				}
				if(!counterB.isAlive()){
					System.out.println("counterB id dead");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Exiting Main Thread");
		

	}

}
class Counter extends Thread{
	
	private int counter;
	
	public Counter(String _name){
		super(_name);
		counter = 0;
		System.out.println(this);
		setDaemon(true);
		start();
	}
	
	public int getValue(){
		return counter;
	}
	
	public void run()
	{
		while(counter < 5){
			System.out.println("Thread = " + getName() +" : " + counter++);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
