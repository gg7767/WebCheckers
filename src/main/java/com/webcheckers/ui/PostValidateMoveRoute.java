package com.webcheckers.ui;

import com.google.gson.Gson;
import com.webcheckers.util.Message;
import com.webcheckers.util.board.Board;
import com.webcheckers.util.board.Move;
import spark.Request;
import spark.Response;
import spark.Route;

import java.net.URLDecoder;

/**
 * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
 * @file: PostValidateMoveRoute.java
 */

public class PostValidateMoveRoute implements Route {
    private Gson gson;

    public PostValidateMoveRoute(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String obj = request.body();
        String[] stringArray = obj.split("=", 2);
        String position = URLDecoder.decode(stringArray[1], "UTF-8");

        Move move = this.gson.fromJson(position, Move.class);


        //System.out.println(board.makeMove(move));

        return formatMessageJson("true");
    }

    public Object formatMessageJson(String message) {
        return Message.info(message);
    }
}
