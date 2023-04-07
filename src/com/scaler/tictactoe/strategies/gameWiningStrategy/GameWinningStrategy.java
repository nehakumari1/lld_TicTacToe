package com.scaler.tictactoe.strategies.gameWiningStrategy;

import com.scaler.tictactoe.Model.Board;
import com.scaler.tictactoe.Model.Cell;
import com.scaler.tictactoe.Model.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board,
                        Player lastMovePlayer,
                        Cell moveCell);
}

