import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @autor 12S23023 Lenni Febriyani
 * @autor 12S23045 Chintya Reginauli Rajagukguk
 */

public class Driver1 {
    private static Map<String, Course> courses = new HashMap<>();
    private static Map<String, Student> students = new HashMap<>();
    private static Map<String, Enrollment> enrollments = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }
            processInput(input);
        }
        scanner.close();
        printData();
    }

    private static void processInput(String input) {
        String[] parts = input.split("#");
        switch (parts[0]) {
            case "course-add":
                addCourse(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4].charAt(0));
                break;
            case "student-add":
                addStudent(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                break;
            case "enrollment-add":
                addEnrollment(parts[1], parts[2], parts[3], parts[4]);
                break; 
        }
    }
    private static void addCourse(String code, String name, int credits, char grade) {
        Course course = new Course(code, name, credits, grade);
        courses.put(code, course);
    }

    private static void addStudent(String id, String name, int year, String major) {
        Student student = new Student(id, name, year, major);
        students.put(id, student);
    }

    private static void addEnrollment(String courseCode, String studentId, String academicYear, String semester) {
        Course course = courses.get(courseCode);
        Student student = students.get(studentId);
            Enrollment enrollment = new Enrollment(course, student, academicYear, semester);
            enrollments.put(courseCode + "-" + studentId, enrollment);
    }

    private static void printData() {
        for (Course course : courses.values()) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getGrade());
        }
        for (Student student : students.values()) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor());
        }
        for (Enrollment enrollment : enrollments.values()) {
            System.out.println(enrollment.getCourse().getCode() + "|" + enrollment.getStudent().getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|None");
        }
    }
}