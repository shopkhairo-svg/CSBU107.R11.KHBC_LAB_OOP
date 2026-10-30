package LAB3_Week03.Ex4;

public class RegularSinger extends Singer {
    public static final long BASE_SALARY = 3_000_000L;
    public static final long YEAR_RATE = 500_000L;
    public static final long ALBUM_RATE = 1_000L;
    public static final long PERFORMANCE_RATE = 200_000L;

    // Constructor
    public RegularSinger(String fullName, int yearsOfExperience,
                         int albumsSold, int performances) {

        super(fullName, yearsOfExperience, albumsSold, performances);
    }

    // Override salary calculation
    @Override
    public long calculateSalary() {

        return BASE_SALARY
                + YEAR_RATE * getYearsOfExperience()
                + ALBUM_RATE * getAlbumsSold()
                + PERFORMANCE_RATE * getPerformances();
    }

    @Override
    public String toString() {

        return String.format(
            "[Regular] %s | Salary: %,d VND",
            super.toString(),
            calculateSalary()
        );
    }
}
