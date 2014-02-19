import java.util.Collection;
import java.util.HashSet;

// 1. If there is room to spare in the array, that is, the length of the array is greater than the
// number of elements in the collection, the spare room is filled with null values
// before the array is returned.

// 2. If the array is too small, a new array of type T and appropriate size is created.

// 3. If T is not a super type of the runtime type of every element in the collection, an ArrayStoreException is thrown.

public class CollectionToArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<String> set = new HashSet<String>();
		
		set.add("2007");set.add("2008");set.add("2009");set.add("2010");
		
		//String[] str = set.toArray(); // Exception
		Object[] obj = set.toArray();
		
		System.out.println("Size = " + obj.length);
		System.out.println("Object Type = " + obj.getClass().getName());
		System.out.println("Actual Object Type " + obj[0].getClass().getName());
		
		
		
		
		String[] strArr = new String[0];
		String[] strArr1 = set.toArray(strArr);
		
		System.out.println("ｓｔｒArr" + strArr);
		System.out.println("ｓｔｒArr1" + strArr1);
		System.out.println("strArr == strArr1 " + (strArr== strArr1)); // False
		
		
		String[] strArr2 = new String[4];
		String[] strArr3 = set.toArray(strArr2);
		System.out.println("ｓｔｒArr2 " + strArr2);
		System.out.println("ｓｔｒArr3 " + strArr3);
		System.out.println("strArr2 == strArr3 " + (strArr2== strArr3)); //True
		
		Integer[] intArr = set.toArray(new Integer[4]); // Runtime Exception
		

	}

}
