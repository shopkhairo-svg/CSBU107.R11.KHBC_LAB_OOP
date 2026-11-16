package LAB4_Week04.Ex3;

public abstract class Delivery {
    private static int deliveryCount = 0;

    private String orderId;
    private String customerName;
    private double distanceKm;
    private double weightKg;

    public Delivery(String orderId, String customerName, double distanceKm, double weightKg) {
        setOrderId(orderId);
        setCustomerName(customerName);
        setDistanceKm(distanceKm);
        setWeightKg(weightKg);

        deliveryCount++;
    }

    public static int getDeliveryCount() {
        return deliveryCount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        if(orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty.");
        }
        this.orderId = orderId.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        if(customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        this.customerName = customerName.trim();
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        if(distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be >= 0 km.");
        }
        this.distanceKm = distanceKm;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(double weightKg) {
        if(weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be >= 0 kg.");
        }
        this.weightKg = weightKg;
    }

    public abstract double calculateShippingFee();
    public abstract String getDeliveryType();

    public void displayInfo() {
        System.out.printf("Order ID: %-8s | Type: %-8s | Customer: %-18s | Distance: %.2f km | Weight: %.2f kg | Fee: %,.0f VND%n", 
        getOrderId(), getDeliveryType(), getCustomerName(), getDistanceKm(), getWeightKg(), calculateShippingFee()); 
    }

}
