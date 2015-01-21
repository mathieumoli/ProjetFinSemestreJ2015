package zuul.intl;

import java.util.ListResourceBundle;

/**
 * @author Lucas Martinez
 * @version 2014.11.30
 * 
 *          Zuul_en_US is a class that manages resources strings for the game
 *          when the user want an English game
 */
public class Zuul_en_US extends ListResourceBundle {
	static final Object[][] contents = {

			{
					"lunchroom.description",
					"You are in the lunchroom. Why don't you take some of this Mocoffee drink,\n all natural coffee beans from the upper slopes of Mount Nicaragua,\n no artificial sweeteners! It will give you a few energy points.\n Type \"take coffee\" to drink a coffee" },
			{ "lectureroom.description1",
					"You are in a classroom.\nYou can attend the lecture of " },
			{ "lectureroom.description2",
					"Type \"attend lecture\" if you want \n" },
			{ "lectureroom.shortdescription", "You are in a classroom.\n" },
			{ "labroom.description1",
					"You are in the computing lab.\nYou can attend the lab of " },
			{ "labroom.description2", "Type \"attend lab\" if you want \n" },
			{ "labroom.shortdescription", "You are in the computing lab.\n" },

			{ "corridor1.description", "You are in the first corridor" },
			{ "corridor2.description", "You are in the second corridor" },
			{ "corridor3.description", "You are in the third corridor" },
			{ "corridor4.description", "You are in the fourth corridor" },
			{ "corridor.tablet",
					"You find a tablet in the corridor. To turn it on, type \"turn tablet\"" },
			{ "corridor.notablet", "Which tablet?" },
			{
					"corridor.cheatsheet",
					"A piece of paper exceeds behind the printer...To check it, type \"search printer \"" },
			{ "corridor.nocheatsheet", "Which printer ?" },
			{
					"library.description",
					"You are in the library.In the library you can see the OOP2 book. This book contains all lecture you can learn about OOP2. \nIf you want to read it, just type \"read book\" \nand if you want to take it just type \"take book\" \nyou will read it when you want just when you will type \"read book\"" },
			{ "library.takebook", "You take the book and put it in your bag." },
			{ "examroom.description",
					"You are in the exam room. To answer, please type TRUE or FALSE." },
			{ "examroom.shortdescription", "You are in the exam room." },
			{ "examroom.noexam",
					"There aren't scheduled exam in this room. Come back later !" },
			{
					"corridor.dark",
					"This corridor is very dark, you could switch the lights on to see clearly the room.\n Type \"lights on\" to switch the lights on !" },
			{
					"library.closed",
					"The door is closed. The library is closed 7 out of 10 times... Come back later !" },
			{ "lunchroom.coffee1",
					"I had add a thermo of coffee in my backpack !" },
			{ "lunchroom.coffee2", "Thank you Mocoffee !" },

			{ "oop.lecture", "You need to know...blabla" },
			{ "oop.lecture1",
					"...developers aim for high cohesion and loose coupling..." },
			{ "oop.lecture2", "...interfaces don't need a constructor..." },
			{ "oop.lecture3",
					"...a sub-class must have a 'super' call in its constructor..." },
			{ "oop.lectureend", "See you next time !" },

			{ "c.lecture1",
					"... C programming isn't an oriented object programming..." },
			{ "c.lecture2",
					"...a declaration of a table is done like that : int tab[]..." },
			{ "c.lecture3",
					"...a declaration of a pointer is done like that : int *p..." },

			{ "algo.lecture1",
					"...we use the Gauss' hub to get an upper triangular matrix..." },
			{
					"algo.lecture2",
					"...Using the divided differences is the most simple method to get the nearest polynom of a function..." },
			{
					"algo.lecture3",
					"...If the determinant of a matrix is different of 0 so the matrix has an inverse matrix..." },

			{ "C.exam.description",
					"An exam of C just started, to do it, type \"start exam\"." },
			{ "C.exam.question1",
					"A declaration of a table is done with parenthesis ()..." },
			{ "C.exam.question2", "A pointer is declared with a *..." },
			{ "C.exam.question3",
					"C isn't a Object Oriented Programming language..." },
			{ "C.exam.answer1", "FALSE" },
			{ "C.exam.answer2", "TRUE" },
			{ "C.exam.answer3", "TRUE" },

			{ "ALGO.exam.description",
					"An exam of Algo just started, to do it, type \"start exam\"." },
			{
					"ALGO.exam.question1",
					"The determinant of a matrix must be different than 0 so the matrix can have an inverse matrix..." },
			{ "ALGO.exam.question2",
					"The Gauss' hub is used to get a diagonal matrix..." },
			{
					"ALGO.exam.question3",
					"The divided differences is the best method to get the best polynom of interpolation..." },
			{ "ALGO.exam.answer1", "TRUE" },
			{ "ALGO.exam.answer2", "FALSE" },
			{ "ALGO.exam.answer3", "TRUE" },
			{"exam.rightanswer", "The answer is : "},

			{ "OOP.exam.description",
					"You are going to take an exam of OOP, please answer with TRUE or FALSE." },
			{ "OOP.exam.question1", "Does an interface need a constructor ?" },
			{ "OOP.exam.question2",
					"We aim for low cohesion and high coupling. Is it true ?" },
			{ "OOP.exam.question3",
					"Subclass constructors must always contain a 'super' call. Is it true ?" },
			{ "OOP.exam.answer1", "FALSE" },
			{ "OOP.exam.answer2", "FALSE" },
			{ "OOP.exam.answer3", "TRUE" },
			{ "oop.exam.rightanswer", "The right answer is : " },

			{ "game.welcome", "Welcome to the World of Zuul!" },
			{ "game.boring",
					"World of Zuul is a new, incredibly (slightly less) boring adventure game." },
			{ "game.help", "Type 'help' if you need help." },
			{ "game.idontknow", "I don't know what you mean..." },
			{ "game.use", "Use what ? tablet maybe ?" },
			{ "game.start", "Start what ?" },
			{ "game.attend", "Attend what ? lab ? lecture ?" },
			{ "game.help2",
					"You are a student and you need to pass the final POO exam." },
			{
					"game.help3",
					"In order to do that, you need to listen lecture, do lab works and pass the exam." },
			{ "game.help4", "Your command words are:" },
			{ "game.where", "Go where?" },
			{ "game.take",
					"take what? A coffee or a book ? Type: take coffee or take book" },
			{ "game.nodoor", "There is no door!" },
			{ "game.quitwhat", "Quit what?" },
			{ "game.exits", "Exits:" },
			{ "game.thankyou", "Thank you for playing.  Good bye." },
			{ "game.askname", "What's your name ?" },
			{ "game.welcomename1", "Welcome " },
			{ "game.welcomename2",
					" ! But I think that this name isn't really for you...I'll call you " },
			{ "game.welcomename3", " the badass !" },
			{
					"game.win",
					"Congratulations ! You passed the final OOP exam and therefore you finished the game." },
			{ "game.lose", "Sorry, you didn't pass the final exam of " },
			{ "game.lose2", " and you need to pass it again..." },

			{ "student.youhave", "You have " },
			{ "student.answers", " right answers." },
			{
					"student.energy0",
					"You don't have any energy left ! You fall asleep right there... Jojo la menace sees you and decides to expel you...Be careful next time." },
			{ "student.energy.part1", "Energy of " },
			{ "student.energy.part2", " is " },
			{ "student.addLab.part1", "  participated in this lab of " },
			{ "student.add.part2", " number " },
			{ "student.addLecture.part1", " participated in this course of " },
			{ "student.removeLecture1", "You forget the lecture of " },
			{ "student.removeLecture2", " number " },
			{ "student.removeLab1", "You forget the lab of " },
			{ "student.removeLab2", " number " },

			{ "lectureroom.attendlecture.part1", "Lecture of " },
			{ "lectureroom.attendlecture.part4",
					"Thank you for your attention you can do the lab now !" },
			{ "room.attend.part2", " number " },
			{ "room.attend.part3", " is going to begin" },
			{ "labroom.attendlab.part1", "Lab of " },
			{ "labroom.attendlab.part4", "Thank you for your attention. " },
			{
					"labroom.noattend1",
					"The professor doesn't want you to attend this lab because you haven't assisted to the lecture of " },
			{ "labroom.noattend2", " number " },
			{
					"lunchroom.babyFoot",
					"You're in the lunchroom. Salah and Fanfan la tulipe say to you : \"It's babyfoot time !\" You can't refuse." },
			{ "examroom.cant",
					"You can't pass the final exam of OOP in these conditions..." },

			{ "tablet.lecture",
					"You find a lecture on the tablet. Why do you think about learning it ?" },
			{
					"tablet.appli",
					"Oh no! You have seen \"Candy Crush - Forget your lectures and play with me\" on the tablet ... and now you launch the application !" },
			{
					"tablet.zuul",
					"Oh yes! You have seen \"World of Zuul\" on the tablet ... and now you launch the application !" },
			{
					"tablet.on",
					"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$__$$$$$$$$$$$$$$_$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$_______________$$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$___________________$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$____$$$_________$$$____$$$$$$$$$$$$$\n$$$$$$$$$$$$$_____$$$_________$$$_____$$$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n$$$$_____$$$____________________________$$$____$$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$______$$____________________________$$______$$\n$$$$_____$$$____________________________$$______$$\n$$$$$___$$$$____________________________$$$___$$$$\n$$$$$$$$$$$$____________________________$$$$$$$$$$\n$$$$$$$$$$$$____________________________$$$$$$$$$$\n$$$$$$$$$$$$___________________________$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$______$$$$$$_____$$$$$$$$$$$$$$$$\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\nThe Android Tablet is ON !" },

			{ "room.nothing",
					"Sorry but there aren't scheduled course in this room. Come back later !" },
			{ "cheatsheet.description1",
					"You just found a paper, and there is something written on it..." },
			{ "cheatsheet.description2", "Answers to the OOP exam : " }

	};

	/***
	 * @return an array in which each item is a pair of objects in an Object
	 *         array. The first element of each pair is the key, which must be a
	 *         String, and the second element is the string associated with that
	 *         key.
	 */
	@Override
	public Object[][] getContents() {
		return contents;
	}
}
