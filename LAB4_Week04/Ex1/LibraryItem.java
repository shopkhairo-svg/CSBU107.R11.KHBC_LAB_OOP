package LAB4_Week04.Ex1;

public abstract class LibraryItem {
    private String id;
    private String title;
    private String author;
    private int daysBorrowed;

    public LibraryItem(String id, String title, String author, int daysBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        setDaysBorrowed(daysBorrowed);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
            this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDaysBorrowed() {
        return daysBorrowed;
    }

    public void setDaysBorrowed(int daysBorrowed) {
        if (daysBorrowed >= 0) {
            this.daysBorrowed = daysBorrowed;
        } else {
            throw new IllegalArgumentException("Days borrowed cannot be negative");
        }
    }

    public abstract double calculateFee();
    public void displayInfo() {
        System.out.printf("ID: %-8s | Title: %-20s | Author: %-15s | Days: %-3d"
            , id, title, author, daysBorrowed);
    }
}
