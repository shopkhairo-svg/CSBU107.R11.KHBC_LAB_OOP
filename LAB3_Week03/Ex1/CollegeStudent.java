package LAB3_Week03.Ex1;

public class CollegeStudent extends Student {
    public static final int MIN_CREDITS = 120;
    public static final double MIN_EXAM_SCORE = 5.0;

    private double graduationExamScore;

    public CollegeStudent(String studentId, String fullName, String address,
                          int totalCredits, double gpa, double graduationExamScore) {
        super(studentId, fullName, address, totalCredits, gpa);
        setGraduationExamScore(graduationExamScore);
    }

    public double getGraduationExamScore() {
        return graduationExamScore;
    }

    public void setGraduationExamScore(double graduationExamScore) {
        this.graduationExamScore = requireValidScore(graduationExamScore, "Graduation exam score");
    }

    @Override
    public boolean isEligibleForGraduation() {
        return getTotalCredits() >= MIN_CREDITS
                && getGpa() >= MIN_GRADUATION_GPA
                && graduationExamScore >= MIN_EXAM_SCORE;
    }

    @Override
    public String toString() {
        return String.format("[College]    %s | Exam Score: %.2f | Eligible: %s",
                super.toString(), graduationExamScore, isEligibleForGraduation() ? "YES" : "NO");
    }
}
