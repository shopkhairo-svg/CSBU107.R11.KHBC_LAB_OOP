package LAB4_Week04.Ex2;

public class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String fullName, String department, double    hoursWorked, double hourlyRate) {
        super(id, fullName, department);
        setHoursWorked(hoursWorked);
        setHourlyRate(hourlyRate);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if(hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked must be >= 0.");
        }
        this.hoursWorked = hoursWorked;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if(hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate must be >= 0.");
        }
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getEmploymentType() {
        return "Part-Time";
    }
}
