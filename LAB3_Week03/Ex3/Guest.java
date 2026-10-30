package LAB3_Week03.Ex3;

public class Guest extends Person {
    private final String citizenId;

    // Constructor
    public Guest(String citizenId, String fullName, int age) {

        super(fullName, age);

        this.citizenId = requireNonBlank(
            citizenId, "Citizen ID"
        );
    }

    // Getter
    public String getCitizenId() {
        return citizenId;
    }

    @Override
    public String toString() {
        return String.format(
            "[Guest] %s | CCCD: %s",
            super.toString(),
            citizenId
        );
    }
}