package LAB3_Week03.Ex3;

public abstract class Person {
    private String fullName;
    private int age;

    // Constructor
    public Person(String fullName, int age) {
        setFullName(fullName);
        setAge(age);
    }

    // Validation for String
    protected static String requireNonBlank(
            String value, String fieldName) {

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                fieldName + " cannot be empty."
            );
        }

        return value.trim();
    }

    // Validation for age
    protected static int requireValidAge(int age) {

        if (age < 0 || age > 120) {
            throw new IllegalArgumentException(
                "Age must be between 0 and 120."
            );
        }

        return age;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = requireNonBlank(fullName, "Full name");
    }

    public void setAge(int age) {
        this.age = requireValidAge(age);
    }

    @Override
    public String toString() {
        return String.format(
            "Name: %-20s | Age: %-3d",
            fullName, age
        );
    }
}
