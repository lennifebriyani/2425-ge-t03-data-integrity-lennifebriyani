package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.*;

/**
 * @author 12S23023 Lenni Febriyani Hutapea
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Driver1 {
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        List<String> inputs = new ArrayList<>();
        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;
            inputs.add(input);
        }

        for (String input : inputs) {
            String[] data = input.split("#");

            switch (data[0]) {
                case "course-add":
                    if (!isCourseExists(courses, data[1])) {
                        courses.add(new Course(data[1], data[2], Integer.parseInt(data[3]), data[4].charAt(0)));
                    }
                    break;

                case "student-add":
                    if (!isStudentExists(students, data[1])) {
                        students.add(new Student(data[1], data[2], Integer.parseInt(data[3]), data[4]));
                    }
                    break;

                case "enrollment-add":
                    if (!isEnrollmentExist(enrollments, data[1], data[2], data[3], data[4])) {
                        enrollments.add(new Enrollment(data[1], data[2], data[3], data[4]));
                    }
                    break;

                default:
                    break;
            }
        }

        for (int i = courses.size() - 1; i >= 0; i--) {
            System.out.println(courses.get(i));
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        sc.close();
    }
}