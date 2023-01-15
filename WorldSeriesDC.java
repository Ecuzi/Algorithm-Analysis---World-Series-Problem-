//Course: CS4306 W02
//Student Name: Ethan Fitzgerald
//Assignment: #2
//Due Date: November 17, 2022
//Signature: Ethan Fitzgerald
//Score:
import java.util.Scanner;
import java.lang.Object;
public class WorldSeriesDC {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("What is the probability that team A will win(.1 - .9): ");
        double probability = sc.nextDouble();
        //     User Input for probability
        int numGames = 4;
        //     Chose a realistic number of games to win

        //Runtime Calc
        final long startTime = System.currentTimeMillis();
        System.out.println("Probability: " + Prob(numGames, numGames, probability));
        final long end = System.currentTimeMillis();
        System.out.println("Runtime: " + (end - startTime) + "ms");


    }

    public static double Prob(int i, int j, double pb) {

        //    Third parameter allows for user input on the probability.

        double q = 1 - pb;

        if (i == 0) {
            return 1;
        }
        else if (j == 0) {
            return 0;
        }

        else return pb * Prob(i - 1, j, pb) + q * Prob(i, j -1, pb);

    }



}
