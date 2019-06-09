package Calculadora;

public class Funciones {		

private int ans;

public Funciones(){
	ans=0;
}
public int add(int a, int b){
	ans=a+b;
	return ans;
}
public int sub(int a, int b ){
	ans=a-b;
	return ans;
}
public int add(int x){
	ans+=x;
	return ans;
}
public int sub(int y){
	ans-=y;
	return ans;
}
 public int ans(){
	 return ans;
}
public void clear(){
	ans=0;
}
public int div(int a, int b){
	if (b==0) {
		throw new ArithmeticException("Imposible realizar");
	}else {
		ans=a/b;
	}	
	return ans;
}
public void tiempoExec(){
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

