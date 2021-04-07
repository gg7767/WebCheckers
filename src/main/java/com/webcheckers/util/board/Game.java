package com.webcheckers.util.board;

import com.webcheckers.util.Player;
import com.webcheckers.util.enums.ActiveColor;

import java.util.*;

public class Game {
    private Player redPlayer;
    private Player whitePlayer;
    private ActiveColor activeColor;
    private Board board;
    private Deque<Move> pendingMoves;
    private String gameWinner;

    /**
     * constructor for the game, creates new boards for each player after they are assigned
     * @param redPlayer - red player
     * @param whitePlayer - white player
     */
    public Game(Player redPlayer, Player whitePlayer) {
        this.redPlayer = redPlayer;
        this.whitePlayer = whitePlayer;
        this.activeColor = ActiveColor.RED;
        this.board = new Board();
        pendingMoves = new LinkedList<>();
        gameWinner = null;
    }

    public Player getRedPlayer(){
        return redPlayer;
    }

    public Player getWhitePlayer(){
        return whitePlayer;
    }

    public void setActiveColor(ActiveColor activeColor){
        this.activeColor = activeColor;
    }

    public ActiveColor getActiveColor() {
        return activeColor;
    }

    public Player getActivePlayer() {
        if ( activeColor.equals( ActiveColor.RED ) ) {
            return redPlayer;
        }
        return whitePlayer;
    }

    public String getGameWinner() {
        return gameWinner;
    }

    public boolean backupMove(){
        if( !pendingMoves.isEmpty() ){
            pendingMoves.pollLast();
            return true;
        }
        return false;
    }
}
