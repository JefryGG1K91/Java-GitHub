package Calculadora;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class FuncionesTestParametrizada {

	@Parameters
	public static Iterable<Object[]> datos(){
		
		return Arrays.asList(new Object[][]{
			{1,3,4},{1,4,5},{2,3,5}
			
		});
	}
	
	private int a,b,exp;
	
	public FuncionesTestParametrizada(int a,int b, int exp) {	
		 this.a=a;
		 this.b=b;
		 this.exp=exp;
	}

	@Test
	public void testAdd() {
		Funciones fx=  new Funciones();
		int rest=fx.add(a, b);
		assertEquals(exp, rest);
		
	}

}