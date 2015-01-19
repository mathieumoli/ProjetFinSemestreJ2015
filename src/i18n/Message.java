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

import com.google.common.collect.ImmutableSortedSet;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * A mapping of all known messages.
 */
public abstract class Message {

    // Special
    public static final String EMPTY = "";

    // Commands
    public static final String COMMAND_HELP = "command.help";
    public static final String COMMAND_INTERACT = "command.interact";
    public static final String COMMAND_INTERACT_DISCOVER = "command.interact.discover";
    public static final String COMMAND_INTERACT_DISCOVER_FAIL = "command.interact.discover.fail";
    public static final String COMMAND_INTERACT_LIGHT = "command.interact.light";
    public static final String COMMAND_INTERACT_LIGHT_OFF = "command.interact.light.off";
    public static final String COMMAND_INTERACT_LIGHT_ON = "command.interact.light.on";
    public static final String COMMAND_INTERACT_USE = "command.interact.use";
    public static final String COMMAND_INTERACT_USE_FAIL = "command.interact.use.fail";
    public static final String COMMAND_INTERACT_VIEW = "command.interact.view";
    public static final String COMMAND_LANG = "command.lang";
    public static final String COMMAND_LANG_AVAILABLE = "command.lang.available";
    public static final String COMMAND_LANG_SET = "command.lang.set";
    public static final String COMMAND_LANG_SET_EN = "command.lang.set.en";
    public static final String COMMAND_LANG_SET_EN_CHANGE = "command.lang.set.en.change";
    public static final String COMMAND_LANG_SET_FR = "command.lang.set.fr";
    public static final String COMMAND_LANG_SET_FR_CHANGE = "command.lang.set.fr.change";
    public static final String COMMAND_LEAVE = "command.leave";
    public static final String COMMAND_MOVE = "command.move";
    public static final String COMMAND_PLAYER = "command.player";
    public static final String COMMAND_ROOM = "command.room";
    public static final String COMMAND_UNKNOWN = "command.unknown";
    public static final String COMMAND_VERSION = "command.version";

    // Courses
    public static final String COURSE_FORGET = "course.forget";
    public static final String COURSE_GRADE = "course.grade";
    public static final String COURSE_GRADE_ERROR = "course.grade.error";
    public static final String COURSE_LEARN = "course.learn";
    public static final String COURSE_LEARN_ERROR = "course.learn.error";
    public static final String COURSE_LISTEN = "course.listen";
    public static final String COURSE_LISTEN_ERROR = "course.listen.error";

    // Items
    public static final String ITEM_BOOK = "item.book";
    public static final String ITEM_CHEAT = "item.cheat";
    public static final String ITEM_COFFEE = "item.coffee";
    public static final String ITEM_COFFEE_INTERACT = "item.coffee.interact";
    public static final String ITEM_BABYFOOT = "item.babyfoot";
    public static final String ITEM_BABYFOOT_INTERACT = "item.babyfoot.interact";

    // Commons
    public static final String MESSAGE_AVAILABLE = "message.available";
    public static final String MESSAGE_DIRECTION_EAST_ERROR = "message.direction.east.error";
    public static final String MESSAGE_DIRECTION_EAST_SUCCESS = "message.direction.east.success";
    public static final String MESSAGE_DIRECTION_NORTH_ERROR = "message.direction.north.error";
    public static final String MESSAGE_DIRECTION_NORTH_SUCCESS = "message.direction.north.success";
    public static final String MESSAGE_DIRECTION_SOUTH_ERROR = "message.direction.south.error";
    public static final String MESSAGE_DIRECTION_SOUTH_SUCCESS = "message.direction.south.success";
    public static final String MESSAGE_DIRECTION_UNKNOWN = "message.direction.unknown";
    public static final String MESSAGE_DIRECTION_WEST_ERROR = "message.direction.west.error";
    public static final String MESSAGE_DIRECTION_WEST_SUCCESS = "message.direction.west.success";
    public static final String MESSAGE_DISCOVER = "message.discover";
    public static final String MESSAGE_GAMEOVER = "message.gameover";
    public static final String MESSAGE_GOODBYE = "message.goodbye";
    public static final String MESSAGE_HELLO = "message.hello";
    public static final String MESSAGE_HELP = "message.help";
    public static final String MESSAGE_USAGE = "message.usage";

    // Players
    public static final String PLAYER_DEATH = "player.death";

