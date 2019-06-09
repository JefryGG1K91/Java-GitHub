package Three;

public class PruebasControladas {


	private static PruebasControladas pruebasControladas;

	public static PruebasControladas getInstanciaUnica(){
		pruebasControladas= new PruebasControladas();
		return pruebasControladas;
	}


	public void iterarNumeros() {
		for (int i = 0; i <10; i++) {
			System.out.println("Hola "+i);
		}
		
	}
	
}
