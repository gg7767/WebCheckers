/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: BoardView.java
 */
package com.webcheckers.util.board;

import java.util.*;

/**
 * The BoardView class that is able to iterate
 * over a board to display it.
 */
public class BoardView implements Iterable<Row> {
    //A temporary board for demonstration
    private Board board;

    //The amount of rows in the board
    private int row;

    /**
     * Constructor for a new board view class.
     *
     * @param board The board that it is viewing
     */
    public BoardView(Board board) {
        this.row = 8;

        //Creates an array list of rows
        this.board = board;
    }

    /**
     * Gets the amount of rows in the board.
     *
     * @return The amount of rows in the board.
     */
    public int getRow(){
        return this.board.getRow();
    }

    /**
     * Gets the list of rows in the board.
     *
     * @return The list of rows in the board.
     */
    public ArrayList<Row> getBoard() {
        return board.getBoard();
    }
    
    public BoardView flip() {
        return board.flip();
    }

    /**
     * Gets the iterator for the rows of the board.
     *
     * @return The iterator for the rows.
     */
    public Iterator<Row> iterator() {
        return this.board.iterator();
    }
}