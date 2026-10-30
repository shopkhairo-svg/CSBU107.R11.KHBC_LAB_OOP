package LAB3_Week03.Ex5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
    // Read integer
    public static int readInt(Scanner sc, String message, int min) {

        while (true) {
            try {
                System.out.print(message);

                int value = Integer.parseInt(sc.nextLine().trim());

                if (value < min) {
                    System.out.println("Value must be >= " + min);
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Try again.");
            }
        }
    }

    // Read a choice within a range
    public static int readChoice(Scanner sc, String message,
                                 int min, int max) {

        while (true) {
            int choice = readInt(sc, message, min);

            if (choice <= max) {
                return choice;
            }

            System.out.println(
                "Please choose between " + min + " and " + max
            );
        }
    }

    // Read non-blank String
    public static String readText(Scanner sc, String message) {

        while (true) {
            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    // Read date
    public static LocalDate readDate(Scanner sc) {

        while (true) {
            try {
                String value = readText(
                    sc, "Invoice date (yyyy-MM-dd): "
                );

                return LocalDate.parse(value);

            } catch (DateTimeParseException e) {
                System.out.println(
                    "Invalid date. Example: 2026-10-30"
                );
            }
        }
    }

    // Input customer
    public static Customer inputCustomer(Scanner sc) {

        while (true) {
            try {
                String id = readText(sc, "Customer ID: ");
                String name = readText(sc, "Full Name: ");
                String address = readText(sc, "Address: ");
                String phone = readText(sc, "Phone Number: ");

                return new Customer(id, name, address, phone);

            } catch (IllegalArgumentException e) {
                System.out.println(
                    "Customer Error: " + e.getMessage()
                );
            }
        }
    }

    // Input perfume
    public static Perfume inputPerfume(
            Scanner sc, boolean roseRequired) {

        String type;

        if (roseRequired) {
            type = Perfume.ROSE;
            System.out.println("Required product: Rose Perfume");

        } else {
            System.out.println("1. Rose Perfume");
            System.out.println("2. Chamomile Perfume");

            int choice = readChoice(
                sc, "Choose perfume: ", 1, 2
            );

            type = (choice == 1)
                ? Perfume.ROSE
                : Perfume.CHAMOMILE;
        }

        String id = readText(sc, "Product ID: ");
        int volume = readInt(sc, "Volume (ml): ", 1);

        return new Perfume(id, type, volume);
    }

    // Input shampoo
    public static Shampoo inputShampoo(
            Scanner sc, boolean oilyRequired) {

        String type;

        if (oilyRequired) {
            System.out.println("1. Oily Hair Shampoo - Standard 1");
            System.out.println("2. Oily Hair Shampoo - Standard 2");

            int choice = readChoice(
                sc, "Choose shampoo: ", 1, 2
            );

            type = (choice == 1)
                ? Shampoo.OILY_1
                : Shampoo.OILY_2;

        } else {
            System.out.println("1. Dry Hair Shampoo");
            System.out.println("2. Oily Hair Shampoo - Standard 1");
            System.out.println("3. Oily Hair Shampoo - Standard 2");

            int choice = readChoice(
                sc, "Choose shampoo: ", 1, 3
            );

            switch (choice) {
                case 1:
                    type = Shampoo.DRY;
                    break;

                case 2:
                    type = Shampoo.OILY_1;
                    break;

                default:
                    type = Shampoo.OILY_2;
            }
        }

        String id = readText(sc, "Product ID: ");
        int volume = readInt(sc, "Volume (ml): ", 1);

        return new Shampoo(id, type, volume);
    }

    // Input shower gel
    public static ShowerGel inputShowerGel(Scanner sc) {

        System.out.println("1. Dry Skin Shower Gel");
        System.out.println("2. Oily Skin Shower Gel");

        int choice = readChoice(
            sc, "Choose shower gel: ", 1, 2
        );

        String type = (choice == 1)
            ? ShowerGel.DRY_SKIN
            : ShowerGel.OILY_SKIN;

        String id = readText(sc, "Product ID: ");
        int volume = readInt(sc, "Volume (ml): ", 1);

        return new ShowerGel(id, type, volume);
    }

    // Optional product selection
    public static boolean wantOptionalProduct(
            Scanner sc, String productName) {

        int choice = readChoice(
            sc, "Add " + productName + "? (1-Yes, 0-No): ",
            0, 1
        );

        return choice == 1;
    }

    // Input product package
    public static CosmeticPackage inputPackage(Scanner sc) {

        while (true) {
            try {
                System.out.println("\n1. Romantic Package");
                System.out.println("2. Fresh-Air Package");

                int choice = readChoice(
                    sc, "Choose package: ", 1, 2
                );

                if (choice == 1) {

                    Perfume rose = inputPerfume(sc, true);

                    Shampoo shampoo = null;
                    ShowerGel showerGel = null;

                    if (wantOptionalProduct(sc, "Shampoo")) {
                        shampoo = inputShampoo(sc, false);
                    }

                    if (wantOptionalProduct(sc, "Shower Gel")) {
                        showerGel = inputShowerGel(sc);
                    }

                    return new RomanticPackage(
                        rose, shampoo, showerGel
                    );

                } else {

                    Shampoo oily = inputShampoo(sc, true);

                    Perfume perfume = null;
                    ShowerGel showerGel = null;

                    if (wantOptionalProduct(sc, "Perfume")) {
                        perfume = inputPerfume(sc, false);
                    }

                    if (wantOptionalProduct(sc, "Shower Gel")) {
                        showerGel = inputShowerGel(sc);
                    }

                    return new FreshAirPackage(
                        oily, perfume, showerGel
                    );
                }

            } catch (IllegalArgumentException e) {
                System.out.println(
                    "Package Error: " + e.getMessage()
                    + " Please re-enter this package."
                );
            }
        }
    }

    // Input N orders
    public static List<Order> inputOrders(Scanner sc) {

        List<Order> orders = new ArrayList<>();

        int n = readInt(sc, "Enter number of orders: ", 0);

        for (int i = 0; i < n; i++) {

            System.out.println(
                "\n========== ORDER #" + (i + 1) + " =========="
            );

            while (true) {
                try {
                    String orderId = readText(sc, "Order ID: ");

                    boolean duplicate = false;

                    for (Order existing : orders) {
                        if (existing.getOrderId().equals(orderId)) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println(
                            "Duplicate Order ID. Please re-enter."
                        );
                        continue;
                    }

                    Customer customer = inputCustomer(sc);
                    LocalDate date = readDate(sc);
                    CosmeticPackage productPackage = inputPackage(sc);

                    Order order = new Order(
                        orderId, customer, date, productPackage
                    );

                    orders.add(order);
                    System.out.println("Order created successfully!");
                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println(
                        "Order Error: " + e.getMessage()
                    );
                }
            }
        }

        return orders;
    }

    // Display all orders
    public static void displayOrders(List<Order> orders) {

        System.out.println("\n========== ORDER LIST ==========");

        if (orders.isEmpty()) {
            System.out.println("No orders.");
            return;
        }

        long totalRevenue = 0;

        for (Order order : orders) {
            System.out.println("\n-------------------------------");
            System.out.println(order);

            totalRevenue = Math.addExact(
                totalRevenue, order.getOrderPrice()
            );
        }

        System.out.println("\n===============================");
        System.out.println("Number of Orders: " + orders.size());

        System.out.printf(
            "Total Revenue: %,d VND%n", totalRevenue
        );
    }

    // Save order list to text file
    public static void saveOrdersToFile(
            List<Order> orders, String fileName) throws IOException {

        StringBuilder content = new StringBuilder();

        content.append("COSMETIC STORE ORDER LIST\n");
        content.append("=========================\n");

        long totalRevenue = 0;

        for (Order order : orders) {
            content.append("\n-------------------------\n");
            content.append(order.toString());
            content.append("\n");

            totalRevenue = Math.addExact(
                totalRevenue, order.getOrderPrice()
            );
        }

        content.append("\n=========================\n");
        content.append("Number of Orders: ")
               .append(orders.size())
               .append("\n");

        content.append(
            String.format("Total Revenue: %,d VND%n", totalRevenue)
        );

        Files.writeString(
            Path.of(fileName),
            content.toString(),
            StandardCharsets.UTF_8
        );
    }

    // Main
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(
            "=== COSMETIC STORE ORDER MANAGEMENT ==="
        );

        List<Order> orders = inputOrders(sc);

        // Display first, then save
        displayOrders(orders);

        try {
            saveOrdersToFile(orders, "order_list.txt");

            System.out.println(
                "\nOrders saved successfully to order_list.txt"
            );

        } catch (IOException e) {
            System.out.println(
                "File Error: " + e.getMessage()
            );
        }

        sc.close();
    }
}
