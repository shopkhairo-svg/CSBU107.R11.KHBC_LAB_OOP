package LAB4_Week04.Ex4;

public abstract class Ticket {
    private String ticketId;
    private String movieTitle;
    private int quantity;

    public Ticket(String ticketId, String movieTitle, int quantity) {
        setTicketId(ticketId);
        setMovieTitle(movieTitle);
        setQuantity(quantity);
    }

    // Encapsulated Getters & Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        if (ticketId == null || ticketId.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket ID cannot be empty.");
        }
        this.ticketId = ticketId.trim();
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        if (movieTitle == null || movieTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty.");
        }
        this.movieTitle = movieTitle.trim();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be >= 1.");
        }
        this.quantity = quantity;
    }

    // Abstract methods for polymorphic pricing
    public abstract double getUnitPrice();

    public abstract double calculateDiscountAmount();

    public abstract double calculateTotalPrice();

    public abstract String getTicketType();

    // Common display method showing quantity, unit price, discount, and final total
    public void displayInfo() {
        System.out.printf("ID: %-8s | Type: %-7s | Movie: %-20s | Qty: %-3d | Unit: %,9.0f VND | Discount: %,9.0f VND | Total: %,10.0f VND%n",
                ticketId, getTicketType(), movieTitle, quantity,
                getUnitPrice(), calculateDiscountAmount(), calculateTotalPrice());
    }
}