package LAB2_Week02;

class UITStudent {
    private String studentId;
    private String fullName;
    private String major;
    private double GPA;

    //Costructor 1: no arguments
    public UITStudent () {
        this("Unknown", "Unknown", "Undeclared", 0.0);
    }

    //Constructor 2: studentId + fullName
    public UITStudent (String studentId, String fullName) {
        this(studentId, fullName, "Undeclared", 0.0);
    }

    //Constructor 3: All attributes
    public UITStudent (String studentId, String fullName, 
                        String major, double GPA) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.major = major;
        this.GPA = GPA;
    }

    //Display info student
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Full name: " + fullName);
        System.out.println("Major: " + major);
        System.out.printf("GPA: %.2f%n ", GPA);
        System.out.println("Passed: " + isPassed());
        System.out.println("Classification: "
                + academicClassification());
        System.out.println("------------------------");
    }

    //Check student passed
    public boolean isPassed () {
        return GPA >= 5.0;
    }

    //Determine academic classification
    public String academicClassification () {
        if (GPA < 0.0 || GPA > 10.0) {
            return "Invalid GPA";
        } else if (GPA < 5.0) {
            return "Fail";
        } else if (GPA < 7.0) {
            return "Average";
        } else if (GPA < 8.0) {
            return "Good";
        } else if (GPA < 9.0) {
            return "Very Good";
        } else {
            return "Exellent";
        }
    }
}

public class Ex7 {
    public static void main(String[] args) {

        // Student 1: No-argument constructor
        UITStudent student1 = new UITStudent();

        // Student 2: Constructor with studentId and fullName
        UITStudent student2 =
                new UITStudent("24560081", "Tran Van Cuong");

        // Student 3: Constructor with all attributes
        UITStudent student3 =
                new UITStudent("24560082", "Lam Tuan Minh",
                        "Computer Science", 8.5);

        // Student 4: Constructor with all attributes
        UITStudent student4 =
                new UITStudent("24560083", "Nguyen Cong Tri",
                        "Information Systems", 6.5);

        // Student 5: Constructor with all attributes
        UITStudent student5 =
                new UITStudent("24560084", "Pham Van Dong",
                        "Data Science", 4.0);

        // Display information
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        student4.displayInfo();
        student5.displayInfo();
    }
}
