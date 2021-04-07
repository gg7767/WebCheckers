/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: Piece.java
 */
package com.webcheckers.util.board;



/**
 * Represents a piece on the board that is able to be moved and altered.
 */
public class Piece {
    /**
     * Enum to represent the types available for
     * a given piece to be.
     */
    public enum PieceType {
        SINGLE,
        KING
    }

    /**
     * Enum that represents the color of a piece on the board.
     */
    public enum Color {
        RED,
        WHITE
    }


    //The type of the piece, king or normal
    private PieceType type;

    //The color of the piece
    private Color color;

    /**
     * Constructor for a new piece.
     *
     * @param type The type of the piece.
     * @param color The color of the piece.
     */
    public Piece(PieceType type, Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Gets the current type of the piece.
     *
     * @return The type of the piece.
     */
    public PieceType getType() {
        return this.type;
    }

    /**
     * Gets the current color of the piece.
     *
     * @return The color of the piece.
     */
    public Color getColor() {
        return this.color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Piece) {
            Piece other = (Piece) obj;
            return this.color.equals(other.getColor()) && this.type.equals(other.getType());
        }
        else {
            return false;
        }
    }

}