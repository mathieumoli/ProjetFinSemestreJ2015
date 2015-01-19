package fr.techcode.zuul.universe.world;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents all courses.
 */
public enum CourseType {
    OOP(false, ImmutableList.of(
            "1 - Creating and Destroying Objects",
            "2 - Classes and Interfaces",
            "3 - Exceptions",
            "4 - Concurrency"
    ), ImmutableList.of(
            new QuestionExam("Are you good in Java ?", true),
            new QuestionExam("Have you learn your course ?", true)
    )),
    C(ImmutableList.of(
            "1 - Makefile",
            "2 - Pointers",
            "3 - Files",
            "4 - Modular programs"
    ), ImmutableList.of(
            new QuestionExam("Are you good in C ?", true),
            new QuestionExam("Have you learn your course ?", true)
    ));

    // Courses to listen and learn
    private List<String> courses;

    // Exam questions.
    private List<QuestionExam> questions;

    // Determine if the course is optionnal
    private boolean optionnal;

    /**
     * Create a new course.
     *
     * @param courses   courses to listen and learn.
     * @param questions questions to answer to validate course.
     */
    private CourseType(List<String> courses, List<QuestionExam> questions) {
        this(true, courses, questions);
    }

    /**
     * Create a new course.
     *
     * @param optionnal determine if the course is optionnal.
     * @param courses   courses to listen and learn.
     * @param questions questions to answer to validate course.
     */
    private CourseType(boolean optionnal, List<String> courses, List<QuestionExam> questions) {
        this.optionnal = optionnal;
        this.courses = courses;
        this.questions = questions;
    }

    /**
     * Returns true if the course is optionnal.
     *
     * @return true if the course is optionnal, otherwise false.
     */
    public boolean isOptionnal() {
        return optionnal;
    }

    /**
     * Returns a list of all courses.
     *
     * @return a list of all courses.
     */
    public List<String> getCourses() {
        return courses;
    }

    /**
     * Returns a list of questions for this course.
     *
     * @return a list of questions for this course.
     */
    public List<QuestionExam> getQuestions() {
        List<QuestionExam> questionExams = new ArrayList<>(questions.size());
        for (QuestionExam question : questions) {
            questionExams.add(question.copy());
        }
        return questionExams;
    }

}