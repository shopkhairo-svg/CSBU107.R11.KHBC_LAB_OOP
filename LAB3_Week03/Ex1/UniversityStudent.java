package LAB3_Week03.Ex1;

public class UniversityStudent extends Student {
    public static final int MIN_CREDITS = 170;
    public static final double MIN_THESIS_SCORE = 5.0;

    private String thesisTitle;
    private double thesisScore;

    public UniversityStudent(String studentId, String fullName, String address,
                             int totalCredits, double gpa, String thesisTitle, double thesisScore) {
        super(studentId, fullName, address, totalCredits, gpa);
        setThesisTitle(thesisTitle);
        setThesisScore(thesisScore);
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = requireNonBlank(thesisTitle, "Thesis title");
    }

    public double getThesisScore() {
        return thesisScore;
    }

    public void setThesisScore(double thesisScore) {
        this.thesisScore = requireValidScore(thesisScore, "Thesis score");
    }

    @Override
    public boolean isEligibleForGraduation() {
        return getTotalCredits() >= MIN_CREDITS
                && getGpa() >= MIN_GRADUATION_GPA
                && thesisScore >= MIN_THESIS_SCORE;
    }

    @Override
    public String toString() {
        return String.format("[University] %s | Thesis: \"%s\" (%.2f) | Eligible: %s",
                super.toString(), thesisTitle, thesisScore, isEligibleForGraduation() ? "YES" : "NO");
    }
}
