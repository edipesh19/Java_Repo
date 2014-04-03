import junit.framework.TestCase;


public class CalcTestCase extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}

	public void testAdd(){
		Calc c = new Calc();
		int res = c.add(100,100);
		assertEquals(200,res);
	}
	
	public void testSub(){
		Calc c = new Calc();
		int res = c.sub(100,100);
		assertEquals(0,res);
	}
	protected void tearDown() throws Exception {};
}
