package LAB4_Week04.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<LibraryItem> items = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readPositiveInt("Enter the number of library items (N): ");

        // 1. Input N items of mixed types
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for item #" + (i + 1) + " ---");
            int type;
            while (true) {
                type = readPositiveInt("Select type (1 = PrintedBook, 2 = Magazine): ");
                if (type == 1 || type == 2) break;
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

            // Validate unique ID
            String id;
            while (true) {
                System.out.print("Enter unique ID: ");
                id = scanner.nextLine().trim();
                if (id.isEmpty()) {
                    System.out.println("ID cannot be empty.");
                } else if (findById(id) != null) {
                    System.out.println("Error: Duplicate ID '" + id + "'. Please enter a unique ID.");
                } else {
                    break;
                }
            }

            System.out.print("Enter title: ");
            String title = scanner.nextLine().trim();

            System.out.print("Enter author: ");
            String author = scanner.nextLine().trim();

            int days = readPositiveInt("Enter number of days borrowed (>= 1): ");

            if (type == 1) {
                int numOfPages = readPositiveInt("Enter number of pages (>= 1): ");
                items.add(new PrintedBook(id, title, author, days, numOfPages));
            } else {
                int issueNumber = readPositiveInt("Enter issue number (>= 1): ");
                items.add(new Magazine(id, title, author, days, issueNumber));
            }
        }

        // 2. Display all items & invoke calculateFee() via LibraryItem reference (Polymorphism)
        System.out.println("\n==================== BORROWED ITEMS LIST ====================");
        for (LibraryItem item : items) {
            item.displayInfo();
            // Explicitly demonstrating polymorphic calculateFee() call on LibraryItem reference
            double fee = item.calculateFee();
        }

        // 3. Statistics: Count each type, total revenue, and highest fee item
        displayStatistics();

        // 4. Search by item ID
        System.out.println("\n==================== SEARCH BY ID ====================");
        System.out.print("Enter item ID to search: ");
        String searchId = scanner.nextLine().trim();
        LibraryItem found = findById(searchId);
        if (found != null) {
            System.out.println("Item found:");
            found.displayInfo();
        } else {
            System.out.println("No item found with ID: " + searchId);
        }

        scanner.close();
    }

    // Helper: Check duplicate & search by ID (case-insensitive)
    private static LibraryItem findById(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    // Helper: Statistics calculation
    private static void displayStatistics() {
        int bookCount = 0;
        int magazineCount = 0;
        double totalRevenue = 0;
        LibraryItem highestFeeItem = null;

        for (LibraryItem item : items) {
            if (item instanceof PrintedBook) {
                bookCount++;
            } else if (item instanceof Magazine) {
                magazineCount++;
            }

            double currentFee = item.calculateFee(); // Polymorphic call
            totalRevenue += currentFee;

            if (highestFeeItem == null || currentFee > highestFeeItem.calculateFee()) {
                highestFeeItem = item;
            }
        }

        System.out.println("\n==================== SUMMARY & STATISTICS ====================");
        System.out.println("Total PrintedBooks : " + bookCount);
        System.out.println("Total Magazines    : " + magazineCount);
        System.out.printf("Total Revenue      : %,.0f VND%n", totalRevenue);

        if (highestFeeItem != null) {
            System.out.print("Highest Fee Item   : ");
            highestFeeItem.displayInfo();
        }
    }

    // Helper: Validate integer input >= 1
    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= 1) {
                    return value;
                }
                System.out.println("Error: Value must be >= 1.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }
}
