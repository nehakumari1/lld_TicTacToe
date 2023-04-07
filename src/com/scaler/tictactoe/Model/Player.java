package com.scaler.tictactoe.Model;

import java.util.Scanner;

public class    Player {

    private char symbol;
    public String name;
    private playerType type;

    public Move decideMove(Board board){
        Scanner in =new Scanner(System.in);
        System.out.println("Please tell the row.starting from 0");
        int row=in.nextInt();
        System.out.println("Please tell the coloumn starting from 0");
        int col=in.nextInt();

            return new Move(this, new Cell(row, col));
    }

    public Player(char symbol, String name, playerType type) {
        this.symbol=symbol;
        this.name=name;
        this.type=type;
    }



    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public playerType  getType() {
        return type;
    }

    public void setPlayerType(playerType  type) {
        this.type = type;
    }


}
