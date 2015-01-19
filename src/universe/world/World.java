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
package fr.techcode.zuul.universe.world;

import com.google.common.base.Strings;
import fr.techcode.zuul.universe.world.room.*;
import fr.techcode.zuul.util.Direction;
import fr.techcode.zuul.util.Position;

import java.util.Map;
import java.util.TreeMap;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represent a world.
 */
public class World {

    // All rooms
    private Map<Position, Room> rooms = new TreeMap<>();

    // Name of the world
    private String name;

    // Type of the world
    private WorldType type;

    /**
     * Create a new world.
     *
     * @param name name of the world.
     */
    public World(String name, WorldType type) {
        checkArgument(!Strings.isNullOrEmpty(name), "Name of the world can't be null or empty");
        checkNotNull(type, "Type of the world can't null");
        this.name = name;
        this.type = type;
        generate(type);
    }

    /**
     * Gets the name of the world.
     *
     * @return name of the world.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of the world.
     *
     * @return type of the world.
     */
    public WorldType getType() {
        return type;
    }

    /**
     * Gets the spawn room for this world.
     *
     * @return spawn room for this world.
     */
    public Room getSpawnRoom() {
        return rooms.get(Position.INITIAL);
    }

    /**
     * Set the room on a given position in the world.
     *
     * @param location location in the world.
     * @param room     room to set.
     * @return a reference to this object.
     */
    public World setRoom(Position location, Room room) {
        rooms.put(location, room);
        Room current;
        for (Direction direction : Direction.values()) {
            current = rooms.get(location.fromDirection(direction));
            if (current != null) {
                room.setNeightbor(direction, current);
                current.setNeightbor(direction.getOpposite(), room);
            }
        }
        return this;
    }

    /**
     * Generate the world.
     * Currently the generation is hard coded.
     * If you want to have fun :).
     *
     * @param type type of the world.
     */
    private void generate(WorldType type) {
        setRoom(new Position(-1, 0), new Library(this, new Position(-1, 0)));
        setRoom(new Position(0, -1), new ClassRoom(this, new Position(0, -1), CourseType.OOP));
        setRoom(Position.INITIAL, new Room(this, Position.INITIAL));
        setRoom(new Position(0, 1), new LabRoom(this, new Position(0, 1), CourseType.OOP));
        setRoom(new Position(1, -1), new ClassRoom(this, new Position(1, -1), CourseType.C));
        setRoom(new Position(1, 0), new Room(this, new Position(1, 0)));
        setRoom(new Position(1, 1), new LabRoom(this, new Position(1, 1), CourseType.C));
        setRoom(new Position(2, -1), new ExamRoom(this, new Position(2, -1), "Exam C", CourseType.C));
        setRoom(new Position(2, 0), new Room(this, new Position(2, 0)));
        setRoom(new Position(2, 1), new ExamRoom(this, new Position(2, 1), "Exam OOP", CourseType.OOP));
        setRoom(new Position(3, 0), new LunchRoom(this, new Position(3, 0)));
    }

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                '}';
    }
}
