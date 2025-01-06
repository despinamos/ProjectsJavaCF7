package gr.aueb.cf.exercises;

import java.io.*;
import java.util.Arrays;

/**
 * Reads characters from a file,
 * saves them on an array and
 * counts how many times they appear.
 * Then, it sorts the array according
 * to the characters and according to
 * their frequency.
 */

public class Project03 {

    public static void main(String[] args) {

        int[][] arr = new int[128][2];
        int[][] arrSortedByChar;
        int[][] arrSortedByFrequency;
        String line;
        int positionRow = 0;

        try(BufferedReader charFile = new BufferedReader( new FileReader("C:/Users/Despoina/tmp/characters.txt"))) {
            while((line = charFile.readLine()) != null) {
                char[] c = line.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if(!isCharInArray(c[i], arr) && c[i] != ' ') {
                        arr[i][0] = c[i];
                        arr[i][1]++;
                    } else {
                        positionRow = positionOfChar(c[i], arr);
                        arr[positionRow][1]++;
                    }
                }
            }

            for(int i = 0; i < 128; i++) {
                System.out.println((char)arr[i][0] + " " + arr[i][1]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortByChar(int[][] arr) {

    }

    public static void sortByFrequency(int[][] arr) {

    }

    public static int positionOfChar(char c, int[][] arr) {
        int positionRow = 0;

        for (int i = 0; i < 128; i++) {
           if (arr[i][0] == c) {
               positionRow = i;
           }
        }

        return positionRow;
    }

    public static boolean isCharInArray(char c, int[][] arr) {
        boolean isCharInArray = false;

        for(int i = 0; i < 128; i++) {
            if (arr[i][0] == c) {
                isCharInArray = true;
                break;
            }
        }

        return isCharInArray;
    }
}
