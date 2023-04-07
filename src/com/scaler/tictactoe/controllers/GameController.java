package com.scaler.tictactoe.controllers;

import com.scaler.tictactoe.Model.*;

import java.util.List;

public class GameController {

    public void undo(Game game){
        game.undo();
    }

    public Game CreateGame(int dimension , List<Player> player){
        try{
            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayer(player)
                    .build();
        }
        catch (Exception e){
            // You can add your proper message for the Client here
            System.out.println(e);
        }
        return null;
    }



    public void displayBoard(Game game) {
        game.displayBoard();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void executeNextMove(Game game) {
        game.makeNextMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}