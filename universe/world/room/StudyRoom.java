package fr.techcode.zuul.universe.world.room;


import fr.techcode.zuul.i18n.I18n;
import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.player.Player;
import fr.techcode.zuul.universe.world.CourseType;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.util.Position;
import fr.techcode.zuul.util.Timer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Represent a room where the player can study.
 */
public class StudyRoom extends Room {

    // Timers
    private Map<Player, Timer> timers = new HashMap<>();

    // Course in the room
    private CourseType courseType;

    /**
     * Create a new room.
     *
     * @param world       world of the room.
     * @param location    location of the room in the world.
     * @param description description of the room.
     * @param courseType  course type of the room.
     */
    public StudyRoom(World world, Position location, String description, CourseType courseType) {
        super(world, location, description);
        this.courseType = courseType;
    }

    /**
     * Gets the course that can be learn in the room.
     *
     * @return course that can be learn in the room.
     */
    public CourseType getCourseType() {
        return courseType;
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
            if (!courseType.isOptionnal()) {
                timers.put(player, new Timer(10, TimeUnit.SECONDS));
            }
            return true;
        }
        return false;
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
        if (!courseType.isOptionnal()) {
            context &= timers.get(player).isFinished();
            if (context) {
                timers.remove(player);
            } else {
                player.sendMessage(I18n.get(Message.ROOM_DENY));
            }
        }
        return context;
    }

}
