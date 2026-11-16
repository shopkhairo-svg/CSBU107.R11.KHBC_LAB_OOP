package LAB4_Week04.Ex5;

public abstract class CourseRegistration {
    private String courseCode;
    private String courseName;
    private int credits;
    private int registeredStudents;

    public CourseRegistration(String courseCode, String courseName, int credits, int registeredStudents) {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCredits(credits);
        setRegisteredStudents(registeredStudents);
    }

    // Encapsulated Getters & Setters
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty.");
        }
        this.courseCode = courseCode.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }
        this.courseName = courseName.trim();
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 1) {
            throw new IllegalArgumentException("Credits must be >= 1.");
        }
        this.credits = credits;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        if (registeredStudents < 0) {
            throw new IllegalArgumentException("Registered students must be >= 0.");
        }
        this.registeredStudents = registeredStudents;
    }

    // Abstract method for polymorphic tuition calculation
    public abstract double tuitionPerStudent();

    // Expected total collection for this course
    public double expectedTotalCollection() {
        return tuitionPerStudent() * registeredStudents;
    }

    // Common display method
    public void displayInfo() {
        System.out.printf("Code: %-10s | Name: %-22s | Credits: %-2d | Students: %-3d | Tuition/Student: %,10.0f VND | Expected Total: %,12.0f VND",
                courseCode, courseName, credits, registeredStudents,
                tuitionPerStudent(), expectedTotalCollection());
    }
}