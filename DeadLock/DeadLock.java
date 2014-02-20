
public class DeadLock {

	/**
	 * @param args
	 */
	
	String o1 = "Object1";
	String o2 = "Object2";
	
	Thread t1 = (new Thread("Thread1"){
		public void run(){
			while(true){
				synchronized(o1){
					synchronized(o2){
						System.out.println(o1+o2);
					}
				}
			}
		}
	});
	
	Thread t2 = (new Thread("Thread12"){
		public void run(){
			while(true){
				synchronized(o2){
					synchronized(o1){
						System.out.println(o2+o1);
					}
				}
			}
		}
	});
	
	public static void main(String[] args) {
		DeadLock d = new DeadLock();
		d.t1.start();
		d.t2.start();
	
	}

}
