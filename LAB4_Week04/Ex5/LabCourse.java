package LAB4_Week04.Ex5;

public class LabCourse extends CourseRegistration {
    private double equipmentFeePerStudent;

    public LabCourse(String courseCode, String courseName, int credits,
                     int registeredStudents, double equipmentFeePerStudent) {
        super(courseCode, courseName, credits, registeredStudents);
        setEquipmentFeePerStudent(equipmentFeePerStudent);
    }

    public double getEquipmentFeePerStudent() {
        return equipmentFeePerStudent;
    }

    public void setEquipmentFeePerStudent(double equipmentFeePerStudent) {
        if (equipmentFeePerStudent < 0) {
            throw new IllegalArgumentException("Equipment fee must be >= 0.");
        }
        this.equipmentFeePerStudent = equipmentFeePerStudent;
    }

    @Override
    public double tuitionPerStudent() {
        return (getCredits() * 600000.0) + equipmentFeePerStudent;
    }

    @Override
    public void displayInfo() {
        System.out.print("[Lab]    ");
        super.displayInfo();
        System.out.printf(" | Equip. Fee: %,.0f VND/student%n", equipmentFeePerStudent);
    }
}