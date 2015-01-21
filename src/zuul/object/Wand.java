package zuul.object;

import zuul.person.Student;

public class Wand extends ZuulObject {
	

	public Wand() {
		super("wand");
		
	}

	@Override
	public void useObject(Student student) {
		System.out.println("Wingardium Leviosa \n"+"...\n"+
				"Pourquoi il se passe rien... \n" +
				"tant pis, j ai un exam à réussir ") ;
		
	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub
		
	}

}
