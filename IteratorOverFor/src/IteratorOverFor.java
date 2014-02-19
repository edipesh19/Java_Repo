import java.util.ArrayList;
import java.util.Collection;


public class IteratorOverFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<StringBuilder> list = new ArrayList<StringBuilder>();
		
		StringBuilder[] arr = {new StringBuilder("t’noD"), new StringBuilder("etareti"),
				new StringBuilder("!em")};
		
		for (StringBuilder str:arr){
			list.add(str);
		}
		
		System.out.println("Before " + list);
		
		for (StringBuilder str : list){
			str.reverse();
		}
		
		System.out.println("After " + list);
		
		

	}

}
