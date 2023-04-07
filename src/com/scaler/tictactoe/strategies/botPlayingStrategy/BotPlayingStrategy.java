package com.scaler.tictactoe.strategies.botPlayingStrategy;

import com.scaler.tictactoe.Model.Board;
import com.scaler.tictactoe.Model.Move;
import com.scaler.tictactoe.Model.Player;

public interface BotPlayingStrategy {


        Move decideMove(Player player, Board board);
    }

