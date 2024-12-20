package main;

import java.util.Scanner;

public class TicTacToe {

    private static int[][] taken = new int[3][3];
    private static int player = 0;
    private static int cpu = 1;
    private static int turn = 0;

    public static void printGameBoard(char[][] board){

        //Prints out game board
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void turnChanger(int takenX, int takenY){

        if(taken[takenX][takenY] == 0){
            if(turn == player)
                turn = cpu;
            else if(turn == cpu)
                turn = player;
        }
        else if(taken[takenX][takenY] == 1){
            System.out.println("Spot taken. Try another");
            if(turn == player)
                turn = player;
            else if(turn == cpu)
                turn = cpu;
        }
    }

    public static void boardGridCase(char[][] board, char symbol, int takenX, int takenY, int boardX, int boardY){
        if(taken[takenX][takenY] == 0) {
            board[boardX][boardY] = symbol;
            turnChanger(takenX,takenY);
        }
        else
            turnChanger(takenX,takenY);
        taken[takenX][takenY] = 1;
    }

    public static void placePiece(char[][] board, int choice, String user){

        char symbol = 'X';

        if(turn == 1)
            symbol = 'X';
        else if(turn == 0)
            symbol = 'O';

        switch(choice){
            case 1:
                boardGridCase(board, symbol, 0, 0, 0, 0);
                break;
            case 2:
                boardGridCase(board, symbol, 0, 1, 0, 2);
                break;
            case 3:
                boardGridCase(board, symbol, 0, 2, 0, 4);
                break;
            case 4:
                boardGridCase(board, symbol, 1, 0, 2, 0);
                break;
            case 5:
                boardGridCase(board, symbol, 1, 1, 2, 2);
                break;
            case 6:
                boardGridCase(board, symbol, 1, 2, 2, 4);
                break;
            case 7:
                boardGridCase(board, symbol, 2, 0, 4, 0);
                break;
            case 8:
                boardGridCase(board, symbol, 2, 1, 4, 2);
                break;
            case 9:
                boardGridCase(board, symbol, 2, 2, 4, 4);
                break;
        }
    }


    public static void main(String[] args){

        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(board);

        Scanner k = new Scanner(System.in);

        int turn = 0;
        boolean boardFull = false;
        while(!boardFull){
            System.out.println("Choose spot on grid by typing a number 1 - 9");
            int choice = k.nextInt();

            //Checks for valid number
            while(choice < 1 || choice > 9){
                System.out.println("Invalid Number\nEnter a number between 1 - 9");
                choice = k.nextInt();
            }
            if(turn == 0){
                placePiece(board, choice, "player");
                turn = 1;
            }
            else if (turn == 1) {
                placePiece(board, choice, "cpu");
                turn = 0;
            }
            printGameBoard(board);

            //checks to see if board is full
            boardFull = true;
            for(int[] row : taken){
                for(int c : row){
                    if (c == 0) {
                        boardFull = false;
                        break;
                    }
                }
            }
        }





    }

}
