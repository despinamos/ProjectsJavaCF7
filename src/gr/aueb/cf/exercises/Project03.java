package gr.aueb.cf.exercises;

import java.io.*;

public class Project03 {

    public static void main(String[] args) {

        int[][] arr = new int[128][2];
        String line;

        try(BufferedReader charFile = new BufferedReader( new FileReader("C:/Users/Despoina/tmp/characters.txt"))) {
            while((line = charFile.readLine()) != null) {
                char[] c = line.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if(!isCharInArray(c[i], arr)) {
                        arr[i][0] = c[i];
                        arr[i][1]++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isCharInArray(char c, int[][] arr) {
        boolean isCharInArray = false;


        return isCharInArray;
    }
}
