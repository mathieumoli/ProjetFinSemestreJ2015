package fr.techcode.zuul.universe.player;

import com.google.common.base.Strings;
import fr.techcode.zuul.command.CommandArguments;
import fr.techcode.zuul.command.CommandCaller;
import fr.techcode.zuul.i18n.I18n;
import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.world.CourseType;
import fr.techcode.zuul.universe.world.QuestionExam;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.universe.world.room.Room;
import fr.techcode.zuul.util.Direction;

import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This class represent a player.
 */
public class Player implements CommandCaller {

    // Name of the player
    private String name;

    // Current world
    private World world;

    // Previous room direction reference
    private Direction previous;

    // Current room reference
    private Room currentRoom;

    // Question of answer
    private List<QuestionExam> exam;

    // Current question in the exam
    private Iterator<QuestionExam> currentQuestion = null;

    // Current question
    private QuestionExam question;

    // Course type for this exam
    private CourseType courseType;

    // Memory of the player
    private Memory memory = new Memory();

    // Energy of the player
    private Energy energy = new Energy() {
        /**
         * Fired when the death occured.
         */
        @Override
        public void onDeath() {
            sendMessage(I18n.get(Message.PLAYER_DEATH, getName()));
            sendMessage(I18n.get(Message.MESSAGE_GAMEOVER));
        }
    };

    /**
     * Create a new player.
     *
     * @param name  name of the player.
     * @param world world of the beginning.
     */
    public Player(String name, World world) {
        checkArgument(!Strings.isNullOrEmpty(name), "Name of the player can't be null or empty");
        checkNotNull(world, "The world can't be null");
        this.name = name;
        this.world = world;
        currentRoom = world.getSpawnRoom();
    }

    /**
     * Gets the current world of the player.
     *
     * @return current world of the player.
     */
    public World getWorld() {
        return world;
    }

    /**
     * Gets the current room location.
     *
     * @return current room location.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sends this sender a message.
     *
     * @param message message to be displayed.
     */
    @Override
    public void sendMessage(String message, String... messages) {
        System.out.println("> " + message);
        for (String msg : messages) {
            System.out.println("> " + msg);
        }
    }

    /**
     * Gets the name of this command sender.
     *
     * @return name of the sender.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns true if the player is alive.
     *
     * @return true if the player is alive, otherwise false.
     */
    public boolean isAlive() {
        return energy.getEnergy() > 0;
    }

    /**
     * Returns true if the player is dead.
     *
     * @return true if the player is dead, otherwise false.
     */
    public boolean isDead() {
        return energy.getEnergy() == 0;
    }

    /**
     * Increase the level of energy of the player.
     *
     * @param val value to increase.
     */
    public void increaseEnergy(int val) {
        energy.increaseEnergy(val);
    }

    /**
     * Decrease the level of energy of the player.
     *
     * @param val value to decrease.
     */
    public void decreaseEnergy(int val) {
        energy.decreaseEnergy(val);
    }

    /**
     * Move the player in another room.
     *
     * @param direction direction to move.
     */
    public void move(Direction direction) {
        if (direction == null) return;
        Room room = currentRoom.getNeightbor(direction);
        if (room == null) {
            sendMessage(direction.errorMessage());
            return;
        }
        if (currentRoom.onPlayerQuit(this) && room.onPlayerJoin(this)) {
            previous = direction.getOpposite();
            currentRoom = room;
            sendMessage(direction.successMessage());
            decreaseEnergy(5);
        }
    }

    /**
     * Gets energy level of the player.
     *
     * @return energy level of the player.
     */
    public int getEnergy() {
        return energy.getEnergy();
    }

    /**
     * Leave the current room and return in the previous room.
     */
    public void leave() {
        move(previous);
    }

    /**
     * Listen a course.
     *
     * @param courseType type of the course.
     */
    public void listen(CourseType courseType) {
        if (memory.listen(courseType)) {
            sendMessage(I18n.get(Message.COURSE_LISTEN, courseType.name()));
        } else {
            sendMessage(I18n.get(Message.COURSE_LISTEN_ERROR, courseType.name()));
        }
    }

    /**
     * Learn a course.
     *
     * @param courseType type of the course.
     */
    public void learn(CourseType courseType) {
        if (memory.learn(courseType)) {
            sendMessage(I18n.get(Message.COURSE_LEARN, courseType.name()));
        } else {
            sendMessage(I18n.get(Message.COURSE_LEARN_ERROR, courseType.name()));
        }
    }

    /**
     * Grade the player.
     *
     * @param courseType type of the course.
     */
    public void grade(CourseType courseType) {
        if (memory.grade(courseType)) {
            sendMessage(I18n.get(Message.COURSE_GRADE, courseType.name()));
        } else {
            sendMessage(I18n.get(Message.COURSE_GRADE_ERROR, courseType.name()));
        }
    }

    /**
     * Returns true if the player can attempt to be grade.
     *
     * @param courseType type of the course.
     * @return true if the player can attempt to be grade.
     */
    public boolean attemptGrade(CourseType courseType) {
        return memory.attemptGrade(courseType);
    }

    /**
     * Forget a course randomly.
     */
    public void forget() {
        memory.forget();
        sendMessage(I18n.get(Message.COURSE_FORGET));
    }

    /**
     * Returns true if the player has mastered the course.
     *
     * @param courseType type of the course.
     * @return true if the player has mastered the course.
     */
    public boolean hasMastered(CourseType courseType) {
        return memory.hasMastered(courseType);
    }

    /**
     * Returns true if the player is in an currentQuestion.
     *
     * @return true if the player is in an currentQuestion.
     */
    public boolean isInExam() {
        return currentQuestion != null;
    }

    /**
     * Start an currentQuestion.
     *
     * @param courseType type of the course.
     */
    public void startExam(CourseType courseType) {
        exam = courseType.getQuestions();
        currentQuestion = exam.iterator();
        this.courseType = courseType;
        question = currentQuestion.next();
        sendMessage(question.getQuestion());
    }

    /**
     * Answer to the question of the exam.
     *
     * @param arguments answer.
     */
    public void answerExam(CommandArguments arguments) {
        boolean answer = arguments.getBool(0, false);
        // TODO : Use the non default method
        question.setResponse(answer);
        if (currentQuestion.hasNext()) {
            question = currentQuestion.next();
            sendMessage(question.getQuestion());
        } else {
            stopExam();
        }
    }

    /**
     * Stop currentQuestion.
     */
    public void stopExam() {
        if (isInExam()) {
            int valid = 0;
            for (QuestionExam question : exam) {
                if (question.isValid()) {
                    valid += 1;
                }
            }
            if (valid == exam.size()) {
                grade(courseType);
            }
            courseType = null;
            exam = null;
            currentQuestion = null;
            question = null;
        }
    }

    /**
     * Gets the player from the command caller.
     *
     * @param caller command caller.
     * @return player if the command caller is a player.
     */
    public static Player fromCaller(CommandCaller caller) {
        return (caller instanceof Player) ? (Player) caller : null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player player = (Player) obj;
        return name.equals(player.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", memory=" + memory +
                ", energy=" + energy +
                '}';
    }
}
