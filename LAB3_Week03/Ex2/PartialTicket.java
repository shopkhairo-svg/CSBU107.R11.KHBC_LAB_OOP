package LAB3_Week03.Ex2;

public class PartialTicket extends Ticket {
    public static final long ENTRANCE_FEE = 70_000L;
    public static final long PRICE_PER_GAME = 20_000L;

    // Constructor
    public PartialTicket(String ticketId, String holderName,
                         int yearOfBirth, int numberOfGamesPlayed) {

        super(ticketId, holderName, yearOfBirth, numberOfGamesPlayed);
    }

    // Override method tinh gia ve
    @Override
    public long calculatePrice() {

        return ENTRANCE_FEE + PRICE_PER_GAME * getNumberOfGamesPlayed();
    }

    // Override method hien thi
    @Override
    public String toString() {
        return String.format(
            "[Partial]      %s | Price: %,d VND",
            super.toString(),
            calculatePrice()
        );
    }
}
