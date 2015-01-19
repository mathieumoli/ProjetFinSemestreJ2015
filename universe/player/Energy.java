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
package fr.techcode.zuul.universe.player;

import com.google.common.primitives.Ints;

/**
 * Simple implementation of the player energy.
 */
abstract class Energy {

    // Current energy level
    private int energy;

    // Max energy level
    private int max;

    /**
     * Create a new energy level based on a max energy of 100.
     */
    public Energy() {
        this(100);
    }

    /**
     * Create a new energy level.
     *
     * @param max max energy level.
     */
    public Energy(int max) {
        this.max = max;
        this.energy = Ints.saturatedCast(max);
    }

    /**
     * Increase the level of energy.
     *
     * @param val value to increase.
     * @return a reference to this object.
     */
    public Energy increaseEnergy(int val) {
        energy += Math.min(val, Integer.MAX_VALUE);
        energy = Math.min(energy, max);
        return this;
    }

    /**
     * Decrease the level of energy.
     *
     * @param val value to decrease.
     * @return a reference to this object.
     */
    public Energy decreaseEnergy(int val) {
        energy -= Math.max(val, Integer.MIN_VALUE);
        energy = Math.max(energy, 0);
        if (energy == 0) onDeath();
        return this;
    }

    /**
     * Fired when the death occured.
     */
    public abstract void onDeath();


    /**
     * Gets the current energy level.
     *
     * @return current energy level.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Returns a string that represent this object.
     *
     * @return a string that represent this object.
     */
    @Override
    public String toString() {
        return "Energy{" +
                "energy=" + energy +
                ", max=" + max +
                '}';
    }

}
