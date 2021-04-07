/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: Player.java
 */
package com.webcheckers.util;

/**
 * Class that represents a player.
 */
public class Player {
    //The name of the player.
    private String name;

    /**
     * Constructor for a new player.
     *
     * @param name The name of the player.
     */
    public Player(String name){
        this.name = name;
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks if two objects are players and have the same name.
     *
     * @param obj the other object to be compared to.
     *
     * @return True if they are equal, false if not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player){
            Player other = (Player) obj;
            return this.name.equals(other.getName());
        }
        else{
            return false;
        }
    }
}
