package com.webcheckers.model;

import com.webcheckers.util.board.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the model of a checkers game.
 * 
 * Author: Brayden Casella
 */

@Tag("Model-tier")
public class BoardTest {
    @Test
    public void testNewBoard() {
        Board board = new Board();
        BoardView boardV = new BoardView(board);
        
        assertNotNull(boardV);
        assertNotNull(boardV.getBoard());
    }
    
    @Test
    public void testIterator() {
        Board board = new Board();
        BoardView boardV = new BoardView(board);
        
        assertNotNull(boardV.iterator());
    }
}