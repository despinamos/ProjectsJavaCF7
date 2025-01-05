package gr.aueb.cf.exercises;

import java.util.Scanner;

/**
 * Ticktacktoe game.
 */

public class Project04 {
    static int winner = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] ticktacktoe = new char[3][3];
        int column1 = 0;
        int column2 = 0;
        int row1 = 0;
        int row2 = 0;

        System.out.println("Welcome to TIC TAC TOE game!");
        System.out.println("Player 1 plays with O");
        System.out.println("Player 2 plays with X");

        printArray(ticktacktoe);

        while(winner == 0) {
            System.out.println("Player 1 (O) choose position(row and column): ");
            row1 = in.nextInt();
            column1 = in.nextInt();

            while(isTaken(ticktacktoe, row1, column1)) {
                System.out.println("Place already taken. Please choose another.");
                row1 = in.nextInt();
                column1 = in.nextInt();
            }
            ticktacktoe[row1][column1] = 'O';

            checkForWinner(ticktacktoe);

            printArray(ticktacktoe);

            if(winner != 1 && !isArrayFull(ticktacktoe)) {
                System.out.println("Player 2 (X) choose position(row and column): ");
                row2 = in.nextInt();
                column2 = in.nextInt();

                while(isTaken(ticktacktoe, row2, column2)) {
                    System.out.println("Place already taken. Please choose another.");
                    row2 = in.nextInt();
                    column2 = in.nextInt();
                }

                ticktacktoe[row2][column2] = 'X';

                checkForWinner(ticktacktoe);
            }

            printArray(ticktacktoe);
        }

    }

    public static boolean isArrayFull(char[][] arr) {

        boolean isFull = false;
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == 'O' || arr[i][j] == 'X') {
                    counter++;
                }
            }
        }

        if (counter == 9) {
            isFull = true;
            winner = 3;
        }

        return isFull;
    }

    public static void printArray(char[][] arr) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isTaken(char[][] arr, int row, int column) {

        boolean isTaken = arr[row][column] == 'O' || arr[row][column] == 'X';
        return isTaken;
    }

    public static void checkForWinner(char[][] arr) {

        // check the rows, columns and diagonals

        if(arr[0][0]==arr[0][1] && arr[0][1]==arr[0][2] && arr[0][0]== 'O') {
            winner = 1;
        } else if(arr[0][0]==arr[0][1] && arr[0][1]==arr[0][2] && arr[0][0]== 'X') {
            winner = 2;
        } else if(arr[1][0]==arr[1][1] && arr[1][1]==arr[1][2] && arr[1][0]== 'O') {
            winner = 1;
        } else if(arr[1][0]==arr[1][1] && arr[1][1]==arr[1][2] && arr[1][0]== 'X') {
            winner = 2;
        } else if(arr[2][0]==arr[2][1] && arr[2][1]==arr[2][2] && arr[2][0]== 'O') {
            winner = 1;
        } else if(arr[2][0]==arr[2][1] && arr[2][1]==arr[2][2] && arr[2][0]== 'X') {
            winner = 2;
        } else if(arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0] && arr[0][0] == 'O') {
            winner = 1;
        } else if(arr[0][0]==arr[1][0] && arr[1][0]==arr[2][0] && arr[0][0] == 'X') {
            winner = 2;
        } else if(arr[0][1]==arr[1][1] && arr[1][1]==arr[2][1] && arr[0][1] == 'O') {
            winner = 1;
        } else if(arr[0][1]==arr[1][1] && arr[1][1]==arr[2][1] && arr[0][1] == 'X') {
            winner = 2;
        } else if(arr[0][2]==arr[1][2] && arr[1][2]==arr[2][2] && arr[0][2] == 'O') {
            winner = 1;
        } else if(arr[0][2]==arr[1][2] && arr[1][2]==arr[2][2] && arr[0][2] == 'X') {
            winner = 2;
        } else if(arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2] && arr[0][0] == 'O') {
            winner = 1;
        } else if(arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2] && arr[0][0] == 'X') {
            winner = 2;
        } else if(arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0] && arr[0][2] == 'O') {
            winner = 1;
        } else if(arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0] && arr[0][2] == 'X') {
            winner = 2;
        }

        if (winner == 1) {
            System.out.println("Player 1 is the winner. Congratulations.");
        } else if (winner == 2) {
            System.out.println("Player 2 is the winner. Congratulations.");
        } else {
            System.out.println("No winner. There was a draw.");
        }
    }
}
