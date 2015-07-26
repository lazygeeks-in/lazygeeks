package com.lazygeeks.game;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Matrix extends JFrame {

    private static final long serialVersionUID = -3047528381643198827L;

    String[][] data = new String[4][4];
    
    int emptyXIndex = 3;
    int emptyYIndex = 3;
    String emptyValue ="";
    int[][] sucessArray = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
  
    JPanel pannel = new JPanel();
    JLabel[][] labels = new JLabel[4][4];
    JTextField tf = new JTextField();
  
    public Matrix() {

        this.setTitle("LazyGeeks");
        this.setSize(300, 250);
        this.setVisible(true);

        init();
        draw();
    }

    public Matrix(String title) {
        this();
        this.setTitle(title);  
        pannel.setLayout(new GridLayout(4, 4));
    }

    /**
     * draw the matrix at the end of each move
     */
    void draw() {
        System.out.println(" x = "+emptyXIndex+"   y = "+emptyYIndex);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                labels[i][j].setText("  "+data[i][j]);
            }
        }
        this.add(pannel);
        this.repaint();
    }

    /**
     * Initial setup of the martix. Should be a ramdom fill of number between 1
     * and 15
     */
    void init() {
        String[] seed = { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",""};
        int k = 0;
        Collections.shuffle(Arrays.asList(seed));
        
        // initialize all the components
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = seed[k++];
                if ( data[i][j].isEmpty()){
                    emptyXIndex = i;
                    emptyYIndex = j;
                }
                labels[i][j] = new JLabel(data[i][j]);
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pannel.add(labels[i][j]);
            }
        }
    }

    void moveLeft() {
        // check if the emptyXIndex is the first element
        if (emptyYIndex == 0) {
            System.out.println(" No space to move left " + emptyYIndex);
            return;
        }

        // make the swap with 0
        data[emptyXIndex][emptyYIndex] = data[emptyXIndex][emptyYIndex - 1];
        data[emptyXIndex][emptyYIndex - 1] = emptyValue;

        // adjust empty y index
        emptyYIndex -= 1;
        draw();
    }

    void moveRight() {
        // check if the emptyXIndex is the last element
        if (emptyYIndex == 3) {
            System.out.println(" No space to move right " + emptyYIndex);
            return;
        }
        // make the swap with 0
        data[emptyXIndex][emptyYIndex] = data[emptyXIndex][emptyYIndex + 1];
        data[emptyXIndex][emptyYIndex + 1] = emptyValue;

        // adjust the empty index accordingly
        emptyYIndex += 1;
        draw();
    }

    void moveUP() {
        // check if the emptyYIndex is the first element
        if (emptyXIndex == 0) {
            System.out.println(" No space to move up " + emptyXIndex);
            return;
        }

        // make the swap with 0
        data[emptyXIndex][emptyYIndex] = data[emptyXIndex - 1][emptyYIndex];
        data[emptyXIndex - 1][emptyYIndex] = emptyValue;

        // adjust the emptxindex
        emptyXIndex -= 1;
    
        draw();
    }

    void moveDown() {
        // check if the emptyYIndex is the first element
        if (emptyXIndex == 3) {
            System.out.println(" No space to move down " + emptyXIndex);
            return;
        }
        // make the swap with 0
        data[emptyXIndex][emptyYIndex] = data[emptyXIndex + 1][emptyYIndex];
        data[emptyXIndex + 1][emptyYIndex] = emptyValue;

        // adjust empty y index
        emptyXIndex += 1;
        draw();
    }
 
}
