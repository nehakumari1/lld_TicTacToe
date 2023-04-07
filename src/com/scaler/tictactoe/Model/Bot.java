package com.scaler.tictactoe.Model;

import com.scaler.tictactoe.factories.BotPlayingStrategyFactory;
import com.scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player{

    private BotDifficultyLevel   botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(char symbol, String name,BotDifficultyLevel   botDifficultyLevel ){
        super(symbol,name,playerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy  = BotPlayingStrategyFactory.getStrategyForDifficultyLevel(botDifficultyLevel);
    }
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move decideMove(Board board) {
        return botPlayingStrategy.decideMove(this, board);
    }
}

