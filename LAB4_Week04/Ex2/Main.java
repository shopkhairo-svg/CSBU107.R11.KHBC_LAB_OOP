package LAB4_Week04.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = readIntInRange("Enter the number of employees (N >= 1): ", 1, Integer.MAX_VALUE);

        // 1. Input mixed employee list
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for employee #" + (i + 1) + " ---");
            int type = readIntInRange("Select type (1 = Full-Time, 2 = Part-Time): ", 1, 2);

            String id;
            while (true) {
                System.out.print("Enter unique Employee ID: ");
                id = scanner.nextLine().trim();
                if (id.isEmpty()) {
                    System.out.println("Error: Employee ID cannot be empty.");
                } else if (findEmployee(id) != null) {
                    System.out.println("Error: Duplicate ID '" + id + "'. Please enter a unique ID.");
                } else {
                    break;
                }
            }

            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine().trim();

            System.out.print("Enter department: ");
            String department = scanner.nextLine().trim();

            if (type == 1) {
                double baseSalary = readNonNegativeDouble("Enter base salary (>= 0): ");
                double allowance = readNonNegativeDouble("Enter allowance (>= 0): ");
                int workdays = readIntInRange("Enter workdays (0 - 31): ", 0, 31);
                employees.add(new FullTimeEmployee(id, fullName, department, baseSalary, allowance, workdays));
            } else {
                double hoursWorked = readNonNegativeDouble("Enter hours worked (>= 0): ");
                double hourlyRate = readNonNegativeDouble("Enter hourly rate (>= 0): ");
                employees.add(new PartTimeEmployee(id, fullName, department, hoursWorked, hourlyRate));
            }
        }

        // 2. Display full payroll
        System.out.println("\n==================== COMPANY PAYROLL ====================");
        for (Employee emp : employees) {
            emp.displayPayroll();
        }

        // 3. Total payroll & highest salary employee
        displayStatistics();

        // 4. Filter employees by department (case-insensitive)
        System.out.println("\n==================== FILTER BY DEPARTMENT ====================");
        System.out.print("Enter department name to filter: ");
        String deptQuery = scanner.nextLine().trim();
        List<Employee> deptEmployees = findEmployeesByDepartment(deptQuery);
        if (deptEmployees.isEmpty()) {
            System.out.println("No employees found in department: " + deptQuery);
        } else {
            for (Employee emp : deptEmployees) {
                emp.displayPayroll();
            }
        }

        // 5. Overloaded search demonstration
        System.out.println("\n==================== OVERLOADED SEARCH ====================");
        // Overload 1: Search by ID
        System.out.print("Search by ID - Enter Employee ID: ");
        String searchId = scanner.nextLine().trim();
        Employee byId = findEmployee(searchId);
        if (byId != null) {
            System.out.print("Found: ");
            byId.displayPayroll();
        } else {
            System.out.println("No employee found with ID: " + searchId);
        }

        // Overload 2: Search by Name and Department
        System.out.print("\nSearch by Name & Department - Enter Full Name: ");
        String searchName = scanner.nextLine().trim();
        System.out.print("Enter Department: ");
        String searchDept = scanner.nextLine().trim();
        Employee byNameAndDept = findEmployee(searchName, searchDept);
        if (byNameAndDept != null) {
            System.out.print("Found: ");
            byNameAndDept.displayPayroll();
        } else {
            System.out.println("No employee found matching '" + searchName + "' in '" + searchDept + "'.");
        }

        scanner.close();
    }

    // Overloaded Search Method #1: Find by Employee ID
    public static Employee findEmployee(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equalsIgnoreCase(id)) {
                return emp;
            }
        }
        return null;
    }

    // Overloaded Search Method #2: Find by Full Name and Department
    public static Employee findEmployee(String name, String department) {
        for (Employee emp : employees) {
            if (emp.getFullName().equalsIgnoreCase(name)
                    && emp.getDepartment().equalsIgnoreCase(department)) {
                return emp;
            }
        }
        return null;
    }

    // Filter all employees by Department (case-insensitive)
    public static List<Employee> findEmployeesByDepartment(String department) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getDepartment().equalsIgnoreCase(department)) {
                result.add(emp);
            }
        }
        return result;
    }

    // Calculate total payroll & find employee with highest salary
    private static void displayStatistics() {
        double totalPayroll = 0;
        Employee highestPaid = null;

        for (Employee emp : employees) {
            double salary = emp.calculateSalary();
            totalPayroll += salary;
            if (highestPaid == null || salary > highestPaid.calculateSalary()) {
                highestPaid = emp;
            }
        }

        System.out.println("\n==================== PAYROLL SUMMARY ====================");
        System.out.printf("Total Company Payroll : %,.0f VND%n", totalPayroll);
        if (highestPaid != null) {
            System.out.print("Highest Paid Employee : ");
            highestPaid.displayPayroll();
        }
    }

    // Input validation helper for non-negative doubles (>= 0)
    private static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double val = Double.parseDouble(input);
                if (val >= 0) {
                    return val;
                }
                System.out.println("Error: Value must be >= 0.");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    // Input validation helper for bounded integers [min, max]
    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.println("Error: Value must be between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid integer.");
            }
        }
    }
}