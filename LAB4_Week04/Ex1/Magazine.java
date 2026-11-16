package LAB4_Week04.Ex1;

public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String id, String title, String author, int daysBorrowed, int issueNumber) {
        super(id, title, author, daysBorrowed);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber (int issueNumber) {
        if (issueNumber > 0) {
            this.issueNumber = issueNumber;
        } else {
            throw new IllegalArgumentException("Issue number must be positive");
        }
    }

    @Override
    public double calculateFee() {
        return (3000.0 * getDaysBorrowed()) + 2000.0;
    }

    @Override
    public void displayInfo() {
        System.out.printf("[Magazine]  ");
        super.displayInfo();
        System.out.printf(" | Issue: %-4d | Fee: %,.0f VND%n", issueNumber, calculateFee());
    }
}
