package LAB4_Week04.Ex3;

public class StandardDelivery extends Delivery {

    public StandardDelivery(String orderId, String customerName, double distanceKm, double weightKg) {
        super(orderId, customerName, distanceKm, weightKg);
    }

    @Override
    public double calculateShippingFee() {
        return 15000.0 + (3000.0 * getDistanceKm()) + (2000.0 * getWeightKg());
    }

    @Override
    public String getDeliveryType() {
        return "Standard";
    }
}