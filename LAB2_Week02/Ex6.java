package LAB2_Week02;
class Calculator {
    //Add 2 integers
    public int add (int a, int b) {
        return a + b;
    }

    //Add 2 double numbers
    public double add (double a, double b) {
        return a + b;
    }

    //Add 3 intergers
    public int add (int a, int b, int c) {
        return a + b + c;
    }

    //Method max of 2 intergers
    public int max (int a, int b) {
        return (a > b) ? a : b;
    }
    //Method max of 2 double numbers
    public double max (double a, double b) {
        return (a > b) ? a : b;
    }

    
}
public class Ex6 {
    public static void main(String[] args) {
        // Create a Calculator object
        Calculator calculator = new Calculator();

        // Test overloaded add() methods
        int sum1 = calculator.add(10, 20);
        double sum2 = calculator.add(2.5, 3.7);
        int sum3 = calculator.add(10, 20, 30);

        // Test overloaded max() methods
        int max1 = calculator.max(10, 20);
        double max2 = calculator.max(5.5, 3.2);

        // Display results
        System.out.println("add(int, int) = " + sum1);
        System.out.println("add(double, double) = " + sum2);
        System.out.println("add(int, int, int) = " + sum3);
        System.out.println("max(int, int) = " + max1);
        System.out.println("max(double, double) = " + max2);
    }
}
