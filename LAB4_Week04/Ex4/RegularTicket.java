package LAB4_Week04.Ex4;

public class RegularTicket extends Ticket {
    private static final double UNIT_PRICE = 80000.0;

    public RegularTicket(String ticketId, String movieTitle, int quantity) {
        super(ticketId, movieTitle, quantity); // Constructor chaining
    }

    @Override
    public double getUnitPrice() {
        return UNIT_PRICE;
    }

    @Override
    public double calculateDiscountAmount() {
        double subtotal = UNIT_PRICE * getQuantity();
        return (getQuantity() >= 5) ? subtotal * 0.10 : 0.0;
    }

    @Override
    public double calculateTotalPrice() {
        return (UNIT_PRICE * getQuantity()) - calculateDiscountAmount();
    }

    @Override
    public String getTicketType() {
        return "Regular";
    }
}
