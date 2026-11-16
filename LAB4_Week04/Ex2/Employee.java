package LAB4_Week04.Ex2;

public abstract class Employee {
    private String id;
    private String fullName;
    private String department;

    public Employee(String id, String fullName, String department) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract double calculateSalary();
    public abstract String getEmploymentType();

    public void displayPayroll() {
    System.out.printf("ID: %-8s | Type: %-10s | Name: %-20s | Dept: %-12s | Salary: %,.0f VND%n",
            id, getEmploymentType(), fullName, department, calculateSalary());
}
}
