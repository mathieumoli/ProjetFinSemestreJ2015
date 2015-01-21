package zuul.object;

import zuul.person.Student;

public class Pc extends ZuulObject {

	@Override
	public void useObject(Student student) {
		System.out.println("ça faisait longtemps que je me suis pas connecté\n"+
				"...\n"+
				"Facebook.com \n"+
				"Connexion échouée...\n");
		
	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub
		
	}

}
