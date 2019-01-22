import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

class JUnitIntroduction {

	@BeforeClass
	static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class.....");
	}

	@After
	static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after class.....");
	}

	@Before
	void setUp() throws Exception {
		System.out.println("Executed before .....");
	}

	@After
	void tearDown() throws Exception {
		System.out.println("Executed after.....");
	}

	@Test
	void test1() {
		System.out.println("Executed test 1.....");
	}
	
	@Test
	void test2() {
		System.out.println("Executed test 2.....");
	}

}
