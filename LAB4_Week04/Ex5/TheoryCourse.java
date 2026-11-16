package LAB4_Week04.Ex5;


public class TheoryCourse extends CourseRegistration {

    public TheoryCourse(String courseCode, String courseName, int credits, int registeredStudents) {
        super(courseCode, courseName, credits, registeredStudents);
    }

    @Override
    public double tuitionPerStudent() {
        return getCredits() * 450000.0;
    }

    @Override
    public void displayInfo() {
        System.out.print("[Theory] ");
        super.displayInfo();
        System.out.println();
    }
}
