import java.util.Scanner;

public class Ex_BonusNum7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        // 2. Read the timestamps into an array
        double[] timestamps = new double[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextDouble();
        }

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = scanner.nextDouble();

        double totalDamage = 0;
        int leftPointer = 0;

        for (int i = 0; i < n; i++) {
            double currentTime = timestamps[i];

            while (currentTime - timestamps[leftPointer] > z) {
                leftPointer++;
            }
            int activeQuills = i - leftPointer;

            double damageForThisHit = x + (activeQuills * y);
            totalDamage += damageForThisHit;
        }

        if (totalDamage == (long) totalDamage) {
            System.out.println((long) totalDamage);
        } else {
            System.out.println(totalDamage);
        }

        scanner.close();
    }
}