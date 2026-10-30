package LAB3_Week03.Ex3;

import java.util.Scanner;

public class HotelManagement {
    // Read integer safely
    public static int readInt(Scanner scanner, String message) {

        while (true) {
            try {
                System.out.print(message);

                return Integer.parseInt(
                    scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid integer. Please try again."
                );
            }
        }
    }

    // Add a guest
    public static void inputGuest(Scanner scanner, Room room) {

        try {
            System.out.print("Citizen ID: ");
            String citizenId = scanner.nextLine();

            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();

            int age = readInt(scanner, "Age: ");

            Guest guest = new Guest(citizenId, fullName, age);

            room.addGuest(guest);

            System.out.println("Guest added successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println(
                "Validation Error: " + e.getMessage()
            );
        }
    }

    // Remove a guest
    public static void removeGuestFromRoom(
            Scanner scanner, Room room) {

        System.out.print("Enter Citizen ID to remove: ");
        String citizenId = scanner.nextLine();

        boolean removed = room.removeGuest(citizenId);

        if (removed) {
            System.out.println("Guest removed successfully!");
        } else {
            System.out.println("Guest not found.");
        }
    }

    // Display menu
    public static void displayMenu() {

        System.out.println("\n========== HOTEL MENU ==========");
        System.out.println("1. Add Guest");
        System.out.println("2. Remove Guest");
        System.out.println("3. Display Guests");
        System.out.println("4. Display Room Information");
        System.out.println("5. Exit");
        System.out.println("================================");
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Staff staff = new Staff(
            "LIC001", "EMP001", "Tran Van B", 30
        );

        System.out.println("=== HOTEL ROOM RENTAL MANAGEMENT ===");
        System.out.println("Staff in charge:");
        System.out.println(staff);

        Room room = null;

        // Input valid room information
        while (room == null) {
            try {
                System.out.print("\nEnter room type (VIP1/VIP2/VIP3): ");
                String type = scanner.nextLine();

                int days = readInt(
                    scanner, "Enter rental days: "
                );

                room = new Room(type, days);

            } catch (IllegalArgumentException e) {
                System.out.println(
                    "Validation Error: " + e.getMessage()
                );
            }
        }

        System.out.println("\nRoom created successfully!");
        System.out.println(room);

        // Menu loop
        while (true) {

            displayMenu();

            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {

                case 1:
                    inputGuest(scanner, room);
                    break;

                case 2:
                    removeGuestFromRoom(scanner, room);
                    break;

                case 3:
                    room.displayGuests();
                    break;

                case 4:
                    System.out.println(room);
                    System.out.println(
                        "Number of guests: " + room.getGuests().size()
                    );
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println(
                        "Invalid choice. Please choose 1 - 5."
                    );
            }
        }
    }
}
