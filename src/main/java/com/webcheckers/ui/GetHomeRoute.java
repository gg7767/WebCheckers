
package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.webcheckers.util.PlayerLobby;
import com.webcheckers.util.Player;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateEngine;

import com.webcheckers.util.Message;

/**
 * The UI Controller to GET the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 */
public class GetHomeRoute implements Route {
    private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());

    private static final Message WELCOME_MSG = Message.info("Welcome to the world of online Checkers.");

    private final TemplateEngine templateEngine;

    private PlayerLobby lobby;

    /**
     * Create the Spark Route (UI controller) to handle all {@code GET /} HTTP requests.
     *
     * @param templateEngine the HTML template rendering engine
     */
    public GetHomeRoute(final TemplateEngine templateEngine, PlayerLobby lobby) {
        this.templateEngine = Objects.requireNonNull(templateEngine, "templateEngine is required");
        LOG.config("GetHomeRoute is initialized.");
        this.lobby = lobby;
    }

    /**
     * Render the WebCheckers Home page.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @return the rendered HTML for the Home page
     */
    @Override
    public Object handle(Request request, Response response) {
        LOG.finer("GetHomeRoute is invoked.");

        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Welcome!");

        // display a user message in the Home page
        vm.put("message", WELCOME_MSG);

        vm.put("statMessage", lobby.getMessage());

        vm.put("lobby", lobby.getInLobbyPlayers());

        Player player = request.session().attribute("user");
        for (Player p : lobby.getActivePlayers()) {
            if (!p.equals(player)) {
                request.session().attribute("opponent", p);
                lobby.getInGame().add(p);

            }
        }

        if (this.lobby.getActivePlayers().size() == 2) {
            if (this.lobby.getActivePlayers().contains(player)) {
                lobby.getInGame().add(player);
                response.redirect("/game");
                return null;
            }
        }

        if ( request.queryParams("inGame") != null ){
            vm.put("message", Message.error("This Player is already in a Game"));
        }

        vm.put("currentUser", player);

        return templateEngine.render(new ModelAndView(vm , "home.ftl"));
  }
}
