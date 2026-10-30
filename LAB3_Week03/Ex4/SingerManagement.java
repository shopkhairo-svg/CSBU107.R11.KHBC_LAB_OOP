package LAB3_Week03.Ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingerManagement {
    // 1. Find highest-paid singer
    public static Singer findHighestPaidSinger(List<Singer> singers) {

        if (singers.isEmpty()) {
            return null;
        }

        Singer highest = singers.get(0);

        for (Singer singer : singers) {
            if (singer.calculateSalary() > highest.calculateSalary()) {
                highest = singer;
            }
        }

        return highest;
    }

    // 2. Read integer safely
    public static int readNonNegativeInt(
            Scanner scanner, String message) {

        while (true) {
            try {
                System.out.print(message);

                int value = Integer.parseInt(
                    scanner.nextLine().trim()
                );

                if (value < 0) {
                    System.out.println("Value must be >= 0.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println(
                    "Invalid integer. Please try again."
                );
            }
        }
    }

    // 3. Input singers
    public static void inputSingers(
            Scanner scanner, List<Singer> singers) {

        int n = readNonNegativeInt(
            scanner, "Enter number of singers: "
        );

        for (int i = 0; i < n; i++) {

            while (true) {
                try {
                    System.out.println(
                        "\n--- Singer #" + (i + 1) + " ---"
                    );

                    int type = readNonNegativeInt(
                        scanner,
                        "Type (1 - Regular, 2 - Famous): "
                    );

                    if (type != 1 && type != 2) {
                        System.out.println(
                            "Please choose 1 or 2."
                        );
                        continue;
                    }

                    System.out.print("Full Name: ");
                    String name = scanner.nextLine();

                    int years = readNonNegativeInt(
                        scanner, "Years of Experience: "
                    );

                    int albums = readNonNegativeInt(
                        scanner, "Albums Sold: "
                    );

                    int performances = readNonNegativeInt(
                        scanner, "Performances: "
                    );

                    Singer singer;

                    if (type == 1) {

                        singer = new RegularSinger(
                            name, years, albums, performances
                        );

                    } else {

                        int gameShows = readNonNegativeInt(
                            scanner, "Game Shows: "
                        );

                        singer = new FamousSinger(
                            name, years, albums,
                            performances, gameShows
                        );
                    }

                    singers.add(singer);

                    System.out.println(
                        "Singer added successfully!"
                    );

                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println(
                        "Validation Error: " + e.getMessage()
                    );
                }
            }
        }
    }

    // 4. Sample test cases
    public static List<Singer> createSampleSingers() {

        List<Singer> singers = new ArrayList<>();

        singers.add(new RegularSinger(
            "Trinh Tran Phuong Tuan", 3, 1000, 5
        ));

        singers.add(new FamousSinger(
            "Nguyen Thanh Tung", 5, 2000, 10, 3
        ));

        singers.add(new RegularSinger(
            "MCK", 2, 500, 3
        ));

        return singers;
    }

    // 5. Display report
    public static void displayReport(List<Singer> singers) {

        System.out.println(
            "\n========== SINGER SALARY REPORT =========="
        );

        if (singers.isEmpty()) {
            System.out.println("No singers found.");
            return;
        }

        for (Singer singer : singers) {
            System.out.println(singer);
        }

        System.out.println("------------------------------------------");

        Singer highest = findHighestPaidSinger(singers);

        System.out.println("Highest-paid Singer:");
        System.out.println(highest.getFullName());

        System.out.printf(
            "Salary: %,d VND%n",
            highest.calculateSalary()
        );

        System.out.println("==========================================");
    }

    // 6. Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Built-in test cases
        List<Singer> singers = createSampleSingers();

        System.out.println("=== SAMPLE TEST ===");
        displayReport(singers);

        // Additional user input
        System.out.print(
            "\nDo you want to input more singers? (y/n): "
        );

        String choice = scanner.nextLine().trim();

        if (choice.equalsIgnoreCase("y")) {
            inputSingers(scanner, singers);
            displayReport(singers);
        }

        scanner.close();
    }
}
