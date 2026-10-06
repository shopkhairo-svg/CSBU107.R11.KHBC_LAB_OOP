package LAB2_Week02;

class Circle {
    //Attributes
    private double centerX;
    private double centerY;
    private double radius;

    //Default constructor
    public Circle() {
        centerX = 0;
        centerY = 0;
        radius = 1;
    }

    //Parameterized constructor
    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;

        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
    }

    //Calculate area
    public double area() {
        return Math.PI * radius * radius;
    }

    //Calculate perimeter
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    //Check whether a point is inside or on the circle
    public boolean contains(double x, double y) {
        double dx = x - centerX;
        double dy = y - centerY;

        double distanceSquared = dx * dx + dy * dy;

        return distanceSquared <= radius * radius;
    }

     //Display circle information
    public void display() {
        System.out.println("Center: (" + centerX + ", " + centerY + ")");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

public class Ex4 {
    public static void main(String[] args) {

        //Create several Circle objects
        Circle c1 = new Circle();
        Circle c2 = new Circle(2, 3, 5);
        Circle c3 = new Circle(-2, -1, 2);

        //Display information
        System.out.println("Circle 1:");
        c1.display();

        System.out.println();

        System.out.println("Circle 2:");
        c2.display();

        System.out.println();

        System.out.println("Circle 3:");
        c3.display();

        // Test points
        System.out.println();

        System.out.println("Point (0, 0) inside Circle 1? "
                + c1.contains(0, 0));

        System.out.println("Point (1, 0) inside Circle 1? "
                + c1.contains(1, 0));

        System.out.println("Point (2, 3) inside Circle 2? "
                + c2.contains(2, 3));

        System.out.println("Point (6, 3) inside Circle 2? "
                + c2.contains(6, 3));

        System.out.println("Point (0, 0) inside Circle 3? "
                + c3.contains(0, 0));
    }
}
