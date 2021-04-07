package com.webcheckers.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.api.Test;
import spark.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Tag("UI-tier")
public class GetSigninRouteTest {
    //component under test
    private GetSigninRoute CuT;

    //Other required mock objects
    private Request request;
    private Session session;
    private Response response;
    private TemplateEngine engine;

    @BeforeEach
    public void setup(){
        this.request = mock(Request.class);
        this.session = mock(Session.class);
        when(request.session()).thenReturn(session);
        this.response = mock(Response.class);
        this.engine = mock(TemplateEngine.class);
        this.CuT = new GetSigninRoute(engine);
    }

    @Test
    public void signin() throws Exception {
        final TemplateEngineTester tester = new TemplateEngineTester();
        when(engine.render(any(ModelAndView.class))).thenAnswer(tester.makeAnswer());

        CuT.handle(request, response);

        tester.assertViewName("signin.ftl");
    }

    @Test
    public void signedin() throws Exception{
        when(request.attributes()).thenReturn(null);

        try {
            CuT.handle(request, response);
        }
        catch (IllegalArgumentException e){
            fail(e.getMessage());
        }
    }

}
