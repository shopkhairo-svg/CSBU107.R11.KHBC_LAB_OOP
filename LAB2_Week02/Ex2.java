package LAB2_Week02;

class Fraction {
    //Attributes
    private int numerator;
    private int denominator;

    //No-argument constructor: 0/1  
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    //Parameterized constructor
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;

        if(denominator == 0) {
            this.denominator = 1;
        } else {
            this.denominator = denominator;
        }
        simplify();
    }

    //Copy constructor
    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    //Simplify
    public void simplify() {
        int a = Math.abs(numerator);
        int b = Math.abs(denominator);

        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        int gcd = (a == 0) ? 1 : a;

        numerator /= gcd;
        denominator /= gcd;

        //Keep the denominator positive
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    //add(Fraction other)
    public Fraction add(Fraction other) {
        return new Fraction(numerator * other.denominator + other.numerator * denominator, 
            denominator * other.denominator);
    }

    //subtract(Fraction other)
    public Fraction subtract(Fraction other) {
        return new Fraction(numerator * other.denominator - other.numerator * denominator,
            denominator * other.denominator);
    }

    //multiply(Fraction other)
    public Fraction multiply(Fraction other) {
        return new Fraction(numerator * other.numerator, denominator * other.denominator);
    }

    //divide(Fraction other)
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Cannot divide by a fraction equal to zero");
        }
        return new Fraction(numerator * other.denominator, denominator * other.numerator);
    }

    //display
    public void display() {
        System.out.println(numerator + "/" + denominator);
        System.out.println("----------------------");
    }
}

public class Ex2 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(3,4);

        System.out.print("f1 = ");
        f1.display();

        System.out.print("f2 = ");
        f2.display();

        Fraction sum = f1.add(f2);
        System.out.print("f1 + f2 = ");
        sum.display();

        Fraction difference = f1.subtract(f2);
        System.out.print("f1 - f2 = ");
        difference.display();

        Fraction product = f1.multiply(f2);
        System.out.print("f1 * f2 = ");
        product.display();

        Fraction quotient = f1.divide(f2);
        System.out.print("f1 / f2 = ");
        quotient.display();

        // Copy constructor
        Fraction f3 = new Fraction(f1);

        System.out.print("f3 (copy of f1) = ");
        f3.display();

        // Verify that f3 and f1 are distinct objects
        System.out.println("Same object? " + (f1 == f3));
    }
}
