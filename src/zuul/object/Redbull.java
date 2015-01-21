package zuul.object;

import zuul.person.Student;

public class Redbull extends PayingObject {
	
	public Redbull(){
		super("redbull",2);
	}
	
	@Override
	public void useObject(Student student) {
		//TODO internationalisation
		System.out.println("le redbull c'est trop bon") ;
		student.incrementEnergy(40);
		
	}

	@Override
	public void addStuff() {
		//nothing to do
		
	}
	
}
