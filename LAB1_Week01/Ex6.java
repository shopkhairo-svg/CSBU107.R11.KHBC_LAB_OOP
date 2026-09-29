import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the nummber of elements: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter " + n + " the integer into array:");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the integer x to be found: ");
        int x = scanner.nextInt();

        int index = -1;

        for(int i = 0; i < n; i++) {
            if(arr[i] == x) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            System.out.print(index); } 
            else {
            System.out.println("The position of " + x + " is: " + index);}
        scanner.close();

    }
}
