package LAB4_Week04.Ex3;


public class ExpressDelivery extends Delivery {

    public ExpressDelivery(String orderId, String customerName, double distanceKm, double weightKg) {
        super(orderId, customerName, distanceKm, weightKg);
    }

    @Override
    public double calculateShippingFee() {
        return 30000.0 + (5000.0 * getDistanceKm()) + (4000.0 * getWeightKg());
    }

    @Override
    public String getDeliveryType() {
        return "Express";
    }
}