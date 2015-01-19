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
package fr.techcode.zuul.universe.world.item;

import com.google.common.base.Strings;
import fr.techcode.zuul.i18n.I18n;
import fr.techcode.zuul.universe.player.Player;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Represent an item.
 */
public abstract class Item {

    // Name of the item
    private String name;

    // Description of the item
    private String description;

    /**
     * Create a new item.
     *
     * @param name        name of the item.
     * @param description description of the item.
     */
    public Item(String name, String description) {
        checkArgument(!Strings.isNullOrEmpty(name), "Name of the item can't null or empty");
        checkArgument(!Strings.isNullOrEmpty(description), "Name of the item can't null or empty");
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the name of the item.
     *
     * @return name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the item.
     *
     * @return description of the item.
     */
    public String getDescription() {
        return I18n.get(description);
    }

    /**
     * Fired when an interaction with this item is attempt.
     *
     * @param player player involved in this interaction.
     */
    public abstract void onInteract(Player player);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return name.equals(item.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
