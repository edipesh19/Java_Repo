import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import com.testing.Customer;


public class Utility {
	
	public Utility(){
		
		/*Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Run is called ...");
				
			}
		}, 0, 2000); */
		String s = "this is, an, example, for java";
		StringTokenizer st = new StringTokenizer(s,",");
		while (st.hasMoreElements()) {
			System.out.println(st.nextElement());
			
		}
		
		String ss[] = s.split(",");
		Customer cusArr[] = new Customer[10];
		for (int i = 0; i < 10; i++) {
			Customer cus = new Customer();
			if(i % 2 == 0){
				cus.setId(i + 2);
				System.out.println((i + 2));
			}else{
				cus.setId(i - 1);
				System.out.println((i - 2));
			}
			
			cus.setSal(i+20000.0);
			cusArr[i] = cus;
		}
		printArray(cusArr);
		Arrays.sort(cusArr, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				if(o1.getId() > o2.getId()){
					return -1;
				}
				if(o1.getId() < o2.getId()){
					return 1;
				}
				return 0;
			}
		});
		System.out.println("after sorting ...");
		printArray(cusArr);
		
		
		
		
		
		
		
		
	}
	
	private void printArray(Customer[] cusArr) {
		for (int i = 0; i < cusArr.length; i++) {
			System.out.println(cusArr[i].getId());
		}
		
	}
	public static void main(String[] args) {
		Utility u = new Utility();
	}

}
