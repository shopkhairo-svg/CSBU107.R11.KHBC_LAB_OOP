package LAB3_Week03.Ex3;

public class Staff extends Person {
    private final String licenseId;
    private final String employeeId;

    // Constructor
    public Staff(String licenseId, String employeeId,
                 String fullName, int age) {

        super(fullName, age);

        this.licenseId = requireNonBlank(
            licenseId, "License ID"
        );

        this.employeeId = requireNonBlank(
            employeeId, "Employee ID"
        );
    }

    // Getters
    public String getLicenseId() {
        return licenseId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return String.format(
            "[Staff] %s | License: %s | Employee ID: %s",
            super.toString(),
            licenseId,
            employeeId
        );
    }
}
