package LAB4_Week04.Ex5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<CourseRegistration> courses = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readIntMin("Enter the number of courses (N >= 1): ", 1);

        // 1. Input a mixed list of courses
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for course #" + (i + 1) + " ---");
            int type;
            while (true) {
                type = readIntMin("Select course type (1 = TheoryCourse, 2 = LabCourse): ", 1);
                if (type == 1 || type == 2) break;
                System.out.println("Error: Please enter 1 or 2.");
            }

            // Validate unique Course Code
            String code;
            while (true) {
                System.out.print("Enter unique course code: ");
                code = scanner.nextLine().trim();
                if (code.isEmpty()) {
                    System.out.println("Error: Course code cannot be empty.");
                } else if (findByCourseCode(code) != null) {
                    System.out.println("Error: Duplicate course code '" + code + "'. Please enter a unique code.");
                } else {
                    break;
                }
            }

            System.out.print("Enter course name: ");
            String name = scanner.nextLine().trim();
            while (name.isEmpty()) {
                System.out.print("Course name cannot be empty. Enter course name: ");
                name = scanner.nextLine().trim();
            }

            int credits = readIntMin("Enter number of credits (>= 1): ", 1);
            int students = readIntMin("Enter number of registered students (>= 0): ", 0);

            if (type == 1) {
                courses.add(new TheoryCourse(code, name, credits, students));
            } else {
                double equipFee = readNonNegativeDouble("Enter equipment fee per student (>= 0 VND): ");
                courses.add(new LabCourse(code, name, credits, students, equipFee));
            }
        }

        // 2. Display tuition per student and expected total collected for each course
        System.out.println("\n==================== COURSE REGISTRATION & TUITION ====================");
        for (CourseRegistration course : courses) {
            course.displayInfo();
        }

        // 3. Statistics: Counts, total expected collection, largest collection, weighted average
        displayStatistics();

        // 4. Search by course code
        System.out.println("\n==================== SEARCH BY COURSE CODE ====================");
        System.out.print("Enter course code to search: ");
        String searchCode = scanner.nextLine().trim();
        CourseRegistration found = findByCourseCode(searchCode);
        if (found != null) {
            System.out.println("Course found:");
            found.displayInfo();
        } else {
            System.out.println("No course found with code: " + searchCode);
        }

        scanner.close();
    }

    // Search by course code (case-insensitive)
    private static CourseRegistration findByCourseCode(String code) {
        for (CourseRegistration c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    // Statistics calculation
    private static void displayStatistics() {
        int theoryCount = 0;
        int labCount = 0;
        int totalRegisteredStudents = 0;
        double totalExpectedCollection = 0;
        CourseRegistration largestCollectionCourse = null;

        for (CourseRegistration c : courses) {
            if (c instanceof TheoryCourse) {
                theoryCount++;
            } else if (c instanceof LabCourse) {
                labCount++;
            }

            int students = c.getRegisteredStudents();
            double collection = c.expectedTotalCollection();

            totalRegisteredStudents += students;
            totalExpectedCollection += collection;

            if (largestCollectionCourse == null
                    || collection > largestCollectionCourse.expectedTotalCollection()) {
                largestCollectionCourse = c;
            }
        }

        System.out.println("\n==================== TUITION SUMMARY & STATISTICS ====================");
        System.out.println("Theory Courses Count         : " + theoryCount);
        System.out.println("Laboratory Courses Count     : " + labCount);
        System.out.println("Total Registered Students    : " + totalRegisteredStudents);
        System.out.printf("Total Expected Collection    : %,.0f VND%n", totalExpectedCollection);

        if (totalRegisteredStudents == 0) {
            System.out.println("Weighted Avg Tuition/Student : N/A");
        } else {
            double weightedAvg = totalExpectedCollection / totalRegisteredStudents;
            System.out.printf("Weighted Avg Tuition/Student : %,.2f VND/student%n", weightedAvg);
        }

        if (largestCollectionCourse != null) {
            System.out.print("Largest Expected Collection  : ");
            largestCollectionCourse.displayInfo();
        }
    }

    // Helper: Validate integer input >= min
    private static int readIntMin(String prompt, int min) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= min) return val;
                System.out.println("Error: Value must be >= " + min + ".");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }

    // Helper: Validate double input >= 0
    private static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double val = Double.parseDouble(input);
                if (val >= 0) return val;
                System.out.println("Error: Value must be >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }
}
