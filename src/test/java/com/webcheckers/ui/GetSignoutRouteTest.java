package com.webcheckers.ui;

import com.webcheckers.util.PlayerLobby;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spark.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test UI component GetSignoutRoute
 *
 * @author Jake Waclawski
 */

@Tag("UI-tier")
public class GetSignoutRouteTest {
    private GetSignoutRoute CuT;

    private Request request;
    private Session session;
    private Response response;
    private PlayerLobby lobby;
    private TemplateEngine engine;

    @BeforeEach
    public void setup(){
        this.engine = mock(TemplateEngine.class);
        this.request = mock(Request.class);
        this.session = mock(Session.class);
        when(request.session()).thenReturn(session);
        this.response = mock(Response.class);
        this.lobby = mock(PlayerLobby.class);
        this.CuT = new GetSignoutRoute(lobby, engine);
    }

    @Test
    public void signout() throws Exception {
        final TemplateEngineTester tester = new TemplateEngineTester();
        when(engine.render(any(ModelAndView.class))).thenAnswer(tester.makeAnswer());

        CuT.handle(request, response);

        tester.assertViewName("home.ftl");
    }
}
