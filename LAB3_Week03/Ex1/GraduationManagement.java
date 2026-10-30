package LAB3_Week03.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraduationManagement {
    // 1. Đếm số sinh viên đủ điều kiện tốt nghiệp bằng Đa hình (Polymorphism)
    public static int countEligibleStudents(List<Student> students) {
        int count = 0;
        for (Student s : students) {
            if (s.isEligibleForGraduation()) {
                count++;
            }
        }
        return count;
    }

    // 2. Tìm sinh viên hệ Đại học (UniversityStudent) có GPA cao nhất
    public static UniversityStudent findTopUniversityStudent(List<Student> students) {
        UniversityStudent topUniStudent = null;
        for (Student s : students) {
            if (s instanceof UniversityStudent) {
                UniversityStudent uniStudent = (UniversityStudent) s;
                if (topUniStudent == null || uniStudent.getGpa() > topUniStudent.getGpa()) {
                    topUniStudent = uniStudent;
                }
            }
        }
        return topUniStudent;
    }

    // 3. Nhập danh sách sinh viên từ bàn phím với kiểm tra lỗi (Validation)
    public static void inputStudentsFromConsole(Scanner scanner, List<Student> studentList) {
        System.out.print("Enter number of students to input: ");
        int n;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine().trim());
                if (n >= 0) break;
                System.out.print("Number of students must be >= 0. Re-enter: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Re-enter number of students: ");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Inputting Student #" + (i + 1) + " ---");
            while (true) {
                try {
                    System.out.print("Select program (1 - College, 2 - University): ");
                    int type = Integer.parseInt(scanner.nextLine().trim());
                    if (type != 1 && type != 2) {
                        System.out.println("Error: Please choose 1 or 2.");
                        continue;
                    }

                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Full Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Total Credits: ");
                    int credits = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("GPA (0.0 - 10.0): ");
                    double gpa = Double.parseDouble(scanner.nextLine().trim());

                    if (type == 1) {
                        System.out.print("Graduation Exam Score (0.0 - 10.0): ");
                        double examScore = Double.parseDouble(scanner.nextLine().trim());
                        studentList.add(new CollegeStudent(id, name, address, credits, gpa, examScore));
                    } else {
                        System.out.print("Thesis Title: ");
                        String thesisTitle = scanner.nextLine();
                        System.out.print("Thesis Score (0.0 - 10.0): ");
                        double thesisScore = Double.parseDouble(scanner.nextLine().trim());
                        studentList.add(new UniversityStudent(id, name, address, credits, gpa, thesisTitle, thesisScore));
                    }
                    break; // Thoát vòng lặp khi tạo đối tượng thành công
                } catch (NumberFormatException e) {
                    System.out.println("Input Error: Numeric format is invalid. Please re-enter this student.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Validation Error: " + e.getMessage() + " Please re-enter this student.");
                }
            }
        }
    }

    // 4. Bộ dữ liệu kiểm thử tự động (Normal Cases & Boundary Conditions)
    public static List<Student> createSampleTestCases() {
        List<Student> sampleList = new ArrayList<>();

        // Suggested Test 1 (Normal): College - 125 credits, GPA 6.5, Exam 7.0 -> Eligible (YES)
        sampleList.add(new CollegeStudent("C001", "Tran Phan Duc Khai", "HCMC", 125, 6.5, 7.0));

        // Suggested Test 2 (Normal): University - 165 credits, GPA 8.0, Thesis 9.0 -> Not Eligible (NO - thiếu tín chỉ)
        sampleList.add(new UniversityStudent("U001", "Tran Trung Tin", "Hanoi", 165, 8.0, "AI Chatbot", 9.0));

        // Boundary Test 3: College chạm đúng ngưỡng tối thiểu (120 tín chỉ, GPA 5.0, Exam 5.0) -> Eligible (YES)
        sampleList.add(new CollegeStudent("C002", "Le Thanh Thao", "Da Nang", 120, 5.0, 5.0));

        // Boundary Test 4: University đủ tín chỉ (170), GPA cao (8.5) nhưng điểm khóa luận sát nút dưới 5.0 (4.9) -> Not Eligible (NO)
        sampleList.add(new UniversityStudent("U002", "Pham Minh Hoa", "Can Tho", 170, 8.5, "Cloud Security", 4.9));

        // Normal Test 5: University đủ điều kiện hoàn toàn -> Eligible (YES)
        sampleList.add(new UniversityStudent("U003", "Hoang Van Thanh", "HCMC", 175, 7.8, "Microservices", 8.5));

        return sampleList;
    }

    public static void displayReport(List<Student> students) {
        System.out.println("\n================ STUDENT LIST ================");
        if (students.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }

        int eligibleCount = countEligibleStudents(students);
        System.out.println("----------------------------------------------");
        System.out.println("Total students eligible for graduation: " + eligibleCount + " / " + students.size());

        UniversityStudent topUni = findTopUniversityStudent(students);
        if (topUni != null) {
            System.out.println("University student with highest GPA: "
                    + topUni.getFullName() + " (ID: " + topUni.getStudentId() + ", GPA: " + topUni.getGpa() + ")");
        } else {
            System.out.println("No University students found in the list.");
        }
        System.out.println("==============================================\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Chạy bộ test mẫu (Suggested & Boundary cases)
        System.out.println(">>> RUNNING BUILT-IN NORMAL & BOUNDARY TEST CASES <<<");
        List<Student> testStudents = createSampleTestCases();
        displayReport(testStudents);

        // Cho phép người dùng nhập thêm từ bàn phím
        System.out.print("Do you want to input additional students from the console? (y/n): ");
        String choice = scanner.nextLine().trim();
        if (choice.equalsIgnoreCase("y")) {
            inputStudentsFromConsole(scanner, testStudents);
            displayReport(testStudents);
        }

        scanner.close();
    }
}
