package com.scaler.tictactoe.factories;

import com.scaler.tictactoe.Model.BotDifficultyLevel;
import com.scaler.tictactoe.strategies.botPlayingStrategy.BotPlayingStrategy;
import com.scaler.tictactoe.strategies.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategyForDifficultyLevel(BotDifficultyLevel  botDifficultyLevel)
    {
   return new RandomBotPlayingStrategy();
    }
}
