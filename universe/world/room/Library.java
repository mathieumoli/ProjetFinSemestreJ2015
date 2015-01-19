package fr.techcode.zuul.universe.world.room;

import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.world.World;
import fr.techcode.zuul.universe.world.item.BookItem;
import fr.techcode.zuul.universe.world.item.CheatItem;
import fr.techcode.zuul.util.Position;

import java.util.Random;

/**
 * Library room implementation.
 */
public class Library extends Room {

    /**
     * Create a new room.
     *
     * @param world    world of the room.
     * @param location location of the room in the world.
     */
    public Library(World world, Position location) {
        super(world, location, Message.ROOM_LIBRARY);
        BookItem bookItem = new BookItem();
        CheatItem cheatItem = new CheatItem();
        items.put(bookItem.getName(), bookItem);
        items.put(cheatItem.getName(), cheatItem);
    }

    /**
     * Returns true if the room is open.
     *
     * @return true if the room is open, otherwise false.
     */
    public boolean isOpen() {
        return new Random().nextBoolean();
    }

}
