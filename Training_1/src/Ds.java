import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;

import com.testing.Customer;


public class Ds {
	
	public static void main(String[] args) {
		
		Vector v = new Vector();
		
		v.add(10);
		v.add("one");
		v.add(12.82);
		
		double d = (Double)v.get(2);
		
		Vector<Customer> v1 = new Vector<Customer>();
		v1.add(new Customer());
		Customer cus = v1.get(0);
		
		System.out.println(v);
		
		Hashtable<Integer, String> tab = new Hashtable<Integer, String>();
		tab.put(10, "ten");
		tab.put(11, "eleven");
		tab.put(12, "twelve");
		//tab.put(15, null);
		
		System.out.println(tab);
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("C:\\Users\\gajg\\workspace\\18032014\\test.properties"));
			System.out.println(prop);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"1111");
		map.put(2,"2222");
		map.put(4,"4444");

		map.put(5,null);
		String dss = map.put(1,"111111111111111111");
		
		System.out.println(dss);
		
		
		Set<Entry<Integer,String>> entry = map.entrySet();
		
		System.out.println(entry.size());
		
		
		Set<Integer> keys =map.keySet();
		Collection<String> coll = map.values();
		
		Iterator<Integer> keyIter = keys.iterator();
		Iterator<String> valIter = coll.iterator();
		
		while (valIter.hasNext()) {
			String val = (String) valIter.next();
			System.out.println(keyIter.next()+" == "+val);
		}
	}

}









