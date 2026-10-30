package LAB3_Week03.Ex4;

public abstract class Singer {
    private String fullName;
    private int yearsOfExperience;
    private int albumsSold;
    private int performances;

    // Constructor
    public Singer(String fullName, int yearsOfExperience,
                  int albumsSold, int performances) {

        setFullName(fullName);
        setYearsOfExperience(yearsOfExperience);
        setAlbumsSold(albumsSold);
        setPerformances(performances);
    }

    // Validation for String
    protected static String requireNonBlank(
            String value, String fieldName) {

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                fieldName + " cannot be empty."
            );
        }

        return value.trim();
    }

    // Validation for non-negative numbers
    protected static int requireNonNegative(
            int value, String fieldName) {

        if (value < 0) {
            throw new IllegalArgumentException(
                fieldName + " must be >= 0."
            );
        }

        return value;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getAlbumsSold() {
        return albumsSold;
    }

    public int getPerformances() {
        return performances;
    }

    // Setters
    public void setFullName(String fullName) {
        this.fullName = requireNonBlank(fullName, "Full name");
    }

    public void setYearsOfExperience(int years) {
        this.yearsOfExperience =
            requireNonNegative(years, "Years of experience");
    }

    public void setAlbumsSold(int albums) {
        this.albumsSold =
            requireNonNegative(albums, "Albums sold");
    }

    public void setPerformances(int performances) {
        this.performances =
            requireNonNegative(performances, "Performances");
    }

    // Abstract method
    public abstract long calculateSalary();

    // Display common information
    @Override
    public String toString() {
        return String.format(
            "Name: %-20s | Years: %-3d | Albums: %-6d | Performances: %-4d",
            fullName, yearsOfExperience, albumsSold, performances
        );
    }
}
