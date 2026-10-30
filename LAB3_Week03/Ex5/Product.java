package LAB3_Week03.Ex5;

public abstract class Product {
    private final String productId;
    private final String type;
    private final int volume;
    private final long price;

    public Product(String productId, String type,
                   int volume, long unitPrice) {

        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be empty.");
        }

        if (volume <= 0) {
            throw new IllegalArgumentException("Volume must be greater than 0.");
        }

        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price cannot be negative.");
        }

        this.productId = productId.trim();
        this.type = type;
        this.volume = volume;
        this.price = Math.multiplyExact((long) volume, unitPrice);
    }

    public String getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %-8s | Type: %-32s | Volume: %-5d ml | Price: %,d VND",
            productId, type, volume, price
        );
    }
}
