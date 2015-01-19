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
import fr.techcode.zuul.command.CommandHandler;
import fr.techcode.zuul.universe.player.Player;

/**
 * Leave command implementation.
 */
public class LeaveCommand implements CommandHandler {

    /**
     * Fired when a the command is called.
     *
     * @param caller    caller for this command.
     * @param arguments arguments for this command.
     */
    @Override
    public void onCommand(CommandCaller caller, CommandArguments arguments) {
        // Retrieve the player from the command caller.
        // Actually this action is safe because a command caller can only be a player.
        // But in the future we can change this and make something more funny.
        Player player = Player.fromCaller(caller);

        // Attempt to move
        player.leave();
    }

}
