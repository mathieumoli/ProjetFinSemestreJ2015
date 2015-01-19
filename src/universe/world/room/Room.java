package fr.techcode.zuul.universe.world.room;

import fr.techcode.zuul.i18n.I18n;
import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.player.Player;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.universe.world.item.Item;
import fr.techcode.zuul.util.Direction;
import fr.techcode.zuul.util.Position;

import java.util.*;

/**
 * Represent a generic room.
 */
public class Room {

    // World of the room
    private World world;

    // Description of the room.
    private String description;

    // Possible rooms for a given direction
    private Map<Direction, Room> exits;

    // Location of the room in the world
    private Position location;

    // Light state of the corridor
    private boolean light;

    // Items
    protected Map<String, Item> items = new HashMap<>();

    /**
     * Create a new room considered as a corridor.
     *
     * @param world    world of the room.
     * @param location location of the room in the world.
     */
    public Room(World world, Position location) {
        this.world = world;
        this.location = location;
        this.description = Message.ROOM_CORRIDOR;
        exits = new EnumMap<>(Direction.class);
        light = new Random().nextBoolean();
    }

    /**
     * Create a new room.
     *
     * @param world       world of the room.
     * @param location    location of the room in the world.
     * @param description description of the room.
     */
    public Room(World world, Position location, String description) {
        this.world = world;
        this.location = location;
        this.description = description;
        exits = new EnumMap<>(Direction.class);
        light = new Random().nextBoolean();
    }

    /**
     * Returns the world of the room.
     *
     * @return world of the room.
     */
    public World getWorld() {
        return world;
    }

    /**
     * Gets the description of the room.
     *
     * @return description of the room.
     */
    public String getDescription() {
        return I18n.get(description);
    }

    /**
     * Returns the location of the room in the world.
     *
     * @return location of the room in the world.
     */
    public Position getLocation() {
        return location;
    }

    /**
     * Switch the light of the room.
     *
     * @return new state of the light.
     */
    public boolean switchLight() {
        light = !light;
        return light;
    }

    /**
     * Returns true if the light is on off.
     *
     * @return true if the light is on off, otherwise false.
     */
    public boolean isDark() {
        return !light;
    }

    /**
     * Gets the neightbor room for a given direction.
     *
     * @param direction direction of the move.
     * @return the neightbor room.
     */
    public Room getNeightbor(Direction direction) {
        return exits.get(direction);
    }

    /**
     * Set the neightbor room for a given direction.
     *
     * @param direction direction where the room is.
     * @param neightbor neightbor to set.
     */
    public void setNeightbor(Direction direction, Room neightbor) {
        exits.put(direction, neightbor);
    }

    /**
     * Returns true if the room is open.
     *
     * @return true if the room is open, otherwise false.
     */
    public boolean isOpen() {
        return true;
    }

    /**
     * Returns true if the room is close.
     *
     * @return true if the room is close, otherwise false.
     */
    public boolean isClose() {
        return !isOpen();
    }

    /**
     * Returns a list of all items in the room.
     *
     * @return a list of all items in the room.
     */
    public List<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    /**
     * Returns an item in the room.
     *
     * @return an item in the room.
     */
    public Item getItem(String name) {
        return items.get(name);
    }

    /**
     * Fired when a player join the room.
     *
     * @param player player involved in this event.
     * @return true if the player has join the room.
     */
    public boolean onPlayerJoin(Player player) {
        if (isClose()) {
            player.sendMessage(I18n.get(Message.ROOM_CLOSE));
            return false;
        }
        player.sendMessage(getDescription());
        return true;
    }

    /**
     * Fired when a player quit the room.
     *
     * @param player player involved in this event.
     * @return true if the player has leave the room.
     */
    public boolean onPlayerQuit(Player player) {
        return true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "location=" + location +
                ", light=" + light +
                ", items=" + items +
                ", description='" + description + '\'' +
                ", world=" + world +
                '}';
    }
}
