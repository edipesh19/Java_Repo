
public class Counter extends Thread{
	
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
