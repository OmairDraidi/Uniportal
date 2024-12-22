package servlets;

public class Course {
    private String courseId;
    private String courseName;
    private String department;
    private int creditHours;

    // Constructor
    public Course(String courseId, String courseName, String department, int creditHours) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.creditHours = creditHours;
    }

    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }
}
