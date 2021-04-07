/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: GetSigninRoute.java
 */
package com.webcheckers.ui;

import spark.*;

import java.util.Objects;

public class GetSigninRoute implements Route {

    private final TemplateEngine templateEngine;

    /**
     * Constructor for the class
     */
    public GetSigninRoute(final TemplateEngine templateEngine){
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        this.templateEngine = templateEngine;
    }
    /**
     * handler function to handle the response and request and render the page
     * @param request: request from the client
     * @param response: response sent to the client
     * @return Rendered page
     * @throws Exception
     */
    @Override
    public Object handle(Request request, Response response) throws Exception {
        return templateEngine.render(new ModelAndView(null, "signin.ftl"));
    }
}
