package main;

import java.util.Scanner;

public class TicTacToe {

    public static void printGameBoard(char[][] board){

        //Prints out game board
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }



    public static void main(String[] args){

        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(board);

        System.out.println("Choose spot on grid by typing a number 1 - 9");
        Scanner k = new Scanner(System.in);
        int choice = k.nextInt();

        //Checks for valid number
        while(choice < 1 || choice > 9){
            System.out.println("Invalid Number\nEnter a number between 1 - 9");
            choice = k.nextInt();
        }

        switch(choice){
            case 1:
                board[0][0] = 'X';
                break;
            case 2:
                board[0][2] = 'X';
                break;
            case 3:
                board[0][4] = 'X';
                break;
            case 4:
                board[2][0] = 'X';
                break;
            case 5:
                board[2][2] = 'X';
                break;
            case 6:
                board[2][4] = 'X';
                break;
            case 7:
                board[4][0] = 'X';
                break;
            case 8:
                board[4][2] = 'X';
                break;
            case 9:
                board[4][4] = 'X';
                break;

        }
        printGameBoard(board);


    }

}
