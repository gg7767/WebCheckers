/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: GetGameRoute.java
 */
package com.webcheckers.ui;

import com.webcheckers.util.*;
import com.webcheckers.util.board.BoardView;
import com.webcheckers.util.board.Piece;
import com.webcheckers.util.board.Row;
import com.webcheckers.util.board.Board;
import com.webcheckers.util.board.Space;
import com.webcheckers.util.enums.ActiveColor;
import com.webcheckers.util.enums.ViewMode;
import spark.*;

import java.util.*;

public class GetGameRoute implements Route {

    static final String GAME = "game";
    static final String VIEW_NAME = "game.ftl";

    private final TemplateEngine templateEngine;

    private PlayerLobby lobby;

    /**
     * Constructor for the class
     * @param templateEngine: template engine
     * @param lobby: player lobby
     */
    public GetGameRoute(final TemplateEngine templateEngine, PlayerLobby lobby){
        Objects.requireNonNull(templateEngine, "templateEngine must not be null");
        this.templateEngine = templateEngine;
        this.lobby  = lobby;
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
        final Map<String, Object> vm = new HashMap<>();

        Player player = request.session().attribute("user");

        vm.put("title", "Game!");
        vm.put(GAME, "Game");
        vm.put("currentUser", player);

        Player opponent = request.session().attribute("opponent");

        if (opponent == null){
            final String opponent_name = request.queryParams("opponent");
            opponent = new Player(opponent_name);
        }

        if (lobby.getInGame().contains(opponent) && lobby.getActivePlayers().size() == 0){
            response.redirect("/?inGame=true");
            return null;
        }

        if (lobby.getActivePlayers().size()>0){
            vm.put("redPlayer", opponent);
            vm.put("whitePlayer", player);
        } else {
            vm.put("redPlayer", player);
            vm.put("whitePlayer", opponent);
        }

        Board board = new Board();
        BoardView boardView = new BoardView(board);
        int rows = boardView.getRow();

        vm.put("activeColor", ActiveColor.RED);
        vm.put("viewMode", ViewMode.PLAY);

        if (lobby.getActivePlayers().size() == 0){
            this.lobby.getActivePlayers().add(player);
            this.lobby.getActivePlayers().add(opponent);
            vm.put("board", boardView);
        } else {
            this.lobby.getActivePlayers().remove(player);
            this.lobby.getActivePlayers().remove(opponent);
            BoardView boardViewFlipped = boardView.flip();
            vm.put("board", boardViewFlipped);
        }

        return templateEngine.render(new ModelAndView(vm, VIEW_NAME));
    }
}