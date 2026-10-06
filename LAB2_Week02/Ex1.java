package LAB2_Week02;

class Rectangle {
    //1. Attributes
    private double width;
    private double height;
    //2. No-argument constructor
    public Rectangle () {
        width = 1;
        height = 1;
    }
    //3. Parameterized constructor
    public Rectangle (double width, double height) {
        this.width = width > 0 ? width : 1;
        this.height = height > 0 ? height : 1;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
        System.out.println("-----------------------");
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5, 3);
        Rectangle r3 = new Rectangle(2.4, 5.7);


        r1.displayInfo();
        r2.displayInfo();
        r3.displayInfo();
    }
}