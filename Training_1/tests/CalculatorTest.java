import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class CalculatorTest {

	Calculator calc = null;
	
	@BeforeClass
	public static void beforecls(){
		System.out.println("before class");
	}
	@AfterClass
	public static void aftercls(){
		System.out.println("after class");
	}
	@Before
	public void sta(){
		System.out.println("before");
		calc = new Calculator();
	}
	@After
	public void fini(){
		calc = null;
		System.out.println("after");

	}
	
	@Test
	public void testAdd(){
		System.out.println("test add");

		double res = calc.add(100,100);
		Assert.assertEquals(200,res,0);
	}
	@Test
	public void testAdd1(){
		System.out.println("test add1");

		double res = calc.add(10,100);
		Assert.assertEquals(110,res,0);
	}
	@Test
	public void testSub(){
		System.out.println("test sub");
		double res = calc.sub(100,100);
		Assert.assertEquals(0,res,0);
	}
}
