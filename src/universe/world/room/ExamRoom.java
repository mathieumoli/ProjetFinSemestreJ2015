package fr.techcode.zuul.universe.world.room;

import fr.techcode.zuul.i18n.I18n;
import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.player.Player;
import fr.techcode.zuul.universe.world.CourseType;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.util.Position;

/**
 * Class room implementation.
 */
public class ExamRoom extends StudyRoom {

    /**
     * Create a new room.
     *
     * @param world       world of the room.
     * @param location    location of the room in the world.
     * @param description description of the room.
     * @param courseType  course type of the room.
     */
    public ExamRoom(World world, Position location, String description, CourseType courseType) {
        super(world, location, description, courseType);
    }

    /**
     * Fired when a player join the room.
     *
     * @param player player involved in this event.
     * @return true if the player has join the room.
     */
    @Override
    public boolean onPlayerJoin(Player player) {
        if (super.onPlayerJoin(player)) {
            if (player.getEnergy() < 50 || !player.attemptGrade(getCourseType())) {
                player.sendMessage(I18n.get(Message.COURSE_GRADE_ERROR));
                return false;
            } else {
                player.startExam(getCourseType());
            }
        }
        return true;
    }

    /**
     * Fired when a player quit the room.
     *
     * @param player player involved in this event.
     * @return true if the player has leave the room.
     */
    @Override
    public boolean onPlayerQuit(Player player) {
        boolean context = super.onPlayerQuit(player);
        if (context) {
            player.grade(getCourseType());
            player.decreaseEnergy(20);
        }
        return context;
    }

}
