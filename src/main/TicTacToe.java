package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TicTacToe {

    private static ArrayList<Integer> playerPositions = new ArrayList<>();
    private static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void printGameBoard(char[][] board){

        //Prints out game board
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public static void placePiece(char[][] board, int pos, String user){

        char symbol = 'X';

        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        }
        else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        switch(pos){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;

                break;
            default:
                break;
        }
    }

    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(cross1);
        win.add(cross2);

        for(List l : win){
            if(playerPositions.containsAll(l)){
                return "Player Wins";
            }
            else if(cpuPositions.containsAll(l)){
                return "CPU Wins";
            }
            else if(playerPositions.size() + cpuPositions.size() == 9){
                return "It's a Tie";
            }
        }
        return "";
    }


    public static void main(String[] args){

        MyFrame frame = new MyFrame();

        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};

        while(true){
            Scanner k = new Scanner(System.in);
            printGameBoard(board);
            System.out.println("Choose spot on grid by typing a number 1 - 9");
            int playerPos = k.nextInt();

            //Checks for valid number
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("Position Taken!\nEnter a number between 1 - 9");
                printGameBoard(board);
                playerPos = k.nextInt();
            }
            placePiece(board, playerPos, "player");
            if(!checkWinner().isEmpty()) {
                printGameBoard(board);
                System.out.println(checkWinner());
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(board, cpuPos, "cpu");

            if(!checkWinner().isEmpty()) {
                printGameBoard(board);
                System.out.println(checkWinner());
                break;
            }
        }
    }
}
