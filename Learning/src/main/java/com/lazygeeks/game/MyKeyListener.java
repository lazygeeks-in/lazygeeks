package com.lazygeeks.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyListener extends KeyAdapter{
    
    Matrix matrix;
    
    MyKeyListener(Matrix  obj){
        super();
        matrix = obj;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_UP){
            matrix.moveUP();
        }
        if( e.getKeyCode() == KeyEvent.VK_DOWN){
            matrix.moveDown();
        }
        if( e.getKeyCode() == KeyEvent.VK_LEFT){
            matrix.moveLeft();
        }
        if( e.getKeyCode() == KeyEvent.VK_RIGHT){
            matrix.moveRight();
        }
    }
}
