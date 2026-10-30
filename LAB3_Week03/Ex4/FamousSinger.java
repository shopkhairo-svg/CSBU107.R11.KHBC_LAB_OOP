package LAB3_Week03.Ex4;

public class FamousSinger extends Singer {
    public static final long BASE_SALARY = 5_000_000L;
    public static final long YEAR_RATE = 500_000L;
    public static final long ALBUM_RATE = 1_200L;
    public static final long PERFORMANCE_RATE = 500_000L;
    public static final long GAME_SHOW_RATE = 500_000L;

    private int gameShows;

    // Constructor
    public FamousSinger(String fullName, int yearsOfExperience,
                        int albumsSold, int performances,
                        int gameShows) {

        super(fullName, yearsOfExperience, albumsSold, performances);

        setGameShows(gameShows);
    }

    // Getter
    public int getGameShows() {
        return gameShows;
    }

    // Setter
    public void setGameShows(int gameShows) {
        this.gameShows =
            requireNonNegative(gameShows, "Game shows");
    }

    // Override salary calculation
    @Override
    public long calculateSalary() {

        return BASE_SALARY
                + YEAR_RATE * getYearsOfExperience()
                + ALBUM_RATE * getAlbumsSold()
                + PERFORMANCE_RATE * getPerformances()
                + GAME_SHOW_RATE * gameShows;
    }

    @Override
    public String toString() {

        return String.format(
            "[Famous] %s | Game Shows: %-3d | Salary: %,d VND",
            super.toString(),
            gameShows,
            calculateSalary()
        );
    }
}
