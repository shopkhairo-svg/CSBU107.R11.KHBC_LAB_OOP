import java.util.Scanner;

public class Ex2 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
       
        System.out.print("Enter three numbers: ");
        
        int num1 = scanner.nextInt(); 
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        
        int max;
        
        if (num1 >= num2 && num1 >= num3) {
            max = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            max = num2;
        } else {
            max = num3;
        }
        System.out.println("The largest number is: " + max);
        scanner.close(); 
    } 
}