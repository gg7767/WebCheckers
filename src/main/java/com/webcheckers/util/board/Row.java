/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: Row.java
 */
package com.webcheckers.util.board;

import java.util.*;

/**
 * Class that represents each row in the board.
 */
public class Row implements Iterable<Space> {
    //Which index in the board this row is
    private int index;

    //A list of the spaces in this row
    private ArrayList<Space> spaces;

    /**
     * Constructor for a new row.
     *
     * @param index The index of the row in the board.
     */
    public Row(int index) {
        this.index = index;

        //Creates the list for the spaces in this row
        this.spaces = new ArrayList<>();
        
        for (int i = 0;i < 8;i++) {
            Space space = new Space(i, index);
            spaces.add(space);
            
            if (space.isValid()){
                if (index >= 0 && index <= 2){
                    Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.WHITE);
                    space.setPiece(piece);
                }
                else if(index >=5 && index <= 7){
                    Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);
                    space.setPiece(piece);
                }
            }
        }
    }

    /**
     * Returns the current index of the row.
     *
     * @return The current index.
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Gets the spaces in the row.
     *
     * @return An arrayList of the spaces in the row.
     */
    public ArrayList<Space> getSpaces(){
        return this.spaces;
    }

    /**
     * Iterates over each space in the row
     *
     * @return The iterator for the spaces
     */
    @Override
    public Iterator<Space> iterator() {
        return this.spaces.iterator();
    }
}