package com.game;

import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {

        char[][] gameBoard = {
                {'╔', '=', '=', '=', '=', '=', '╗'},
                {'║', ' ', '|', ' ', '|', ' ', '║'},
                {'║', '-', '+', '-', '+', '-', '║'},
                {'║', ' ', '|', ' ', '|', ' ', '║'},
                {'║', '-', '+', '-', '+', '-', '║'},
                {'║', ' ', '|', ' ', '|', ' ', '║'},
                {'╚', '=', '=', '=', '=', '=', '╝'}
        };

        printBoard(gameBoard);

        Scanner scan = new Scanner(System.in);
        System.out.println("Place your piece (1-9):");
        int piecePos = scan.nextInt();

        System.out.println(piecePos);

        placePiece(gameBoard, piecePos);

    }

    private static void placePiece(char[][] gameBoard, int piecePos) {

//        if(user.eqals)

        switch (piecePos) {
            case 1:
                gameBoard[1][1] = 'X';
                break;
            case 2:
                gameBoard[1][3] = 'X';
                break;
            case 3:
                gameBoard[1][5] = 'X';
                break;
            case 4:
                gameBoard[3][1] = 'X';
                break;
            case 5:
                gameBoard[3][3] = 'X';
                break;
            case 6:
                gameBoard[3][5] = 'X';
                break;
            case 7:
                gameBoard[5][1] = 'X';
                break;
            case 8:
                gameBoard[5][3] = 'X';
                break;
            case 9:
                gameBoard[5][5] = 'X';
                break;
        }
        printBoard(gameBoard);
    }

    private static void printBoard(char[][] gameBoard) {
        for(char[] row: gameBoard) {
            for(char col: row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

}
