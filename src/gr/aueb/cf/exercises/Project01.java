package gr.aueb.cf.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project01 {
    public static void main(String[] args) {

        File numbersFile = new File("C:/Users/Despoina/Downloads/tmp/numbers.txt");

        try (Scanner inFile = new Scanner(numbersFile);
                Scanner inFile2 = new Scanner(numbersFile)) {
            int counter = 0;

            while (inFile.hasNextInt()) {
                counter++;
                inFile.nextInt();
            }

            if(counter < 6 || counter > 49) {
                System.out.println("File must have at least 6 numbers or less than 49");
                counter = 0;
            }

            int[] arr = new int[counter];

            for(int i = 0; i< arr.length; i++) {
                arr[i] = inFile2.nextInt();
            }

        } catch(FileNotFoundException e) {

        }
    }
}
