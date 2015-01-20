package zuul.place;

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
	public boolean canEnter(Person student) {

		if (exam.equals("noexam")) {
			return true;
		} else if (student.getEnergy() >= 50) {
			if (exam.equals("OOP")) {
				if (doAllCourses(student)) {
					return true;
				}
			} else if (exam.equals("C")) {
				return true;
			} else if (exam.equals("ALGO")) {
				return true;
			}
		}
		return false;
	}

	/***
	 *
	 * Method to know if the student did all OOP lectures and courses
	 *
	 * @param student
	 *            the student who wants to do the exam
	 * @return true if the student did all OOP lectures and courses and false if
	 *         he didn't
	 */
	public boolean doAllCourses(Student student) {
		boolean allCourses = false;
		boolean allLabs = false;
		for (int i = 0; i < Game.NB_COURSES; ++i) {
			lectureOOP.add(new LectureItem("OOP", i + 1));
			labOOP.add(new LabItem("OOP", i + 1));
		}
		allCourses = ((student.getCoursSuivi().contains(lectureOOP.get(0)))
		        && (student.getCoursSuivi().contains(lectureOOP.get(1))) && (student
		        .getCoursSuivi().contains(lectureOOP.get(2))));
		allLabs = ((student.getLabsSuivi().contains(labOOP.get(0)))
		        && (student.getLabsSuivi().contains(labOOP.get(1))) && (student
		        .getLabsSuivi().contains(labOOP.get(2))));

		return (allCourses && allLabs);
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
	public boolean enter(Person student) {
		randomizeExams();
		if (canEnter(student)) {
			if (exam.equals("noexam")) {
				System.out.println(Game.res
				        .getString("examroom.shortdescription")
				        + "\n"
				        + Game.res.getString("examroom.noexam")
				        + "\n"
				        + getExitString());
			} else {
				System.out.println(Game.res.getString("examroom.description"));
				if (exam.equals("OOP")) {
					System.out.println(Game.res
					        .getString("OOP.exam.description"));
					startExam(student);

				} else {
					System.out.println(Game.res.getString(exam
					        + ".exam.description"));
					System.out.println(getExitString());
				}
			}
		} else {
			System.out.println(Game.res.getString("examroom.cant"));
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
	public void startExam(Person student) {
		if (!exam.equals("noexam")) {

			int questionsRight = 0;
			String answer;
			Scanner scanner = new Scanner(System.in);

			for (int i = 1; i <= NB_QUESTIONS; ++i) {
				System.out.println(Game.res.getString(exam + ".exam.question"
				        + i));
				answer = scanner.nextLine();
				String rightAnswer = Game.res.getString(exam + ".exam.answer"
				        + i);
				if (answer.toUpperCase().equals(rightAnswer)) {
					++questionsRight;
				}

				System.out.println(Game.res.getString("exam.rightanswer")
				        + rightAnswer);
				System.out.println();
			}

			System.out.println(Game.res.getString("student.youhave")
			        + questionsRight + "/" + NB_QUESTIONS
			        + Game.res.getString("student.answers"));
			if (questionsRight > (NB_QUESTIONS / 2)) {
				System.out.println(Game.res.getString("game.win") + exam + ".");
				student.decrementEnergy(40);
				if (exam.equals("OOP")) {
					System.out.println(Game.res.getString("game.thankyou"));
					System.exit(1);
				}
			} else {
				System.out.println(Game.res.getString("game.lose") + exam
				        + Game.res.getString("game.lose2"));
				student.decrementEnergy(40);
				System.out.println(getExitString());
			}
		}
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
		} else if (command.getSecondWord().equals("exam")){
			this.startExam(gamer);
			if (this.getExam().equals("noexam")) {
				System.out.println(Game.res
				        .getString("examroom.shortdescription")
				        + "\n"
				        + Game.res.getString("examroom.noexam")
				        + "\n"
				        + this.getExitString());
			} else
				System.out.println(this.getLongDescription());

		}
	}
}
