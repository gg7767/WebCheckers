/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: Space.java
 */
package com.webcheckers.util.board;


/**
 * Class that represents each space in the board.
 */
public class Space {
    //The index of the space in the row.
    private int cellIdx;

    //The piece that is in the space, can be null.
    private Piece piece;

    //The row that the space is in.
    private int row;

    /**
     * Constructor for a new space.
     *
     * @param index The index of the space in the row.
     * @param row The index of the row that is in the board.
     */
    public Space(int index, int row) {
        this.cellIdx = index;
        this.row = row;
    }

    /**
     * Returns the index of the current cell.
     *
     * @return The current cell index.
     */
    public int getCellIdx(){
        return this.cellIdx;
    }

    /**
     * Checks if the given space is valid for a piece to
     * be placed on.
     *
     * @return true if black space, false if white space.
     */
    public boolean isValid(){
        if (this.getPiece() != null){
            return false;
        }
        if (row%2 == 0 && cellIdx%2 != 0){
            return true;
        }
        else if (row%2 != 0 && cellIdx%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Sets the current piece on the space.
     *
     * @param piece The piece that is placed in this cell.
     */
    public void setPiece(Piece piece){
        this.piece = piece;
    }

    /**
     * Returns the current piece on the space.
     *
     * @return The piece in the current spot
     */
    public Piece getPiece(){
        return this.piece;
    }
}