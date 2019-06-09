package Calculadora;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FuncionesTest {

	public static Funciones fx;

	@org.junit.Before 
	public void beforeClass(){
		System.out.println("BeforeClass()");	
		fx= new Funciones();	
	}
	@Before
	public void Before(){
		System.out.println("Before()");	
	}
	@After
	public void After(){
		System.out.println("After()");
		fx.clear();
	}
	@Test
	public void testSuma(){
		fx= new Funciones();
		int resul=fx.add(3,2);
		int esper=5;
		assertEquals(esper, resul);
	}
	@Test
	public void testAns(){
		fx=new Funciones();
		@SuppressWarnings("unused")
		int resul=fx.add(3,2);
		int esper=5;
		assertEquals(esper, fx.ans());
	}
	@Test
	public void testDiv(){
		int resul=fx.div(15, 3);
		int esper=5;
		assertEquals(esper, resul);
	}	
	@Test(expected=ArithmeticException.class)
	public void testDivEx(){
		int resul=fx.div(15, 0);
		int esper=5;
		assertEquals(esper, resul);	
	}
	//@Test (timeout=2000)
	//public void testTimeExec(){
	//fx.tiempoExec();	
	//}
}
