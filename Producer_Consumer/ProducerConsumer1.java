import java.util.ArrayDeque;

public class ProducerConsumer1 {
	public static void main(String[] args){
		/*final StackImpl stack = new StackImpl(10);
		
		(new Thread("Pusher"){
			public void run(){
					for(;;){
						stack.push(100);
						System.out.println("Pushed 100");
					}
			}
		}).start();
		
		(new Thread("Poper"){
			public void run(){
			for(;;){
				System.out.println("Pushed 100" + stack.pop());
			}
			}
		}).start();
		
		System.out.println("Exiting Main Thread");*/
		
		StackImpl stack = new StackImpl(10);
		StackPusher pusher = new StackPusher(stack);
		StackPoper poper = new StackPoper(stack);
		
		
		Thread t1 = new Thread(pusher, "Pusher");
		t1.setDaemon(true);
		Thread t2 = new Thread(poper, "Poper");
		t2.setDaemon(true);
		
		t2.start();
		t1.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting Main Thread");
		}
}

class StackPusher implements Runnable{
	StackImpl m_stack;
	public StackPusher(StackImpl stack){
		this.m_stack = stack;
	}
	
	public void run(){
		for (int i =1;i>0;i++){
			System.out.println("Pushing operation by " + Thread.currentThread().getName());
			m_stack.push(i);
			
		}
		
	}
}

class StackPoper implements Runnable{
	StackImpl m_stack;
	public StackPoper(StackImpl stack){
		this.m_stack = stack;
	}
	
	public void run(){
		for (int i =1;i>0;i++){
			System.out.println("Pop operation by " + Thread.currentThread().getName() + m_stack.pop());
			
		}
		
	}
}






class StackImpl{
	private ArrayDeque<Integer> stack;
	private int size;
	StackImpl(int s){
		stack = new ArrayDeque<Integer>();
		size = s;
		
	}
	public  synchronized Integer pop() {
		try {
			if (stack.isEmpty()){
					wait();
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyAll();
		return stack.pop();
	}
	public synchronized void push(Integer value) {
		try{
			if (stack.size() == size){
				wait();
			}
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		stack.push(value);
		notifyAll();
	}
	
}