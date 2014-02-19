
public class Counter implements Runnable {
	private int counter;
	
	public Counter(){
		counter = 0;
	}
	
	int getVal(){
		return counter;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(counter < 5){
			System.out.println("Thread = " + Thread.currentThread().getName() + "Counter Value = "+ counter++);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Exit From Thread " + Thread.currentThread().getName());
	}
}
