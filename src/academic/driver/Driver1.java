package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Driver1 {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static List<Enrollment> enrollments = new ArrayList<>();
    private static List<String> invalidMessages = new ArrayList<>();

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
        courses.add(course);
    }

    private static void addStudent(String id, String name, int year, String major) {
        Student student = new Student(id, name, year, major);
        students.add(student);
    }

    private static void addEnrollment(String courseCode, String studentId, String academicYear, String semester) {
        Course course = findCourse(courseCode);
        Student student = findStudent(studentId);
        if (course == null) {
            invalidMessages.add("invalid course|" + courseCode);
        } else if (student == null) {
            invalidMessages.add("invalid student|" + studentId);
        } else {
            Enrollment enrollment = new Enrollment(course, student, academicYear, semester);
            enrollments.add(enrollment);
        }
    }

    private static Course findCourse(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private static void printData() {
        for (String message : invalidMessages) {
            System.out.println(message);
        }
        for (Course course : courses) {
            System.out.println(course.getCode() + "|" + course.getName() + "|" + course.getCredits() + "|" + course.getGrade());
        }
        for (Student student : students) {
            System.out.println(student.getId() + "|" + student.getName() + "|" + student.getYear() + "|" + student.getMajor());
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment.getCourse().getCode() + "|" + enrollment.getStudent().getId() + "|" + enrollment.getAcademicYear() + "|" + enrollment.getSemester() + "|None");
        }
    }
}