package academic.model;

/**
 * 
 * @author 12S23023 Lenni Febriyani
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Course {
    private String code;
    private String name;
    private int credits;
    private char grade;

    public Course(String code, String name, int credits, char grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public char getGrade() {
        return grade;
    }
}