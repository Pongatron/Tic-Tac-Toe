package main;

import java.util.Scanner;

public class TicTacToe {

    private static int[][] taken = new int[3][3];

    public static void printGameBoard(char[][] board){

        //Prints out game board
        for(char[] row : board){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] board, int choice, String user){

        char symbol = 'X';

        if(user.equals("player"))
            symbol = 'X';
        else
            symbol = 'O';

        switch(choice){
            case 1:
                if(taken[0][0] == 0)
                    board[0][0] = symbol;
                else
                    System.out.println("Spot taken");
                taken[0][0] = 1;
                break;
            case 2:
                if(taken[0][1] == 0)
                    board[0][2] = symbol;
                else
                    System.out.println("Spot taken");
                taken[0][1] = 1;
                break;
            case 3:
                if(taken[0][2] == 0)
                    board[0][4] = symbol;
                else
                    System.out.println("Spot taken");
                taken[0][2] = 1;
                break;
            case 4:
                if(taken[1][0] == 0)
                    board[2][0] = symbol;
                else
                    System.out.println("Spot taken");
                taken[1][0] = 1;
                break;
            case 5:
                if(taken[1][1] == 0)
                    board[2][2] = symbol;
                else
                    System.out.println("Spot taken");
                taken[1][1] = 1;
                break;
            case 6:
                if(taken[1][2] == 0)
                    board[2][4] = symbol;
                else
                    System.out.println("Spot taken");
                taken[1][2] = 1;
                break;
            case 7:
                if(taken[2][0] == 0)
                    board[4][0] = symbol;
                else
                    System.out.println("Spot taken");
                taken[2][0] = 1;
                break;
            case 8:
                if(taken[2][1] == 0)
                    board[4][2] = symbol;
                else
                    System.out.println("Spot taken");
                taken[2][1] = 1;
                break;
            case 9:
                if(taken[2][2] == 0)
                    board[4][4] = symbol;
                else
                    System.out.println("Spot taken");
                taken[2][2] = 1;
                break;
        }
    }

    public static void checkSpot(char[][] board, int choice){

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
