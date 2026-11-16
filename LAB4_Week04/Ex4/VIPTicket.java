package LAB4_Week04.Ex4;


public class VIPTicket extends Ticket {
    private static final double UNIT_PRICE = 150000.0;

    public VIPTicket(String ticketId, String movieTitle, int quantity) {
        super(ticketId, movieTitle, quantity); // Constructor chaining
    }

    @Override
    public double getUnitPrice() {
        return UNIT_PRICE;
    }

    @Override
    public double calculateDiscountAmount() {
        double subtotal = UNIT_PRICE * getQuantity();
        return (getQuantity() >= 3) ? subtotal * 0.15 : 0.0;
    }

    @Override
    public double calculateTotalPrice() {
        return (UNIT_PRICE * getQuantity()) - calculateDiscountAmount();
    }

    @Override
    public String getTicketType() {
        return "VIP";
    }
}
