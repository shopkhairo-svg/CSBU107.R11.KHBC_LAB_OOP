import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = scanner.nextLine();
        String reversed = "";
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = str.charAt(i);
            reversed += c;
        }
        System.out.println("The reversed is: "+ reversed);
        scanner.close();
    }
}