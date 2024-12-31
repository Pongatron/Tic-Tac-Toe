package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TicTacToe {

    private static ArrayList<Integer> playerPositions;
    private static ArrayList<Integer> cpuPositions;

    List<Integer> topRow;
    List<Integer> midRow;
    List<Integer> botRow;
    List<Integer> leftCol;
    List<Integer> midCol;
    List<Integer> rightCol;
    List<Integer> cross1;
    List<Integer> cross2;

    List<List<Integer>> win;


    public TicTacToe(){
        playerPositions = new ArrayList<>();
        cpuPositions = new ArrayList<>();

        topRow = Arrays.asList(1,2,3);
        midRow = Arrays.asList(4,5,6);
        botRow = Arrays.asList(7,8,9);
        leftCol = Arrays.asList(1,4,7);
        midCol = Arrays.asList(2,5,8);
        rightCol = Arrays.asList(3,6,9);
        cross1 = Arrays.asList(1,5,9);
        cross2 = Arrays.asList(3,5,7);

        win = new ArrayList<>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(cross1);
        win.add(cross2);
    }

    public void printGameBoard(char[][] board){

        //Prints out game board
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


    public void placePiece(char[][] board, int pos, String user){

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

    public int addCpuTurn(char[][] board){
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        while(getPlayerPositions().contains(cpuPos) || getCpuPositions().contains(cpuPos)){
            cpuPos = rand.nextInt(9) + 1;
        }
        placePiece(board, cpuPos, "cpu");
        printGameBoard(board);
        return cpuPos;
    }

    public String checkWinner(){

        for(List<Integer> l : win){
            if(playerPositions.containsAll(l)){
                return "Player Wins";
            }
            else if(cpuPositions.containsAll(l)){
                return "CPU Wins";
            }
        }
        if((playerPositions.size() + cpuPositions.size() == 9)){
            return "It's a Tie";
        }
        return "";
    }

    public ArrayList<Integer> getPlayerPositions(){return playerPositions;}
    public ArrayList<Integer> getCpuPositions(){return cpuPositions;}


    public static void main(String[] args){

        MyFrame frame = new MyFrame();

    }
}
