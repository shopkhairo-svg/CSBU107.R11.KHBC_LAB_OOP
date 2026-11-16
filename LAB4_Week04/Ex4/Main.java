package LAB4_Week04.Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Ticket> tickets = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readPositiveInt("Enter the number of ticket purchases (N >= 1): ");

        // 1. Input mixed ticket purchases
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for purchase #" + (i + 1) + " ---");
            int type;
            while (true) {
                type = readPositiveInt("Select ticket type (1 = Regular, 2 = VIP): ");
                if (type == 1 || type == 2) break;
                System.out.println("Error: Please enter 1 or 2.");
            }

            // Validate unique Ticket ID
            String ticketId;
            while (true) {
                System.out.print("Enter unique Ticket ID: ");
                ticketId = scanner.nextLine().trim();
                if (ticketId.isEmpty()) {
                    System.out.println("Error: Ticket ID cannot be empty.");
                } else if (isDuplicateId(ticketId)) {
                    System.out.println("Error: Duplicate Ticket ID '" + ticketId + "'. Please enter a unique ID.");
                } else {
                    break;
                }
            }

            System.out.print("Enter movie title: ");
            String movieTitle = scanner.nextLine().trim();
            while (movieTitle.isEmpty()) {
                System.out.print("Movie title cannot be empty. Enter movie title: ");
                movieTitle = scanner.nextLine().trim();
            }

            int quantity = readPositiveInt("Enter quantity (>= 1): ");

            if (type == 1) {
                tickets.add(new RegularTicket(ticketId, movieTitle, quantity));
            } else {
                tickets.add(new VIPTicket(ticketId, movieTitle, quantity));
            }
        }

        // 2. Display all ticket purchases
        System.out.println("\n==================== ALL TICKET PURCHASES ====================");
        for (Ticket t : tickets) {
            t.displayInfo();
        }

        // 3. Calculate total revenue & find movie with highest aggregated revenue
        displayRevenueStatistics();

        // 4. Sort purchases from highest to lowest final total (Manual Selection Sort)
        System.out.println("\n==================== SORTED PURCHASES (HIGHEST TO LOWEST TOTAL) ====================");
        List<Ticket> sortedTickets = sortByTotalDescending(tickets);
        for (Ticket t : sortedTickets) {
            t.displayInfo();
        }

        // 5. Search purchases by movie title (case-insensitive)
        System.out.println("\n==================== SEARCH BY MOVIE TITLE ====================");
        System.out.print("Enter movie title to search: ");
        String searchTitle = scanner.nextLine().trim();
        searchByMovieTitle(searchTitle);

        scanner.close();
    }

    // Check duplicate Ticket ID (case-insensitive)
    private static boolean isDuplicateId(String id) {
        for (Ticket t : tickets) {
            if (t.getTicketId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // Calculate total revenue & aggregate revenue per movie title without external frameworks
    private static void displayRevenueStatistics() {
        double totalRevenue = 0;
        for (Ticket t : tickets) {
            totalRevenue += t.calculateTotalPrice();
        }

        // Parallel lists to aggregate total revenue by distinct movie title (case-insensitive)
        List<String> distinctMovies = new ArrayList<>();
        List<Double> movieRevenues = new ArrayList<>();

        for (Ticket t : tickets) {
            String title = t.getMovieTitle();
            double price = t.calculateTotalPrice();
            int foundIndex = -1;

            for (int i = 0; i < distinctMovies.size(); i++) {
                if (distinctMovies.get(i).equalsIgnoreCase(title)) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                movieRevenues.set(foundIndex, movieRevenues.get(foundIndex) + price);
            } else {
                distinctMovies.add(title);
                movieRevenues.add(price);
            }
        }

        String topMovie = "";
        double maxMovieRevenue = -1;
        for (int i = 0; i < distinctMovies.size(); i++) {
            if (movieRevenues.get(i) > maxMovieRevenue) {
                maxMovieRevenue = movieRevenues.get(i);
                topMovie = distinctMovies.get(i);
            }
        }

        System.out.println("\n==================== REVENUE SUMMARY ====================");
        System.out.printf("Total Cinema Revenue : %,.0f VND%n", totalRevenue);
        if (!distinctMovies.isEmpty()) {
            System.out.printf("Top-Grossing Movie   : %s (%,.0f VND)%n", topMovie, maxMovieRevenue);
        }
    }

    // Manual Selection Sort from highest to lowest calculateTotalPrice()
    private static List<Ticket> sortByTotalDescending(List<Ticket> originalList) {
        List<Ticket> copy = new ArrayList<>(originalList);
        int size = copy.size();

        for (int i = 0; i < size - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < size; j++) {
                if (copy.get(j).calculateTotalPrice() > copy.get(maxIdx).calculateTotalPrice()) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                Ticket temp = copy.get(i);
                copy.set(i, copy.get(maxIdx));
                copy.set(maxIdx, temp);
            }
        }
        return copy;
    }

    // Search all purchases matching a movie title (case-insensitive)
    private static void searchByMovieTitle(String movieTitle) {
        boolean found = false;
        for (Ticket t : tickets) {
            if (t.getMovieTitle().equalsIgnoreCase(movieTitle)) {
                t.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No ticket purchases found for movie: " + movieTitle);
        }
    }

    // Helper: Validate integer input >= 1
    private static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= 1) return val;
                System.out.println("Error: Value must be >= 1.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }
}