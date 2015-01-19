/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.techcode.zuul.universe.world;

/**
 * This is a basic implementation of an exam.
 */
public class QuestionExam {

    // Question of the exam
    private String question;

    // Answer of the question
    private boolean answer;

    // Response of the user
    private boolean response;

    /**
     * Create a new question exam.
     *
     * @param question question to answer.
     * @param answer   answer of the question.
     */
    public QuestionExam(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Returns the question of the exam.
     *
     * @return question of the exam.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set the user response.
     *
     * @param response response of the user.
     */
    public void setResponse(boolean response) {
        this.response = response;
    }

    /**
     * Returns true if the question exam is valid.
     *
     * @return true if the question exam is valid.
     */
    public boolean isValid() {
        return answer == response;
    }

    /**
     * Returns a copy of this object.
     *
     * @return a copy of this object.
     */
    public QuestionExam copy() {
        return new QuestionExam(question, answer);
    }

}
