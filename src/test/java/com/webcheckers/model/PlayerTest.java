package com.webcheckers.model;

import static org.junit.jupiter.api.Assertions.*;

import com.webcheckers.util.Player;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Model-tier")
public class PlayerTest {

    Player player = new Player("Gnandeep");

    @Test
    public void test1(){
        final Player player1 = new Player("Gnandeep");
        assertTrue(player.equals(player1));
    }

    @Test
    public void test2(){
        final Player player1 = new Player("Gnandeep");
        assertEquals(player.getName(), player1.getName());
    }

    @Test
    public void test3(){
        assertFalse(player.equals(new Object()));
    }


}
