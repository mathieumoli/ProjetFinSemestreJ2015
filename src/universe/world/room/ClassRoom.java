package fr.techcode.zuul.universe.world.room;

import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.player.Player;
import fr.techcode.zuul.universe.world.CourseType;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.util.Position;

/**
 * Class room implementation.
 */
public class ClassRoom extends StudyRoom {

    /**
     * Create a new room.
     *
     * @param world      world of the room.
     * @param location   location of the room in the world.
     * @param courseType course type of the room.
     */
    public ClassRoom(World world, Position location, CourseType courseType) {
        super(world, location, Message.ROOM_CLASS, courseType);
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
            player.listen(getCourseType());
            return true;
        }
        return false;
    }

}
