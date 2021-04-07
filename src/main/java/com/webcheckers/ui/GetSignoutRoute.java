/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: GetSignoutRoute.java
 */
package com.webcheckers.ui;

import com.webcheckers.util.PlayerLobby;
import com.webcheckers.util.Player;
import spark.*;

public class GetSignoutRoute implements Route {
    private TemplateEngine engine;
    private PlayerLobby lobby;

    /**
     * Constructor for the lobby
     * @param lobby: Player Lobby
     */
    public GetSignoutRoute(PlayerLobby lobby, TemplateEngine templateEngine){
        this.engine = templateEngine;
        this.lobby = lobby;
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
        final Session httpSession = request.session();

        Player currentPlayer = request.session().attribute("user");
        lobby.getInLobbyPlayers().remove(currentPlayer);
        lobby.getInGame().remove(currentPlayer);

        request.session().attribute("user", null);
        response.redirect("/");
        return engine.render(new ModelAndView(null, "home.ftl"));
    }
}
