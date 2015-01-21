package zuul.object;

import zuul.person.Student;

public class Phone extends ZuulObject {

	public Phone() {
		super("phone");
		
	}

	@Override
	public void useObject(Student student) {
		System.out.println("biip biip ... \n"+
	"Veuillez laisser votre message apres le bip ");		
	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub
		
	}

}
