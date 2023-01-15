//Course: CS4306 W02
//Student Name: Ethan Fitzgerald
//Assignment: #2
//Due Date: November 17, 2022
//Signature: Ethan Fitzgerald
//Score:

import java.util.Scanner;

public class WorldSeriesDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the probability that team A will win(.1 - .9): ");
        double probability = sc.nextDouble();
        //     User Input for probability
        int numGames = 4;
        //     Chose a realistic number of games to win
        System.out.println("Table of Probabilities for 4 Games: ");

        //Runtime Calc
        final long startTime = System.currentTimeMillis();
        System.out.println(ProbDP(numGames, numGames, probability));
        final long end = System.currentTimeMillis();

        System.out.println("Runtime: " + (end - startTime) + "ms");

        System.out.println(" \n //Course: CS4306 W02\n" +
                "//Student Name: Ethan Fitzgerald\n" +
                "//Assignment: #2\n" +
                "//Due Date: November 17, 2022\n" +
                "//Signature: Ethan Fitzgerald\n" +
                "//Score:");
    }

    public static double ProbDP(int i, int j, double pb) {
        //   initializing 2D Array to Store Table
        double[][] probArray = new double[i + 1][j + 1];
        //    prob for team B
        double q = 1 - pb;
        //    Allocating array
        for (int B = 1; B <= j; B++) {
            probArray[0][B] = 1.0;
        }
        //    Storing 0 in the array slot 0, 0 since this isn't possible
        probArray[0][0] = 0.0;

        for (int A = 1; A <= i; A++) {
            probArray[A][0] = 0.0;
        }
        //     Filling table with recursive formula
        for (int A = 1; A <= i; A++) {
            for (int B = 1; B <= j; B++) {
                probArray[A][B] = pb * probArray[A - 1][B] + q * probArray[A][B - 1];

            }
        }
        //    Displays table
        for (int A = 0; A < i + 1; A++) {
            for (int B = 0; B < j + 1; B++) {
                // Visual Improvements
                if (A == 0 && B == 0) {
                    System.out.print("      ");
                }
                else {
                    System.out.print(" " + Math.round(probArray[A][B] * 1000.0) / 1000.0 + " ");
                }
                if (B == j) {
                    System.out.println();
                }
            }
        }
        //    Answer
        System.out.println("\nAnswer:");
        return Math.round(probArray[i][j] * 1000.0) / 1000.0;
    }
}
