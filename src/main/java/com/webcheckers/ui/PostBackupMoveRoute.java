//package com.webcheckers.ui;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.webcheckers.util.Message;
//import com.webcheckers.util.PlayerLobby;
//import com.webcheckers.util.board.*;
//import spark.*;
//
///**
// * @authors: Gnandeep Gottipati, Jake Waclawski, Dustin Crane, Brayden Casella
// * @file: PostBackupMoveRoute.java
// */
//public class PostBackupMoveRoute implements Route {
//    private static final String BACKUP_INFO ="Reset board to your last valid move";
//    private static final String BACKUP_ERROR = "There was no move to backup to!";
//
//    private PlayerLobby playerLobby;
//    //private Game game;
//    private Message message;
//
//    /**
//     * constructor for PostBackupMove
//     * @param playerLobby
//     */
//    public PostBackupMoveRoute(PlayerLobby playerLobby, Game game){
//        this.playerLobby = playerLobby;
//        this.game = game;
//    }
//
//    /**
//     * sends a message if a backup move was successful or not
//     * @param request the spark request object
//     * @param response he response spark object
//     * @return json with message
//     * @throws Exception
//     */
//    @Override
//    public Object handle(Request request, Response response) throws Exception{
//
//        String playerName = request.session().attribute( "user" );
//        Boolean moveLeft = game.backupMove();
//
//        if(moveLeft){
//            message = Message.info(BACKUP_INFO);
//        }
//        else{
//            message = Message.error(BACKUP_ERROR);
//        }
//
//        String json;
//        Gson gson = new GsonBuilder().create();
//        json = gson.toJson( message );
//
//        return json;
//    }
//}
