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
package fr.techcode.zuul.command.player;

import fr.techcode.zuul.command.CommandArguments;
import fr.techcode.zuul.command.CommandCaller;
import fr.techcode.zuul.command.Sub;
import fr.techcode.zuul.i18n.I18n;
import fr.techcode.zuul.i18n.Message;
import fr.techcode.zuul.universe.player.Player;
import fr.techcode.zuul.universe.world.item.Item;
import fr.techcode.zuul.universe.world.room.Room;
import fr.techcode.zuul.util.Direction;

/**
 * Interact command implementation.
 */
public class InteractCommand {

    /**
     * Fired when a the command is called.
     *
     * @param caller    caller for this command.
     * @param arguments arguments for this command.
     */
    @Sub(parent = "interact", minArgs = 0, maxArgs = 0, description = Message.COMMAND_INTERACT_VIEW)
    public void view(CommandCaller caller, CommandArguments arguments) {
        // Retrieve the player from the command caller.
        // Actually this action is safe because a command caller can only be a player.
        // But in the future we can change this and make something more funny.
        Player player = Player.fromCaller(caller);

        // Current room
        player.sendMessage(I18n.get(Message.MESSAGE_AVAILABLE));
        for (Direction direction : Direction.values()) {
            Room room = player.getCurrentRoom().getNeightbor(direction);
            if (room != null) {
                player.sendMessage(direction.name() + " - " + room.getDescription());
            }
        }
    }

    /**
     * Fired when a the command is called.
     *
     * @param caller    caller for this command.
     * @param arguments arguments for this command.
     */
    @Sub(parent = "interact", minArgs = 0, maxArgs = 0, description = Message.COMMAND_INTERACT_LIGHT)
    public void light(CommandCaller caller, CommandArguments arguments) {
        // Retrieve the player from the command caller.
        // Actually this action is safe because a command caller can only be a player.
        // But in the future we can change this and make something more funny.
        Player player = Player.fromCaller(caller);
        if (player.getCurrentRoom().switchLight()) {
            player.sendMessage(I18n.get(Message.COMMAND_INTERACT_LIGHT_ON));
        } else {
            player.sendMessage(I18n.get(Message.COMMAND_INTERACT_LIGHT_OFF));
        }
    }

    /**
     * Fired when a the command is called.
     *
     * @param caller    caller for this command.
     * @param arguments arguments for this command.
     */
    @Sub(parent = "interact", minArgs = 0, maxArgs = 0, description = Message.COMMAND_INTERACT_DISCOVER)
    public void discover(CommandCaller caller, CommandArguments arguments) {
        // Retrieve the player from the command caller.
        // Actually this action is safe because a command caller can only be a player.
        // But in the future we can change this and make something more funny.
        Player player = Player.fromCaller(caller);
        if (player.getCurrentRoom().isDark()) {
            player.sendMessage(I18n.get(Message.COMMAND_INTERACT_DISCOVER_FAIL));
            return;
        }
        player.sendMessage(I18n.get(Message.MESSAGE_DISCOVER));
        for (Item item : player.getCurrentRoom().getItems()) {
            player.sendMessage("\t- " + item.getName() + " - " + item.getDescription());
        }
    }

    /**
     * Fired when a the command is called.
     *
     * @param caller    caller for this command.
     * @param arguments arguments for this command.
     */
    @Sub(parent = "interact", minArgs = 1, maxArgs = 1, description = Message.COMMAND_INTERACT_USE)
    public void use(CommandCaller caller, CommandArguments arguments) {
        // Retrieve the player from the command caller.
        // Actually this action is safe because a command caller can only be a player.
        // But in the future we can change this and make something more funny.
        Player player = Player.fromCaller(caller);
        if (player.getCurrentRoom().isDark()) {
            player.sendMessage(I18n.get(Message.COMMAND_INTERACT_USE_FAIL));
        }
        Item item = player.getCurrentRoom().getItem(arguments.getFirst());
        if (item != null) {
            item.onInteract(player);
        }
    }

}
