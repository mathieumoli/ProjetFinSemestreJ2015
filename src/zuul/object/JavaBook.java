package zuul.object;

import java.util.ArrayList;

import zuul.Game;
import zuul.course.LectureItem;
import zuul.person.Student;

public class JavaBook extends ZuulObject {

	private ArrayList<LectureItem> pages;
	
	public JavaBook() {
		super("book");
		pages = new ArrayList<LectureItem>();
		
		pages.add(new LectureItem("OOP", 1, "oop.lecture1"));
		pages.add(new LectureItem("OOP", 2, "oop.lecture2"));
		pages.add(new LectureItem("OOP", 3, "oop.lecture3"));
	}

	@Override
	public void useObject(Student student) {
		int sizeBook = this.pages.size();
		for (int i = 0; i < sizeBook; i++) {
			if (!student.alreadyListenedLecture(this.pages.get(i))) {
				student.addItem(this.pages.get(i));
				System.out.println(Game.res.getString(this.pages.get(i)
				        .getBundleKey()) + "\n");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		student.decrementEnergy(40);
	}

}
