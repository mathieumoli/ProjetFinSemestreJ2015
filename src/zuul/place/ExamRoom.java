package zuul.place;

import zuul.Display;
import zuul.Game;
import zuul.commands.Command;
import zuul.course.LabItem;
import zuul.course.LectureItem;
import zuul.person.Person;
import zuul.person.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lucas Martinez
 * @version 2014.11.30
 * 
 *          Class to create an ExamRoom
 */
public class ExamRoom extends Room {
	public static final int NB_QUESTIONS = 3;
	private String exam;
	private List<LectureItem> lectureOOP = new ArrayList<LectureItem>();
	private List<LabItem> labOOP = new ArrayList<LabItem>();

	/***
	 * 
	 * Constructor to create an ExamRoom
	 * 
	 * @param description
	 *            the description of the examroom
	 * 
	 ***/
	public ExamRoom(String description) {
		super(description);
	}

	/**
	 * This function determines if the student can enter the examroom or not the
	 * student can't enter if he doesn't have enough energy (50) and if he
	 * didn't attend the oop lectures and the oop labs for an OOP exam
	 *
	 * @param student
	 *            the student who wants to do the exam
	 * @return true if the student can enter and false if he can't
	 */
	@Override
	public boolean canEnter(Student personne) {
		Student student = (Student) personne;
		if (exam.equals("noexam")) {
			return true;
		} else if (student.getWallet().canPassExam()) {
			if (student.getEnergy() >= 50) {
				if (exam.equals("OOP")) {

					return true;
				}
			} else {
				if (exam.equals("C")) {
					return true;
				} else if (exam.equals("ALGO")) {
					return true;
				}
			}
		}
		return false;
	}

	/***
	 * 
	 * Method to enter in this examroom
	 * 
	 * @param student
	 *            the student who wants to go in
	 * @return true if he can go in and false if he can't
	 * 
	 ***/
	@Override
	public boolean enter(Student student) {
		randomizeExams();
		if (canEnter(student)) {
			if (exam.equals("noexam")) {
				Display.displayln("examroom.shortdescription");
				Display.displayln("examroom.noexam");
				Display.displayln(getExitString());
			} else {
				Display.displayln("examroom.description");
				if (exam.equals("OOP")) {
					Display.displayln("OOP.exam.description");
					startExam(student);

				} else {
					Display.displayln(exam + ".exam.description");
					Display.displayln(getExitString());
				}
			}
		} else {
			Display.displayln("examroom.cant");
			return false;
		}
		return true;
	}

	/***
	 * 
	 * Method to randomize the exam in the examroom (it will have no exam too)
	 * 
	 ***/
	private void randomizeExams() {
		int rand = (int) (Math.random() * Game.NB_COURSES);
		exam = Game.COURSES[rand];

		int noExam = (int) (Math.random() * 9);
		if (noExam > 3) {
			exam = "noexam";
		}

	}

	/***
	 * 
	 * Method to start an exam
	 * 
	 * @param student
	 *            the student who passes it
	 * 
	 ***/
	public void startExam(Person personne) {
		Student student = (Student) personne;
		if (!exam.equals("noexam")) {

			int questionsRight = 0;
			String answer;
			Scanner scanner = new Scanner(System.in);

			for (int i = 1; i <= NB_QUESTIONS; ++i) {
				Display.displayln(exam + ".exam.question" + i);
				answer = scanner.nextLine();
				String rightAnswer = Game.res.getString(exam + ".exam.answer"
				        + i);
				if (answer.toUpperCase().equals(rightAnswer)) {
					++questionsRight;
				}

				Display.display("exam.rightanswer");
				Display.displayln(rightAnswer);

			}

			Display.displayln(Game.res.getString("student.youhave")
			        + questionsRight + "/" + NB_QUESTIONS
			        + Game.res.getString("student.answers"));
			if (questionsRight > (NB_QUESTIONS / 2)) {
				System.out.println(Game.res.getString("game.win") + exam + ".");
				student.decrementEnergy(40);
				if (exam.equals("OOP")) {
					Display.displayln("game.thankyou");
					System.exit(1);
				}
			} else {
				Display.displayln(Game.res.getString("game.lose") + exam
				        + Game.res.getString("game.lose2"));
				student.decrementEnergy(40);
				Display.displayln(getExitString());
			}
			scanner.close();
		} else {
			Display.displayln("examroom.shortdescription");
			Display.displayln("examroom.noexam");
			Display.displayln(getExitString());
		}
		Display.displayln(this.getLongDescription());

	}

	/**
	 * @return the exam
	 */
	public String getExam() {
		return exam;
	}

	/**
	 * @param exam
	 *            the exam to set
	 */
	public void setExam(String exam) {
		this.exam = exam;
	}

	/**
	 * Try to start the exam, if it's incomplete, display an error message
	 * 
	 * @param command
	 *            The command to be processed.
	 */
	@Override
	public void wantStart(Command command, Student gamer) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(Game.res.getString("game.start"));
		} else if (command.getSecondWord().equals("exam")) {
			this.startExam(gamer);
			if (this.getExam().equals("noexam")) {
				Display.displayln("examroom.shortdescription");
				Display.displayln("examroom.noexam");
				Display.displayln(getExitString());
			} else
				Display.displayln(this.getLongDescription());

		}
	}
}
