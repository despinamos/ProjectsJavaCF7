package gr.aueb.cf.exercises;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Uses a book method and a cancel method
 * to manage a theater with 30x12 seats.
 * Each seat is characterized by a latin letter
 * referring to the column and an integer
 * referring to the row.
 */

public class Project05 {

    static boolean[][] theater = new boolean[30][12];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char column = ' ';
        int row = 0;
        int choice = 0;

        while(choice != 3) {
            printMenu();
            choice = in.nextInt();

            while(choice < 1 || choice > 3) {
                System.out.println("Choice must be between 1 and 3.");
                choice = in.nextInt();
            }

            switch(choice) {
                case 1:
                    System.out.println("Please enter the seat you would like to reserve.");
                    column = in.next().charAt(0);
                    row = in.nextInt();

                    book(column, row);
                    break;
                case 2:
                    System.out.println("Please enter the seat you would like to cancel.");
                    column = in.next().charAt(0);
                    row = in.nextInt();

                    cancel(column, row);
                    break;
                case 3:
                    System.out.println("Exiting...");

                    for(int i = 0; i < 30; i++){
                        for(int j = 0; j < 12; j++ ) {
                            System.out.print(theater[i][j]);
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Please choose what you would like to do.");
        System.out.println("1. Book a seat");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Exit");
    }

    public static void book(char column, int row) {
        if (!theater[row][column - 64]) {
            theater[row][column - 64] = true;
            System.out.println("Reservation made for seat " + column + row);
        } else {
            System.out.println("Seat already reserved. Please choose another.");
        }
    }

    public static void cancel(char column, int row) {
        if(theater[row][column - 64]) {
            theater[row][column - 64] = false;
            System.out.println("Cancelation for seat " + column + row + " successful.");
        } else {
            System.out.println("Seat is not already reserved.");
        }
    }
}
