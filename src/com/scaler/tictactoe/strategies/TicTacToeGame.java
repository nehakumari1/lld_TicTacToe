package com.scaler.tictactoe.strategies;

import com.scaler.tictactoe.Model.*;
import com.scaler.tictactoe.controllers.GameController;
import javafx.util.Pair;

import java.sql.SQLOutput;
import java.util.*;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GameController gameController = new GameController();


        System.out.println("What should be the dimension of the game");
        int dimension=in.nextInt();

        System.out.println("Will there be a bot in the game? Y/N");
        String  isBotString =in.next();

        List<Player> player = new ArrayList<>();
        int toIterate = dimension-1;


        if(isBotString.equals('Y'))
        {
            toIterate=dimension-2;
        }

        for(int i=0;i<toIterate;i++) {
            System.out.println("What is the name of the Player ? " + i);
            String PlayerName = in.next();


            System.out.println("What is the symbol  of the Player ? " + i);
            char playerSymbol = in.next().charAt(0);

            player.add(new Player(playerSymbol, PlayerName, playerType.HUMAN));
        }
            if(isBotString.equals("y")){
                System.out.println("What is the name of the bot? ");
                String botName = in.next();

                System.out.println("What is the symbol for this bot" );
                char botSymbol = in.next().charAt(0);

            player.add(new Bot(botSymbol, botName, BotDifficultyLevel.EASY));}

        Game game =gameController.CreateGame(dimension,player);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is your current board");

            gameController.displayBoard(game);

                System.out.println("Does anyone want to undo :Y/N");
                String input=in.next();

                if(input=="y"){
                    gameController.undo(game);
                }

                else{
                    gameController.executeNextMove(game);
                }

            System.out.println("Game has ended,results was: ");

                if(!game.getGameStatus().equals(GameStatus.DRAW))
                {
                    System.out.println("winnner is :"+ gameController.getWinner(game));
                    gameController.displayBoard(game);
                }

        }
    }
}
