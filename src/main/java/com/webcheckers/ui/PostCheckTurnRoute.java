package com.webcheckers.ui;

import com.google.gson.Gson;
import com.webcheckers.util.board.Move;
import com.webcheckers.util.Message;
import spark.*;

/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: PostCheckTurnRoute.java
 */

public class PostCheckTurnRoute implements Route {
    private Gson gson;

    public PostCheckTurnRoute(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Session session = request.session();
        //Player currentPlayer =
        return formatMessageJson("false");
    }

    public Object formatMessageJson(String message) {
        return gson.toJson(Message.info(message));
    }
}
