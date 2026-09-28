import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();
        System.out.println("The multiplication table of " + n + ":");
        for(int i = 1; i <= 10; i++) {
            int result = n*i;
            System.out.println(n + " x "+ i + " = " + result);
        }
        scanner.close();
    }
}