    // Rooms
    public static final String ROOM_CLOSE = "room.close";
    public static final String ROOM_CLASS = "room.class";
    public static final String ROOM_LAB = "room.lab";
    public static final String ROOM_LUNCH = "room.lunchroom";
    public static final String ROOM_LIBRARY = "room.library";
    public static final String ROOM_CORRIDOR = "room.corridor";
    public static final String ROOM_DENY = "room.deny";

    /**
     * Create a new message implementation.
     */
    public Message() {
        checkValidity();
    }

    /**
     * Ensure that the implementation is valid.
     */
    private void checkValidity() {
        Map<String, String> map = toMap();
        for (String key : getKeys()) {
            if (!map.containsKey(key)) {
                throw new NullPointerException("The key '" + key + "' isn't implement");
            }
        }
    }

    /**
     * Gets a set that contains all keys to be implement.
     *
     * @return a set that contains all keys to be implement.
     */
    public Set<String> getKeys() {
        return ImmutableSortedSet.of(
                COMMAND_HELP,
                COMMAND_INTERACT,
                COMMAND_INTERACT_DISCOVER,
                COMMAND_INTERACT_DISCOVER_FAIL,
                COMMAND_INTERACT_LIGHT,
                COMMAND_INTERACT_LIGHT_OFF,
                COMMAND_INTERACT_LIGHT_ON,
                COMMAND_INTERACT_USE,
                COMMAND_INTERACT_USE_FAIL,
                COMMAND_LANG,
                COMMAND_LANG_AVAILABLE,
                COMMAND_LANG_SET,
                COMMAND_LANG_SET_EN,
                COMMAND_LANG_SET_EN_CHANGE,
                COMMAND_LANG_SET_FR,
                COMMAND_LANG_SET_FR_CHANGE,
                COMMAND_LEAVE,
                COMMAND_MOVE,
                COMMAND_PLAYER,
                COMMAND_ROOM,
                COMMAND_UNKNOWN,
                COMMAND_VERSION,
                COURSE_FORGET,
                COURSE_GRADE,
                COURSE_GRADE_ERROR,
                COURSE_LEARN,
                COURSE_LEARN_ERROR,
                COURSE_LISTEN,
                COURSE_LISTEN_ERROR,
                ITEM_BABYFOOT,
                ITEM_BABYFOOT_INTERACT,
                ITEM_BOOK,
                ITEM_CHEAT,
                ITEM_COFFEE,
                ITEM_COFFEE_INTERACT,
                MESSAGE_AVAILABLE,
                MESSAGE_DIRECTION_EAST_ERROR,
                MESSAGE_DIRECTION_EAST_SUCCESS,
                MESSAGE_DIRECTION_NORTH_ERROR,
                MESSAGE_DIRECTION_NORTH_SUCCESS,
                MESSAGE_DIRECTION_SOUTH_ERROR,
                MESSAGE_DIRECTION_SOUTH_SUCCESS,
                MESSAGE_DIRECTION_UNKNOWN,
                MESSAGE_DIRECTION_WEST_ERROR,
                MESSAGE_DIRECTION_WEST_SUCCESS,
                MESSAGE_DISCOVER,
                MESSAGE_GAMEOVER,
                MESSAGE_GOODBYE,
                MESSAGE_HELLO,
                MESSAGE_HELP,
                MESSAGE_USAGE,
                PLAYER_DEATH,
                ROOM_CLOSE,
                ROOM_CORRIDOR,
                ROOM_CLASS,
                ROOM_LIBRARY,
                ROOM_LAB,
                ROOM_LUNCH,
                ROOM_DENY
        );
    }

    /**
     * Returns a message english implementation.
     *
     * @return a message english implementation.
     */
    public static Message en() {
        return new MessageEn();
    }

    /**
     * Returns a message french implementation.
     *
     * @return a message french implementation.
     */
    public static Message fr() {
        return new MessageFr();
    }

    /**
     * Returns a map that contains the mapping.
     *
     * @return a map that contains the mapping.
     */
    public Map<String, String> toMap() {
        Map<String, String> commons = new TreeMap<>();
        commons.put(COMMAND_LANG_SET_EN, "Set the lang in English.");
        commons.put(COMMAND_LANG_SET_EN_CHANGE, "The language has been change in English.");
        commons.put(COMMAND_LANG_SET_FR, "Modifier la langue en Français.");
        commons.put(COMMAND_LANG_SET_FR_CHANGE, "La langue a été changé en Français.");
        commons.put(MESSAGE_GOODBYE, "Goodbye !.");
        return commons;
    }

}
