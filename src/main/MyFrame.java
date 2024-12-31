package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener, ActionListener {

    TicTacToe game;
    JPanel panel;
    JLabel label1, label2, label3,
            label4, label5, label6,
            label7, label8, label9;
    char[][] board = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '|', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '|', '-'},
            {' ', '|', ' ', '|', ' '}};
    Font boardFont = new Font("Arial", Font.BOLD, 150);
    Font titleFont = new Font("Arial", Font.BOLD, 80);
    Font winFont = new Font("Arial", Font.BOLD, 50);
    JLabel bottomText;
    JButton restartButton;
    boolean gameOver = false;

    /**
     * Class constructor
     */
    public MyFrame(){

        game = new TicTacToe();

        //set various frame parameters
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Tic-Tac-Toe");
        this.setSize(800,800);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        //panel for the game board
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3,10,10));
        panel.setBackground(Color.black);

        //creates labels 1-9 for the spaces on the game board
        createGridLabels();

        //add mouse listener to each label
        label1.addMouseListener(this);
        label2.addMouseListener(this);
        label3.addMouseListener(this);
        label4.addMouseListener(this);
        label5.addMouseListener(this);
        label6.addMouseListener(this);
        label7.addMouseListener(this);
        label8.addMouseListener(this);
        label9.addMouseListener(this);

        //panels for each margin
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JLabel top = new JLabel("Tic-Tac-Toe", JLabel.CENTER);
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        //initialize label for the displaying the win
        bottomText = new JLabel("", JLabel.CENTER);

        //set preferred sizes for each margin panel
        left.setPreferredSize(new Dimension(100,100));
        right.setPreferredSize(new Dimension(100,100));
        top.setPreferredSize(new Dimension(100,100));
        bottom.setPreferredSize(new Dimension(100,100));

        //set fonts
        top.setFont(titleFont);
        bottomText.setFont(winFont);

        //set restart button parameters
        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 30));
        restartButton.setFocusable(false);
        restartButton.setBackground(new Color(0x0c7ef7));
        restartButton.setForeground(Color.white);
        restartButton.setSize(100, 40);
        restartButton.addActionListener(this);

        //add the text and button to the bottom panel
        bottom.add(bottomText, BorderLayout.NORTH);
        bottom.add(restartButton, BorderLayout.SOUTH);

        //add each panel to the frame in their respective locations
        this.add(panel, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);

        //make sure the frame is visible
        this.setVisible(true);
    }

    /**
     * Displays an "O" onto the UI in whichever spot it selected
     * @param pos the position the CPU selected
     */
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

    /**
     * Places a piece on the UI and game board and checks if a win condition
     * has been met so it can end the game. otherwise continue
     * @param e the mouse event
     * @param label the label to be compared/modified
     * @param pos the position the player clicked on
     */
    public void decideLabelForPosition(MouseEvent e, JLabel label, int pos){
        if(!gameOver && e.getSource() == label && !(game.getPlayerPositions().contains(pos) || game.getCpuPositions().contains(pos))){
            label.setText("X");
            game.placePiece(board, pos, "player");
            if(!game.checkWinner().isEmpty()){
                gameOver = true;
                bottomText.setText(game.checkWinner());
            }
            if(game.checkWinner().isEmpty())
                displayCPU(game.addCpuTurn(board));
            if(!game.checkWinner().isEmpty()){
                gameOver = true;
                bottomText.setText(game.checkWinner());
            }
        }
    }

    /**
     * Turns the position gray when the player's mouse hovers over it
     * @param e the mouse event
     * @param label the label to be compared/modified
     * @param pos the position the player is highlighted over
     */
    public void decideLabelForHighlight(MouseEvent e, JLabel label, int pos){
        if(e.getSource() == label && !(game.getPlayerPositions().contains(pos) || game.getCpuPositions().contains(pos))){
            label.setBackground(Color.gray);
        }
    }

    /**
     * Turns the position back to white when the player's mouse stops hovering over it
     * @param e the mouse event
     * @param label the label to be compared/modified
     */
    public void decideLabelForUnHighlight(MouseEvent e, JLabel label){
        if(e.getSource() == label){
            label.setBackground(Color.white);
        }
    }

    /**
     * Resets the UI to be blank and resets the game's stored values
     */
    public void restartGame(){
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
        label7.setText("");
        label8.setText("");
        label9.setText("");

        bottomText.setText("");

        game.resetGame();

        gameOver = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {



    }

    @Override
    public void mousePressed(MouseEvent e) {
        decideLabelForPosition(e, label1, 1);
        decideLabelForPosition(e, label2, 2);
        decideLabelForPosition(e, label3, 3);
        decideLabelForPosition(e, label4, 4);
        decideLabelForPosition(e, label5, 5);
        decideLabelForPosition(e, label6, 6);
        decideLabelForPosition(e, label7, 7);
        decideLabelForPosition(e, label8, 8);
        decideLabelForPosition(e, label9, 9);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        decideLabelForHighlight(e, label1, 1);
        decideLabelForHighlight(e, label2, 2);
        decideLabelForHighlight(e, label3, 3);
        decideLabelForHighlight(e, label4, 4);
        decideLabelForHighlight(e, label5, 5);
        decideLabelForHighlight(e, label6, 6);
        decideLabelForHighlight(e, label7, 7);
        decideLabelForHighlight(e, label8, 8);
        decideLabelForHighlight(e, label9, 9);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        decideLabelForUnHighlight(e, label1);
        decideLabelForUnHighlight(e, label2);
        decideLabelForUnHighlight(e, label3);
        decideLabelForUnHighlight(e, label4);
        decideLabelForUnHighlight(e, label5);
        decideLabelForUnHighlight(e, label6);
        decideLabelForUnHighlight(e, label7);
        decideLabelForUnHighlight(e, label8);
        decideLabelForUnHighlight(e, label9);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == restartButton){
            restartGame();
        }
    }

    /**
     * Initializes all board labels and sets some parameters for them
     */
    public void createGridLabels(){

        label1 = new JLabel("", JLabel.CENTER);
        label1.setFont(boardFont);
        label1.setBackground(Color.white);
        label1.setOpaque(true);

        label2 = new JLabel("", JLabel.CENTER);
        label2.setFont(boardFont);
        label2.setBackground(Color.white);
        label2.setOpaque(true);

        label3 = new JLabel("", JLabel.CENTER);
        label3.setFont(boardFont);
        label3.setBackground(Color.white);
        label3.setOpaque(true);

        label4 = new JLabel("", JLabel.CENTER);
        label4.setFont(boardFont);
        label4.setBackground(Color.white);
        label4.setOpaque(true);

        label5 = new JLabel("", JLabel.CENTER);
        label5.setFont(boardFont);
        label5.setBackground(Color.white);
        label5.setOpaque(true);

        label6 = new JLabel("", JLabel.CENTER);
        label6.setFont(boardFont);
        label6.setBackground(Color.white);
        label6.setOpaque(true);

        label7 = new JLabel("", JLabel.CENTER);
        label7.setFont(boardFont);
        label7.setBackground(Color.white);
        label7.setOpaque(true);

        label8 = new JLabel("", JLabel.CENTER);
        label8.setFont(boardFont);
        label8.setBackground(Color.white);
        label8.setOpaque(true);

        label9 = new JLabel("", JLabel.CENTER);
        label9.setFont(boardFont);
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
