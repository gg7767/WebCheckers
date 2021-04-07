package com.webcheckers.model;

import com.webcheckers.util.board.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the model of a checkers game space.
 *
 * Author: Brayden Casella
 */

@Tag("Model-tier")
public class SpaceTest {
    @Test
    public void testNewSpace() {
        Space space = new Space(0, 0);
        
        space.isValid();
        
        assertNotNull(space);
    }
    
    @Test
    public void testPiecePlacement() {
        Space space = new Space(0, 0);
        Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);

        space.setPiece(piece);

        assertNotNull(space.getPiece());
    }
}
