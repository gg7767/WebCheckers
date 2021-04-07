package com.webcheckers.ui;

import com.google.gson.Gson;
import com.webcheckers.util.Message;
import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: PostResignGameRoute.java
 */

public class PostResignGameRoute implements Route {

    final Map<String, Object> modeOptions = new HashMap<>(2);

    @Override
    public Object handle(Request request, Response response){
        Session session = request.session();

        Gson gson = new Gson();

        modeOptions.put("isGameOver", true);
        modeOptions.put("gameOverMessage", true);

        return gson.toJson(Message.info("Game over"));
    }
}
