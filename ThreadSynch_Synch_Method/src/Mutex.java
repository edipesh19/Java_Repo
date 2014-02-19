
class StackImpl { // (1)
	private Object[] stackArray;
	private int topOfStack;
	public StackImpl(int capacity) {
		stackArray = new Object[capacity];
		topOfStack = -1;
	}
	//public boolean push(Object element) { // (2a) non-synchronized
		public synchronized boolean push(Object element) { // (2b) synchronized
		if (isFull()) return false;
		++topOfStack;
		try { Thread.sleep(1000); } catch (Exception e) { } // (3) Sleep a little.
		stackArray[topOfStack] = element;
		return true;
	}
	//public Object pop() { // (4a) non-synchronized
		public synchronized Object pop() { // (4b) synchronized
		if (isEmpty()) return null;
		Object obj = stackArray[topOfStack];
		stackArray[topOfStack] = null;
		try { Thread.sleep(1000); } catch (Exception e) { } // (5) Sleep a little.
		topOfStack--;
		return obj;
	}
	public boolean isEmpty() { return topOfStack < 0; }
	public boolean isFull() { return topOfStack >= stackArray.length - 1; }
}

public class Mutex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final StackImpl stack = new StackImpl(20);
		
		(new Thread("Pusher"){
			public void run(){
				for(;;){
					System.out.println("Pushing =" + stack.push(2008));
				}
			}
		}).start();
		
		(new Thread("Poper"){
			public void run(){
				for(;;){
					System.out.println("Poping Element = "+stack.pop());
				}
			}
		}).start();

	}

}
