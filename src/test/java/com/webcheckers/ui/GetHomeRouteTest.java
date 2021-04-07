package com.webcheckers.ui;

/*
 * @author: Dustin Crane
 * @file: GetGameRoute.java
 */

import com.webcheckers.util.PlayerLobby;
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
class GetHomeRouteTest {
    private TemplateEngine templateEngine;
    private Session session;
    private PlayerLobby playerLobby;
    private GetGameRoute CuT;
    private Response response;
    private Request request;

    @BeforeEach
    void setUp() {
        this.templateEngine = mock(TemplateEngine.class);
        this.request = mock(Request.class);
        this.session = mock(Session.class);
        this.playerLobby = mock(PlayerLobby.class);
        when(request.session()).thenReturn(session);
        this.CuT = new GetGameRoute(templateEngine, playerLobby);
        this.response = mock(Response.class);
    }

    @AfterEach
    void tearDown() {
        templateEngine = null;
        request = null;
        CuT = null;
        response = null;
        session = null;
        playerLobby = null;
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
    void handleAttribute() {
        when(request.attributes()).thenReturn(null);

        try {
            CuT.handle(request, response);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }
}
