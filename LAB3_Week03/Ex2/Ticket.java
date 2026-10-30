package LAB3_Week03.Ex2;

public abstract class Ticket {
    public static final int MAX_GAMES = 30;

    private final String ticketId;
    private String holderName;
    private int yearOfBirth;
    private int numberOfGamesPlayed;

    // Constructor
    public Ticket(String ticketId, String holderName,
                  int yearOfBirth, int numberOfGamesPlayed) {

        this.ticketId = requireNonBlank(ticketId, "Ticket ID");

        setHolderName(holderName);
        setYearOfBirth(yearOfBirth);
        setNumberOfGamesPlayed(numberOfGamesPlayed);
    }

    // Validation cho chuoi
    protected static String requireNonBlank(
            String value, String fieldName) {

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                fieldName + " cannot be empty."
            );
        }

        return value.trim();
    }

    // Validation cho nam sinh
    protected static int requireValidYear(int year) {

        int currentYear = java.time.Year.now().getValue();

        if (year < 1900 || year > currentYear) {
            throw new IllegalArgumentException(
                "Year of birth must be between 1900 and " + currentYear
            );
        }

        return year;
    }

    // Validation cho so tro choi
    protected static int requireValidGames(int games) {

        if (games < 0 || games > MAX_GAMES) {
            throw new IllegalArgumentException(
                "Number of games must be between 0 and " + MAX_GAMES
            );
        }

        return games;
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    // Setters
    public void setHolderName(String holderName) {
        this.holderName = requireNonBlank(holderName, "Holder name");
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = requireValidYear(yearOfBirth);
    }

    public void setNumberOfGamesPlayed(int games) {
        this.numberOfGamesPlayed = requireValidGames(games);
    }

    // Abstract method
    public abstract long calculatePrice();

    // Hien thi thong tin chung
    @Override
    public String toString() {
        return String.format(
            "ID: %-8s | Name: %-20s | Birth Year: %-6d | Games: %-3d",
            ticketId, holderName, yearOfBirth, numberOfGamesPlayed
        );
    }
}
