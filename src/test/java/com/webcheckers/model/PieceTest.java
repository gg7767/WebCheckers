package com.webcheckers.model;

import com.webcheckers.util.board.Piece;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the model of a checkers game piece
 *
 * @author Jake Waclawski
 */

@Tag("Model-tier")
public class PieceTest {
    Piece basePiece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);

    @Test
    public void testNewPiece() {
        assertNotNull(basePiece);
    }

    @Test
    public void testType() {
        Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);
        assertEquals(basePiece.getType(), piece.getType());
    }

    @Test
    public void testColor() {
        Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);
        assertEquals(basePiece.getColor(), piece.getColor());
    }

    @Test
    public void testEquals() {
        Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);
        assertEquals(basePiece, piece);
    }
}
