import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class TraversingOverSet {

	public static void main(String[] args) {
		Set<String> hashset = new HashSet<String>();
		
		System.out.println("HashSet");
		hashset.add("breakfast");hashset.add("Lunch");hashset.add("dinner");
		for (String s:hashset){
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("LinkedHashSet");
		
		Set<String> hashset1 = new LinkedHashSet<String>();
		
		hashset1.add("breakfast");hashset1.add("Lunch");hashset1.add("dinner");
		for (String s:hashset1){
			System.out.print(s + " ");
		}
		

	}

}
