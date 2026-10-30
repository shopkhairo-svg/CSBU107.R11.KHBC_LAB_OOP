package LAB3_Week03.Ex1;

public abstract class Student {
    public static final double MIN_GRADUATION_GPA = 5.0;
    public static final double MIN_SCORE = 0.0;
    public static final double MAX_SCORE = 10.0;

    private final String studentId;
    private String fullName;
    private String address;
    private int totalCredits;
    private double gpa;

    public Student(String studentId, String fullName, String address, int totalCredits, double gpa) {
        this.studentId = requireNonBlank(studentId, "Student ID");
        setFullName(fullName);
        setAddress(address);
        setTotalCredits(totalCredits);
        setGpa(gpa);
    }

    // --- Các hàm kiểm tra dữ liệu (Validation Helpers) ---
    protected static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        return value.trim();
    }

    protected static int requireNonNegativeCredits(int credits, String fieldName) {
        if (credits < 0) {
            throw new IllegalArgumentException(fieldName + " must be >= 0.");
        }
        return credits;
    }

    protected static double requireValidScore(double score, String fieldName) {
        if (Double.isNaN(score) || score < MIN_SCORE || score > MAX_SCORE) {
            throw new IllegalArgumentException(
                fieldName + " must be between " + MIN_SCORE + " and " + MAX_SCORE + "."
            );
        }
        return score;
    }

    // --- Getters & Setters cần thiết ---
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = requireNonBlank(fullName, "Full name");
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = requireNonBlank(address, "Address");
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = requireNonNegativeCredits(totalCredits, "Total credits");
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = requireValidScore(gpa, "GPA");
    }

    // Phương thức trừu tượng để các lớp con ghi đè (Polymorphism)
    public abstract boolean isEligibleForGraduation();

    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-20s | Address: %-12s | Credits: %-3d | GPA: %.2f",
                studentId, fullName, address, totalCredits, gpa);
    }
}