package fr.techcode.zuul.universe.world.room;

import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.player.Player;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.universe.world.item.BabyfootItem;
import fr.techcode.zuul.universe.world.item.CoffeeItem;
import fr.techcode.zuul.util.Position;

import java.util.Random;

/**
 * Lunchroom implementation.
 */
public class Lunchroom extends Room {

    /**
     * Create a new room considered as a corridor.
     *
     * @param world    world of the room.
     * @param location location of the room in the world.
     */
    public Lunchroom(World world, Position location) {
        super(world, location, Message.ROOM_LUNCH);
        CoffeeItem coffeeItem = new CoffeeItem();
        items.put(coffeeItem.getName(), coffeeItem);
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
            if (new Random().nextInt(2) == 0) {
                new BabyfootItem().onInteract(player);
            }
        }
        return true;
    }

}
