package com.game;

import java.util.*;

public class TicTacToeGame {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();

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

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Place your piece (1-9):");
            int playerPos = scan.nextInt();
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("This position is taken. Choose different square");
                playerPos = scan.nextInt();
            }
            placePiece(gameBoard, playerPos, "player");
            String result = winCondition();
            if(result.length() > 0 ) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");

            result = winCondition();
            if(result.length() > 0 ) {
                System.out.println(result);
                break;
            }
        }
    }

    private static void placePiece(char[][] gameBoard, int piecePos, String user) {

        char symbol = ' ';

        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(piecePos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(piecePos);
        }

        switch (piecePos) {
            case 1:
                gameBoard[1][1] = symbol;
                break;
            case 2:
                gameBoard[1][3] = symbol;
                break;
            case 3:
                gameBoard[1][5] = symbol;
                break;
            case 4:
                gameBoard[3][1] = symbol;
                break;
            case 5:
                gameBoard[3][3] = symbol;
                break;
            case 6:
                gameBoard[3][5] = symbol;
                break;
            case 7:
                gameBoard[5][1] = symbol;
                break;
            case 8:
                gameBoard[5][3] = symbol;
                break;
            case 9:
                gameBoard[5][5] = symbol;
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

    private static String winCondition() {
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List lowRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,5,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List diag1 = Arrays.asList(1,5,9);
        List diag2 = Arrays.asList(3,5,7);

        List<List> winningPositions = new ArrayList<List>();
        winningPositions.add(topRow);
        winningPositions.add(midRow);
        winningPositions.add(lowRow);
        winningPositions.add(leftCol);
        winningPositions.add(midCol);
        winningPositions.add(rightCol);
        winningPositions.add(diag1);
        winningPositions.add(diag2);

        for (List l: winningPositions) {
            if (playerPositions.containsAll(l)) {
                return "You won!";
            } else if (cpuPositions.containsAll(l)) {
                return "Cpu won";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "No winner";
            }
        }

        return "";
    }

}
