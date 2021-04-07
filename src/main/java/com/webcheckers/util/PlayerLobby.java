/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: PlayerLobby.java
 */
package com.webcheckers.util;

import java.util.ArrayList;

public class PlayerLobby{

/**
 * The lobby for the players to join and select matches.
 */
    //The list of players in the lobby
    private ArrayList<Player> inLobby;

    //A list of players that are able to play a game.
    private ArrayList<Player> activePlayers;

    //The list of players that are currently in a game.
    private ArrayList<Player> inGame;

    //Message for the amount of players in the lobby.
    private String STATS_MESSAGE = "There is %d player in the lobby";

    //Second message for the amount of players in the lobby.
    private String STATS_MESSAGE_1 = "There are %d players in the lobby";

    /**
     * Constructor for a player lobby.
     * Initializes lists.
     */
    public PlayerLobby() {
        this.inLobby = new ArrayList<>();
        this.activePlayers = new ArrayList<>();
        this.inGame = new ArrayList<>();
    }

    /**
     * Adds a player to the lobby.
     *
     * @param player the player to add.
     */
    public void addLobbyPlayer(Player player) {
        this.inLobby.add(player);
    }

    /**
     * Adds a player to the active players list.
     *
     * @param player the player to add.
     */
    public void addActivePlayer(Player player) {
        this.activePlayers.add(player);
    }

    /**
     * Adds a player to the in game players list.
     *
     * @param player the player to add.
     */
    public void addInGamePlayer(Player player) { this.inGame.add(player);}

    /**
     * Gets the amount of players in the current lobby.
     *
     * @return The size of the lobby.
     */
    public int getSize() {
        return this.inLobby.size();
    }

    /**
     * Gets the correct message to display.
     *
     * @return The message to display.
     */
    public String getMessage() {
        if (this.getSize() == 0) {
            return "";
        } else if (this.getSize() == 1) {
            return String.format(STATS_MESSAGE, this.getSize());
        } else {
            return String.format(STATS_MESSAGE_1, this.getSize());
        }
    }

    /**
     * Gets the players that are in the lobby.
     *
     * @return The list of players in the lobby.
     */
    public ArrayList<Player> getInLobbyPlayers() {
        return this.inLobby;
    }

    /**
     * Gets the active players in the lobby.
     *
     * @return The list of active players.
     */
    public ArrayList<Player> getActivePlayers() {
        return this.activePlayers;
    }

    /**
     * Gets the list of players that are currently in a game.
     *
     * @return The list of players in a game.
     */
    public ArrayList<Player> getInGame(){
        return this.inGame;
    }
}

