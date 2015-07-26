package com.lazygeeks.game;


public class Puzzle{
    
    public static void main(String[] args) {
        Matrix game = new Matrix("Game");
        game.show();
        game.addKeyListener(new MyKeyListener(game));
        
    }
}
