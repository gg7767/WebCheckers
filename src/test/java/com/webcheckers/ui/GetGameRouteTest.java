package com.webcheckers.ui;

/*
 * @author: Dustin Crane
 * @file: GetGameRoute.java
 */

import com.webcheckers.util.PlayerLobby;
import com.webcheckers.util.board.BoardView;
import com.webcheckers.util.board.Piece;
import com.webcheckers.util.board.Row;
import com.webcheckers.util.board.Board;
import com.webcheckers.util.board.Space;
import spark.*;
import java.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@Tag("UI-tier")
class GetGameRouteTest {
    private TemplateEngine templateEngine;
    private Session session;
    private PlayerLobby playerLobby;
    private GetGameRoute CuT;
    private Response response;
    private Request request;
    private BoardView boardView;

    @BeforeEach
    void setUp() {
        this.templateEngine = mock(TemplateEngine.class);
        this.request = mock(Request.class);
        this.session = mock(Session.class);
        this.playerLobby = mock(PlayerLobby.class);
        when(request.session()).thenReturn(session);
        this.CuT = new GetGameRoute(templateEngine, playerLobby);
        this.response = mock(Response.class);

        Board boardV = new Board();
        this.boardView = new BoardView(boardV);
        int rows = boardView.getRow();
        ArrayList<Row> board = boardView.getBoard();

        for (int i = 0; i<rows; i++){
            Row row = new Row(i);
            board.add(row);
            ArrayList<Space> spaces = row.getSpaces();
            for (int j = 0; j<rows; j++){
                Space space = new Space(j, i);
                if (space.isValid()){
                    if (i>=0 && i<=2){
                        Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.WHITE);
                        space.setPiece(piece);
                    }
                    else if(i>=5 && i<= 7){
                        Piece piece = new Piece(Piece.PieceType.SINGLE, Piece.Color.RED);
                        space.setPiece(piece);
                    }
                }
                spaces.add(space);
            }
        }
    }

    @AfterEach
    void tearDown() {
        templateEngine = null;
        request = null;
        CuT = null;
        response = null;
        session = null;
        playerLobby = null;
        boardView = null;
    }

    @Test
    void ctor() {
        assertNotNull(CuT, "Constructor test failed");
    }

    @Test
    void handleViewName() {
        final TemplateEngineTester tester = new TemplateEngineTester();
        when(templateEngine.render(any(ModelAndView.class))).thenAnswer(tester.makeAnswer());
        try {
            CuT.handle(request, response);
        }
        catch(Exception e){
            fail(e.getMessage());
        }

        tester.assertViewName("game.ftl");
    }

    @Test
    void handlePlayer() {
        when(request.attributes()).thenReturn(null);

        try {
            CuT.handle(request, response);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }
}