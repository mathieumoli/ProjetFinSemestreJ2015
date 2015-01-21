package zuul.object;

import zuul.person.Student;

public class Broom extends ZuulObject {
	
	public Broom() {
		super("broom");
		
	}

	int i = 0;

	@Override
	public void useObject(Student student) {
		 
			System.out.println("I believe I can fly \n"
					+ "I believe I can touch the sky \n"
					+ "I think about it every night and day \n"
					+ "Spread my wings and fly away \n "
					+ "I believe I can soar \n "
					+ "I see me running through that open door \n "
					+ "I believe I can fly \n " + "I believe I can fly ");
		
		

	}

	@Override
	public void addStuff() {
		// TODO Auto-generated method stub

	}

}
