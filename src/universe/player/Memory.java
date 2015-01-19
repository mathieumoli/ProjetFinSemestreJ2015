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
package universe.player;

import fr.techcode.zuul.universe.world.CourseType;

import java.util.*;

/**
 * Player memory implementation.
 */
class Memory {

    // Listened and learned courses
    private Map<CourseType, Integer> listened = new HashMap<>();
    private Map<CourseType, Integer> learned = new HashMap<>();

    // Course where the player is master
    private Set<CourseType> masters = new HashSet<>();

    /**
     * Create a new memory.
     */
    public Memory() {
        for (CourseType courseType : CourseType.values()) {
            listened.put(courseType, 0);
            learned.put(courseType, 0);
        }
    }

    /**
     * Listen a course.
     *
     * @param courseType type of the course.
     * @return if the course has been listen.
     */
    public boolean listen(CourseType courseType) {
        // Boundary effect
        List<String> courses = courseType.getCourses();
        if (listened.get(courseType) == courses.size()) return false;

        // Listen a new course
        if (Objects.equals(learned.get(courseType), listened.get(courseType))) {
            listened.put(courseType, listened.get(courseType) + 1);
            return true;
        }
        return false;
    }

    /**
     * Learn a course.
     *
     * @param courseType type of the course.
     * @return if the course has been learn.
     */
    public boolean learn(CourseType courseType) {
        // Boundary effect
        List<String> courses = courseType.getCourses();
        if (learned.get(courseType) == courses.size()) return false;

        // Listen a new course
        if (learned.get(courseType) < listened.get(courseType)) {
            learned.put(courseType, learned.get(courseType) + 1);
            return true;
        }
        return false;
    }

    /**
     * Grade the player.
     *
     * @param courseType type of the course.
     */
    public boolean grade(CourseType courseType) {
        if (attemptGrade(courseType)) {
            masters.add(courseType);
            return true;
        }
        return false;
    }

    /**
     * Returns true if the player can attempt to be grade.
     *
     * @param courseType type of the course.
     * @return true if the player can attempt to be grade.
     */
    public boolean attemptGrade(CourseType courseType) {
        List<String> courses = courseType.getCourses();
        return listened.get(courseType) == courses.size() && learned.get(courseType) == courses.size();
    }

    /**
     * Forget a course randomly.
     */
    public void forget() {
        CourseType courseType = CourseType.values()[new Random().nextInt(CourseType.values().length)];
        listened.put(courseType, listened.get(courseType) - 1);
        learned.put(courseType, learned.get(courseType) - 1);
    }

    /**
     * Returns true if the player has mastered the course.
     *
     * @param courseType type of the course.
     * @return true if the player has mastered the course.
     */
    public boolean hasMastered(CourseType courseType) {
        return masters.contains(courseType);
    }

    @Override
    public String toString() {
        return "Memory{" +
                "listened=" + listened +
                ", learned=" + learned +
                ", masters=" + masters +
                '}';
    }
}
