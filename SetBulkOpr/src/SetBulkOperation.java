import java.util.HashSet;
import java.util.Set;


public class SetBulkOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Character> encounter = new HashSet<Character>();
		
		for (String arg:args){
			Set<Character> character = new HashSet<Character>();
			
			int len = arg.length();
			
			for (int i = 0; i < len; i++)
				character.add(arg.charAt(i));
			
			Set<Character> common = new HashSet<Character>(encounter);
			common.retainAll(character);
			boolean disjoin = common.size() == 0;
			
			if (disjoin){
				System.out.println(encounter + " and " + encounter + " are disjoined");
			}
			else{
				boolean subSet = encounter.containsAll(character);
				boolean superSet = character.containsAll(encounter);
				if (subSet && superSet){
					System.out.println(encounter + " and "+ character + " are equivalent");
				}
				if (subSet){
					System.out.println(character + " is sub set of " + encounter);
				}
				if (superSet){
					System.out.println(character + " is super set of " + encounter);
				}
				
			}
			
			encounter.addAll(character);
			
			
		}
		

	}

}
