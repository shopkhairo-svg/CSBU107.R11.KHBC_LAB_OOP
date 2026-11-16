package LAB4_Week04.Ex1;

public class PrintedBook extends LibraryItem {
    private int numOfPages;

    public PrintedBook(String id, String title, String author, int daysBorrowed, int numPages) {
        super(id, title, author, daysBorrowed);
        setNumOfPages(numPages);
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        if (numOfPages > 0) {
            this.numOfPages = numOfPages;
        } else {
            throw new IllegalArgumentException("Number of pages must be positive");
        }
    }

    @Override
    public double calculateFee() {
        return (5000.0 * getDaysBorrowed()) + (10.0 * numOfPages);
    }

    @Override
    public void displayInfo() {
        System.out.printf("[Printed Book] ");
        super.displayInfo();
        System.out.printf(" | Pages: %-5d | Fee: %,.0f VND%n", numOfPages, calculateFee());
    }

}
