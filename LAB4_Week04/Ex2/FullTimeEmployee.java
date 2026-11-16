package LAB4_Week04.Ex2;

public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double allowance;
    private int workdays;

    public FullTimeEmployee(String id, String fullName, String department, double baseSalary, double allowance, int workdays) {
        super(id, fullName, department);
        setBaseSalary(baseSalary);
        setAllowance(allowance);
        setWorkdays(workdays);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary < 0) {
            throw new IllegalArgumentException("Base salary must be >= 0.");
        }
        this.baseSalary = baseSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        if(allowance < 0) {
            throw new IllegalArgumentException("Allowance must be >= 0.");
        }
        this.allowance = allowance;
    }

    public int getWorkdays() {
        return workdays;
    }

    public void setWorkdays(int workdays) {
        if(workdays < 0 || workdays > 31) {
            throw new IllegalArgumentException("Workdays must be between 0 and 31.");
        }
        this.workdays = workdays;
    }

    @Override
    public double calculateSalary() {
        int effectiveDays = Math.min(workdays, 26);
        return (baseSalary * effectiveDays / 26) + allowance; 
    }

    @Override
    public String getEmploymentType() {
        return "Full-Time";
    }
    
}
