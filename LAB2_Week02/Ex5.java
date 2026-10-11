package LAB2_Week02;

import java.util.Random;
import java.util.Scanner;

class Dice {
    //Atribute
    private int value;

    //Initial constructor
    public Dice () {
        value = 1;
    }

    //Method roll
    public int roll () {
        Random random = new Random();
        value = random.nextInt(6) + 1;
        return value;
    }

}

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        System.out.print("Enter the number of rolls: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.print("n must be greater than 0.");
            scanner.close();
            return;
        }

        //Create a Dice object
        Dice dice = new Dice();
        //Store the frequency of each face
        int[] frequency = new int[7];

        for (int i = 0; i < n; i++) {
            int result = dice.roll();
            frequency[result]++;
        }

         // Display the experimental probability
        System.out.println("\nFace\tFrequency\tProbability");

        for (int face = 1; face <= 6; face++) {
            double probability = (double) frequency[face] / n;

            System.out.printf("%d\t%d\t\t%.4f (%.2f%%)%n",
                    face, frequency[face],
                    probability, probability * 100);
        }

        scanner.close();
    }
}
