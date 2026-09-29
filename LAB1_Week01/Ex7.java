import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the first array (n): ");
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        
        System.out.println("Enter " + n + " integers for the first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of elements in the second array (m): ");
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        
        System.out.println("Enter " + m + " integers for the second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] mergedArray = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }

        System.out.print("Merged sorted array: ");
        for (int x = 0; x < mergedArray.length; x++) {
            System.out.print(mergedArray[x] + " ");
        }
        System.out.println();

        scanner.close();
    }
}