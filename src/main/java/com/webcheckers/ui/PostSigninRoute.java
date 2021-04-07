/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: PostSignoutRoute.java
 */
package com.webcheckers.ui;

import com.webcheckers.util.PlayerLobby;
import com.webcheckers.util.Message;
import com.webcheckers.util.Player;
import spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class PostSigninRoute implements Route {
    static final String SIGNIN = "signin";
    static final String VIEW_NAME = "signin.ftl";
    private final TemplateEngine templateEngine;
    private PlayerLobby lobby;
    private static final Message WELCOME_MSG = Message.info("Welcome to the world of online Checkers.");
    private static final String ALPHANUMERIC_ERROR = "ERROR: Enter a name with at least one alphanumeric character and no non-alphanumeric characters";
    private static final String NAME_IN_USE_ERROR = "ERROR: Your name is already in use";
    static final String NAME = "myName";


    /**
     * Constructor for the class
     */

    public PostSigninRoute(TemplateEngine templateEngine, PlayerLobby lobby){
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        this.templateEngine = templateEngine;
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
        int flag = 0;
        final Session httpSession = request.session();
        final Map<String, Object> vm = new HashMap<>();

        vm.put(SIGNIN, "Sign In");
        vm.put("message", WELCOME_MSG);

        final String name = request.queryParams(NAME);

        if(name.equals("") || name.equals(" ")) {

            flag=1;
        }
        if (name.charAt(0) == ' ' || name.charAt(name.length()-1) == ' '){
            flag=1;
        }

        for ( int i = 0; i<name.length(); i++){
            char ch = name.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != ' '){
                flag = 1;
            }
        }

        for(Player player : lobby.getInLobbyPlayers()){
            if(name.equals(player.getName())) {
                flag = 2;
                break;
            }
        }

        Player player = new Player(name);
        request.session().attribute("user", player);

        if (flag != 1 && flag != 2){
            this.lobby.addLobbyPlayer(player);
        }

        if (flag == 1){
            vm.put("message", Message.error(ALPHANUMERIC_ERROR));
            return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
        }

        if (flag == 2){
            vm.put("message", Message.error(NAME_IN_USE_ERROR));
            return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
        }

        response.redirect("/");
        return null;
    }
}
