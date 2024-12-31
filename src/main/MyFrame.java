package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Scanner;

public class MyFrame extends JFrame implements MouseListener, ActionListener {

    JPanel panel;
    JLabel label1, label2, label3,
            label4, label5, label6,
            label7, label8, label9;
    TicTacToe game;
    int lastClicked;
    char[][] board = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '|', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '|', '-'},
            {' ', '|', ' ', '|', ' '}};
    boolean gameOver = false;

    public MyFrame(){

        game = new TicTacToe();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3,10,10));
        panel.setBackground(Color.black);

        createGridLabels();

        label1.addMouseListener(this);
        label2.addMouseListener(this);
        label3.addMouseListener(this);
        label4.addMouseListener(this);
        label5.addMouseListener(this);
        label6.addMouseListener(this);
        label7.addMouseListener(this);
        label8.addMouseListener(this);
        label9.addMouseListener(this);

        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        left.setBackground(Color.lightGray);
        right.setBackground(Color.lightGray);
        top.setBackground(Color.lightGray);
        bottom.setBackground(Color.lightGray);

        left.setPreferredSize(new Dimension(100,100));
        right.setPreferredSize(new Dimension(100,100));
        top.setPreferredSize(new Dimension(100,100));
        bottom.setPreferredSize(new Dimension(100,100));



        this.add(panel, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);



        //this.pack();
        this.setVisible(true);
        runGame();
    }

    public void runGame(){
        /*char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};
*/
        //while(true){
            Scanner k = new Scanner(System.in);
            game.printGameBoard(board);
            System.out.println("Choose spot on grid by typing a number 1 - 9");
            int playerPos = lastClicked;

            //Checks for valid number
            /*while(game.getPlayerPositions().contains(playerPos) || game.getCpuPositions().contains(playerPos)){
                System.out.println("Position Taken!\nEnter a number between 1 - 9");
                game.printGameBoard(board);
                playerPos = k.nextInt();
            }*/
            //game.placePiece(board, playerPos, "player");
            if(!game.checkWinner().isEmpty()) {
                game.printGameBoard(board);
                System.out.println(game.checkWinner());
                //break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(game.getPlayerPositions().contains(cpuPos) || game.getCpuPositions().contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            //game.placePiece(board, cpuPos, "cpu");

            if(!game.checkWinner().isEmpty()) {
                game.printGameBoard(board);
                System.out.println(game.checkWinner());
                //break;
            }
        //}
    }

    public void displayCPU (int pos){
        switch(pos){
            case 1:
                label1.setText("O");
                break;
            case 2:
                label2.setText("O");
                break;
            case 3:
                label3.setText("O");
                break;
            case 4:
                label4.setText("O");
                break;
            case 5:
                label5.setText("O");
                break;
            case 6:
                label6.setText("O");
                break;
            case 7:
                label7.setText("O");
                break;
            case 8:
                label8.setText("O");
                break;
            case 9:
                label9.setText("O");
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(!gameOver && e.getSource() == label1 && !(game.getPlayerPositions().contains(1) || game.getCpuPositions().contains(1))){
            label1.setText("X");
            game.placePiece(board, 1, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label2 && !(game.getPlayerPositions().contains(2) || game.getCpuPositions().contains(2))){
            label2.setText("X");
            game.placePiece(board, 2, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label3 && !(game.getPlayerPositions().contains(3) || game.getCpuPositions().contains(3))){
            label3.setText("X");
            game.placePiece(board, 3, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label4 && !(game.getPlayerPositions().contains(4) || game.getCpuPositions().contains(4))){
            label4.setText("X");
            game.placePiece(board, 4, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label5 && !(game.getPlayerPositions().contains(5) || game.getCpuPositions().contains(5))){
            label5.setText("X");
            game.placePiece(board, 5, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label6 && !(game.getPlayerPositions().contains(6) || game.getCpuPositions().contains(6))){
            label6.setText("X");
            game.placePiece(board, 6, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label7 && !(game.getPlayerPositions().contains(7) || game.getCpuPositions().contains(7))){
            label7.setText("X");
            game.placePiece(board, 7, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label8 && !(game.getPlayerPositions().contains(8) || game.getCpuPositions().contains(8))){
            label8.setText("X");
            game.placePiece(board, 8, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }
        else if(!gameOver && e.getSource() == label9 && !(game.getPlayerPositions().contains(9) || game.getCpuPositions().contains(9))){
            label9.setText("X");
            game.placePiece(board, 9, "player");
            if(game.checkWinner() == "")
                displayCPU(game.addCpuTurn(board));
            else{
                gameOver = true;
                System.out.println(game.checkWinner());
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == label1 && !(game.getPlayerPositions().contains(1) || game.getCpuPositions().contains(1))){
            label1.setBackground(Color.gray);
        }
        else if(e.getSource() == label2 && !(game.getPlayerPositions().contains(2) || game.getCpuPositions().contains(2))){
            label2.setBackground(Color.gray);
        }
        else if(e.getSource() == label3 && !(game.getPlayerPositions().contains(3) || game.getCpuPositions().contains(3))){
            label3.setBackground(Color.gray);
        }
        else if(e.getSource() == label4 && !(game.getPlayerPositions().contains(4) || game.getCpuPositions().contains(4))){
            label4.setBackground(Color.gray);
        }
        else if(e.getSource() == label5 && !(game.getPlayerPositions().contains(5) || game.getCpuPositions().contains(5))){
            label5.setBackground(Color.gray);
        }
        else if(e.getSource() == label6 && !(game.getPlayerPositions().contains(6) || game.getCpuPositions().contains(6))){
            label6.setBackground(Color.gray);
        }
        else if(e.getSource() == label7 && !(game.getPlayerPositions().contains(7) || game.getCpuPositions().contains(7))){
            label7.setBackground(Color.gray);
        }
        else if(e.getSource() == label8 && !(game.getPlayerPositions().contains(8) || game.getCpuPositions().contains(8))){
            label8.setBackground(Color.gray);
        }
        else if(e.getSource() == label9 && !(game.getPlayerPositions().contains(9) || game.getCpuPositions().contains(9))){
            label9.setBackground(Color.gray);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == label1){
            label1.setBackground(Color.white);
        }
        else if(e.getSource() == label2){
            label2.setBackground(Color.white);
        }
        else if(e.getSource() == label3){
            label3.setBackground(Color.white);
        }
        else if(e.getSource() == label4){
            label4.setBackground(Color.white);
        }
        else if(e.getSource() == label5){
            label5.setBackground(Color.white);
        }
        else if(e.getSource() == label6){
            label6.setBackground(Color.white);
        }
        else if(e.getSource() == label7){
            label7.setBackground(Color.white);
        }
        else if(e.getSource() == label8){
            label8.setBackground(Color.white);
        }
        else if(e.getSource() == label9){
            label9.setBackground(Color.white);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void createGridLabels(){

        Font font = new Font("Arial", Font.BOLD, 150);

        label1 = new JLabel("", SwingConstants.CENTER);
        label1.setFont(font);
        label1.setBackground(Color.white);
        label1.setOpaque(true);

        label2 = new JLabel("", SwingConstants.CENTER);
        label2.setFont(font);
        label2.setBackground(Color.white);
        label2.setOpaque(true);

        label3 = new JLabel("", SwingConstants.CENTER);
        label3.setFont(font);
        label3.setBackground(Color.white);
        label3.setOpaque(true);

        label4 = new JLabel("", SwingConstants.CENTER);
        label4.setFont(font);
        label4.setBackground(Color.white);
        label4.setOpaque(true);

        label5 = new JLabel("", SwingConstants.CENTER);
        label5.setFont(font);
        label5.setBackground(Color.white);
        label5.setOpaque(true);

        label6 = new JLabel("", SwingConstants.CENTER);
        label6.setFont(font);
        label6.setBackground(Color.white);
        label6.setOpaque(true);

        label7 = new JLabel("", SwingConstants.CENTER);
        label7.setFont(font);
        label7.setBackground(Color.white);
        label7.setOpaque(true);

        label8 = new JLabel("", SwingConstants.CENTER);
        label8.setFont(font);
        label8.setBackground(Color.white);
        label8.setOpaque(true);

        label9 = new JLabel("", SwingConstants.CENTER);
        label9.setFont(font);
        label9.setBackground(Color.white);
        label9.setOpaque(true);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(label9);

    }
}
