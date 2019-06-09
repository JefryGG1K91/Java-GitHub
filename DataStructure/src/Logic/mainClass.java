package Logic;
import java.util.Scanner;

import Entity.person;


public class mainClass {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		person pp=new person();
		System.out.println("Your name is?");
		pp.setName(scan.nextLine());
		System.out.println("Your last name is?");
		pp.setLastName(scan.nextLine());
		System.out.println("Your birthday is?");
		pp.setBirthDay(scan.nextLine());
		
		logicPerson lp=new logicPerson();
		lp.addValue(pp);
		
		for (int i = 0; i < lp.addValue(pp).size(); i++) {
			System.out.println("FirstName: "+lp.addValue(pp).get(i).getName()+"\n LastName: "+lp.addValue(pp).get(i).getLastName()+"\n BirthDay: "+lp.addValue(pp).get(i).getBirthDay());
		}
		
		System.out.println("congratulation, are you already sing in");

	}

}
