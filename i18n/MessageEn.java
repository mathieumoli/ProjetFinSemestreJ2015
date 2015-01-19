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
package fr.techcode.zuul.i18n;

import java.util.Map;

/**
 * English mapping implementation.
 */
class MessageEn extends Message {

    /**
     * Returns a map that contains the mapping.
     *
     * @return a map that contains the mapping.
     */
    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.put(COMMAND_HELP, "Display help informations.");
        map.put(COMMAND_INTERACT, "Interact with the current room.");
        map.put(COMMAND_INTERACT_DISCOVER, "Attempt to discover some items in the room.");
        map.put(COMMAND_INTERACT_DISCOVER_FAIL, "The room is too dark.");
        map.put(COMMAND_INTERACT_LIGHT, "Change the state light of the current room.");
        map.put(COMMAND_INTERACT_LIGHT_OFF, "You have turn the light off.");
        map.put(COMMAND_INTERACT_LIGHT_ON, "You have turn the light on.");
        map.put(COMMAND_INTERACT_USE, "Use an item in the room.");
        map.put(COMMAND_INTERACT_USE_FAIL, "Item not found.");
        map.put(COMMAND_INTERACT_VIEW, "Show some informations about the environnment.");
        map.put(COMMAND_LANG, "Gets some informations about the langage.");
        map.put(COMMAND_LANG_AVAILABLE, "Show all supported languages.");
        map.put(COMMAND_LANG_SET, "Allow you to set the langage.");
        map.put(COMMAND_LEAVE, "Move to the previous room.");
        map.put(COMMAND_MOVE, "Move to another place.");
        map.put(COMMAND_PLAYER, "Display informations about you.");
        map.put(COMMAND_ROOM, "Display information about the current room.");
        map.put(COMMAND_UNKNOWN, "Unknown command ! Try 'help' to get some help.");
        map.put(COMMAND_VERSION, "Shows the version of the project.");
        map.put(COURSE_FORGET, "Vous avez oublié une leçon");
        map.put(COURSE_GRADE, "You have been graduate of @0");
        map.put(COURSE_GRADE_ERROR, "You haven't been graduate of @0");
        map.put(COURSE_LEARN, "You have learn a new lesson in @0");
        map.put(COURSE_LEARN_ERROR, "You haven't learn a new lesson in @0");
        map.put(COURSE_LISTEN, "You have listen a new lesson in @0");
        map.put(COURSE_LISTEN_ERROR, "You haven't listen a new lesson in @0");
        map.put(ITEM_BABYFOOT, "Play a party of babyfoot.");
        map.put(ITEM_BABYFOOT_INTERACT, "You have play to the babyfoot.");
        map.put(ITEM_BOOK, "This book contains all lessons of the OOP course.");
        map.put(ITEM_CHEAT, "This paper contains answer to the next exam.");
        map.put(ITEM_COFFEE, "Drink a coffee to regain energy.");
        map.put(ITEM_COFFEE_INTERACT, "You have drunk a famous coffee.");
        map.put(ITEM_COFFEE_INTERACT, "You have drunk a famous coffee.");
        map.put(MESSAGE_AVAILABLE, "Availables:");
        map.put(MESSAGE_DIRECTION_EAST_ERROR, "There is no room on the east.");
        map.put(MESSAGE_DIRECTION_EAST_SUCCESS, "You have move in the room on the east.");
        map.put(MESSAGE_DIRECTION_NORTH_ERROR, "There is no room on the north.");
        map.put(MESSAGE_DIRECTION_NORTH_SUCCESS, "You have move in the room on the north.");
        map.put(MESSAGE_DIRECTION_SOUTH_ERROR, "There is no room on the south.");
        map.put(MESSAGE_DIRECTION_SOUTH_SUCCESS, "You have move in the room on the south.");
        map.put(MESSAGE_DIRECTION_UNKNOWN, "The direction is unknown.");
        map.put(MESSAGE_DIRECTION_WEST_ERROR, "There is no room on the west.");
        map.put(MESSAGE_DIRECTION_WEST_SUCCESS, "You have move in the room on the west.");
        map.put(MESSAGE_DISCOVER, "Discover:");
        map.put(MESSAGE_GAMEOVER, "You have lose !");
        map.put(MESSAGE_HELLO, "Welcome to the world of Zull.");
        map.put(MESSAGE_HELP, "Try 'help' to get some help.");
        map.put(MESSAGE_USAGE, "Usage");
        map.put(PLAYER_DEATH, "@0 is dead of hunger !");
        map.put(ROOM_CLOSE, "The room is close.");
        map.put(ROOM_CORRIDOR, "You are now in a corridor.");
        map.put(ROOM_LAB, "You are now in a lab room.");
        map.put(ROOM_CLASS, "You are now in a class room.");
        map.put(ROOM_LIBRARY, "You are now in the library.");
        map.put(ROOM_LUNCH, "You are now in the lunchroom.");
        map.put(ROOM_DENY, "You can't leave the room now.");
        return map;
    }

}
