package LAB3_Week03.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Main class to execute this exercise
public class TicketManagement {
    // 1. Calculate total revenue
    public static long calculateTotalRevenue(List<Ticket> tickets) {

        long total = 0;

        for (Ticket ticket : tickets) {
            total += ticket.calculatePrice();
        }

        return total;
    }

    // 2. Count Partial Tickets
    public static int countPartialTickets(List<Ticket> tickets) {

        int count = 0;

        for (Ticket ticket : tickets) {
            if (ticket instanceof PartialTicket) {
                count++;
            }
        }

        return count;
    }

    // 3. Input tickets from console
    public static void inputTickets(
            Scanner scanner, List<Ticket> tickets) {

        int n;

        while (true) {
            try {
                System.out.print("Enter number of tickets: ");
                n = Integer.parseInt(scanner.nextLine().trim());

                if (n < 0) {
                    System.out.println("Number must be >= 0.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }

        for (int i = 0; i < n; i++) {

            while (true) {
                try {
                    System.out.println("\n--- Ticket #" + (i + 1) + " ---");

                    System.out.print(
                        "Type (1 - Full Package, 2 - Partial): "
                    );

                    int type = Integer.parseInt(
                        scanner.nextLine().trim()
                    );

                    if (type != 1 && type != 2) {
                        System.out.println("Please select 1 or 2.");
                        continue;
                    }

                    System.out.print("Ticket ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Holder Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Year of Birth: ");
                    int year = Integer.parseInt(
                        scanner.nextLine().trim()
                    );

                    System.out.print("Number of Games (0 - 30): ");
                    int games = Integer.parseInt(
                        scanner.nextLine().trim()
                    );

                    Ticket ticket;

                    if (type == 1) {
                        ticket = new FullPackageTicket(
                            id, name, year, games
                        );
                    } else {
                        ticket = new PartialTicket(
                            id, name, year, games
                        );
                    }

                    tickets.add(ticket);

                    System.out.println("Ticket added successfully!");
                    break;

                } catch (NumberFormatException e) {
                    System.out.println(
                        "Invalid number format. Re-enter this ticket."
                    );

                } catch (IllegalArgumentException e) {
                    System.out.println(
                        "Validation Error: " + e.getMessage()
                    );
                }
            }
        }
    }

    // 4. Create sample test cases
    public static List<Ticket> createSampleTickets() {

        List<Ticket> tickets = new ArrayList<>();

        tickets.add(new FullPackageTicket(
            "F001", "Tran Phan Duc Khai", 2005, 10
        ));

        tickets.add(new PartialTicket(
            "P001", "Nguyen Quang Dung", 2004, 4
        ));

        return tickets;
    }

    // 5. Display report
    public static void displayReport(List<Ticket> tickets) {

        System.out.println("\n========== TICKET LIST ==========");

        if (tickets.isEmpty()) {
            System.out.println("No tickets found.");
            return;
        }

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }

        System.out.println("---------------------------------");

        System.out.printf(
            "Total Revenue: %,d VND%n",
            calculateTotalRevenue(tickets)
        );

        System.out.println(
            "Number of Partial Tickets: "
            + countPartialTickets(tickets)
        );

        System.out.println("=================================");
    }

    // 6. Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Ticket> tickets = createSampleTickets();

        System.out.println("=== SAMPLE TEST ===");
        displayReport(tickets);

        System.out.print(
            "\nDo you want to input more tickets? (y/n): "
        );

        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("y")) {
            inputTickets(scanner, tickets);
            displayReport(tickets);
        }

        scanner.close();
    }
}
