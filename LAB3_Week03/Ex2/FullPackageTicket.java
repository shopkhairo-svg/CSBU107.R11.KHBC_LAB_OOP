package LAB3_Week03.Ex2;

public class FullPackageTicket extends Ticket {
    public static final long FULL_PRICE = 200_000L;

    // Constructor
    public FullPackageTicket(String ticketId, String holderName,
                             int yearOfBirth, int numberOfGamesPlayed) {

        super(ticketId, holderName, yearOfBirth, numberOfGamesPlayed);
    }

    // Override method tinh gia ve
    @Override
    public long calculatePrice() {
        return FULL_PRICE;
    }

    // Override method hien thi
    @Override
    public String toString() {
        return String.format(
            "[Full Package] %s | Price: %,d VND",
            super.toString(),
            calculatePrice()
        );
    }
}
