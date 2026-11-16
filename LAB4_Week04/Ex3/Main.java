package LAB4_Week04.Ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Delivery> orders = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readPositiveInt("Enter the number of delivery orders (N >= 1): ");

        // 1. Add orders to a mixed collection
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for order #" + (i + 1) + " ---");
            int type;
            while (true) {
                type = readPositiveInt("Select delivery type (1 = Standard, 2 = Express): ");
                if (type == 1 || type == 2) break;
                System.out.println("Error: Please enter 1 or 2.");
            }

            String orderId;
            while (true) {
                System.out.print("Enter unique Order ID: ");
                orderId = scanner.nextLine().trim();
                if (orderId.isEmpty()) {
                    System.out.println("Error: Order ID cannot be empty.");
                } else if (findByOrderId(orderId) != null) {
                    System.out.println("Error: Duplicate Order ID '" + orderId + "'. Please enter a unique ID.");
                } else {
                    break;
                }
            }

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine().trim();

            double distanceKm = readStrictlyPositiveDouble("Enter delivery distance (> 0 km): ");
            double weightKg = readStrictlyPositiveDouble("Enter parcel weight (> 0 kg): ");

            if (type == 1) {
                orders.add(new StandardDelivery(orderId, customerName, distanceKm, weightKg));
            } else {
                orders.add(new ExpressDelivery(orderId, customerName, distanceKm, weightKg));
            }
        }

        // 2. Display all shipping fees
        System.out.println("\n==================== ALL DELIVERY ORDERS ====================");
        for (Delivery order : orders) {
            order.displayInfo();
        }

        // 3. Report total revenue, counts by type, and static counter
        displayStatistics();

        // 4. Filter orders whose fee exceeds a user-entered threshold
        System.out.println("\n==================== FILTER BY FEE THRESHOLD ====================");
        double threshold = readNonNegativeDouble("Enter minimum fee threshold (VND): ");
        System.out.printf("Orders with shipping fee > %,.0f VND:%n", threshold);
        boolean anyAboveThreshold = false;
        for (Delivery order : orders) {
            if (order.calculateShippingFee() > threshold) {
                order.displayInfo();
                anyAboveThreshold = true;
            }
        }
        if (!anyAboveThreshold) {
            System.out.println("No orders exceed the specified fee threshold.");
        }

        // 5. Search by order ID
        System.out.println("\n==================== SEARCH BY ORDER ID ====================");
        System.out.print("Enter Order ID to search: ");
        String searchId = scanner.nextLine().trim();
        Delivery found = findByOrderId(searchId);
        if (found != null) {
            System.out.println("Order found:");
            found.displayInfo();
        } else {
            System.out.println("No order found with ID: " + searchId);
        }

        scanner.close();
    }

    private static Delivery findByOrderId(String orderId) {
        for (Delivery order : orders) {
            if (order.getOrderId().equalsIgnoreCase(orderId)) {
                return order;
            }
        }
        return null;
    }

    private static void displayStatistics() {
        int standardCount = 0;
        int expressCount = 0;
        double totalRevenue = 0;

        for (Delivery order : orders) {
            if (order instanceof StandardDelivery) {
                standardCount++;
            } else if (order instanceof ExpressDelivery) {
                expressCount++;
            }
            totalRevenue += order.calculateShippingFee();
        }

        System.out.println("\n==================== DELIVERY SUMMARY ====================");
        System.out.println("Standard Deliveries   : " + standardCount + " orders");
        System.out.println("Express Deliveries    : " + expressCount + " orders");
        System.out.println("Total Created Objects : " + Delivery.getDeliveryCount() + " (via Delivery.getDeliveryCount())");
        System.out.printf("Total Shipping Revenue: %,.0f VND%n", totalRevenue);
    }

    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= 1) return value;
                System.out.println("Error: Value must be >= 1.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    private static double readStrictlyPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) return value;
                System.out.println("Error: Value must be strictly > 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    private static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= 0) return value;
                System.out.println("Error: Threshold must be >= 0 VND.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }
}