import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = scanner.nextInt();
        num = Math.abs(num);
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }
        System.out.print("Sum of its digits is: " + sum);
        scanner.close();
    }
}
