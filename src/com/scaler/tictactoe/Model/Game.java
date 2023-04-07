package com.scaler.tictactoe.Model;


import com.scaler.tictactoe.strategies.gameWiningStrategy.GameWinningStrategy;
import com.scaler.tictactoe.strategies.gameWiningStrategy.OrderOneGameWinningStrategy;
import exceptions.InvalidGameConstructionParameterException;

import java.util.ArrayList;
import java.util.List;

public class Game {

   
    private Board board;

    private List<Player> player;
    private List<Move> move;
    private GameStatus gameStatus;

    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;


    private Game(){

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void makeNextMove() {
        Player toMovePlayer = player.get(nextPlayerIndex);
        System.out.println("It is " + toMovePlayer.getName() + "'s turn");
        Move move = toMovePlayer.decideMove(this.board);
        //Validate the move
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Move happened at" + row + "," + col);

        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);


        Move finalMove = new Move(toMovePlayer, board.getBoard().get(row).get(col));
        this.move.add(finalMove);



        if(gameWinningStrategy.checkWinner(board,toMovePlayer,finalMove.getCell()))
        {
            gameStatus=GameStatus.ENDED;
            winner=toMovePlayer;
        }
        nextPlayerIndex += 1;
        nextPlayerIndex %= player.size();

    }
    public void displayBoard() {
        this.board.display();
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<Move> getMove() {
        return move;
    }

    public void setMove(List<Move> move) {
        this.move = move;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }
    public void undo() {
    }

    public static class Builder{
        private int dimension;

        private List<Player> player;



        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;}
        public Builder setPlayer(List<Player> player) {
            this.player = player;
            return this;
        }


        private boolean valid() throws InvalidGameConstructionParameterException {
            if (this.dimension<3)
                throw new InvalidGameConstructionParameterException("Dimension of game cant be less than 3");

            if (this.player.size()!=this.dimension-1){
                throw new InvalidGameConstructionParameterException("Number of player cant exceed that dimension-1");
            }
              return true;
        }

        public Game build() throws InvalidGameConstructionParameterException {
            try {
                valid();
            } catch (Exception e) {
                throw new InvalidGameConstructionParameterException(e.getMessage());
            }

            Game game = new Game() ;
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayer(player);
            game.setMove(new ArrayList<>());
            game.setBoard(new Board(dimension));
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));
           return game;
            }
        }

}
