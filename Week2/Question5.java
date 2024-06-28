public class Student {
    // Private fields
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        setGrade(grade); // Using setter to initialize with validation
    }

    // Public getters and setters with validation (if required)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Grade must be between 0 and 100.");
        }
    }

    public static void main(String[] args) {
        Student student = new Student("John", 95);

        // Using getter and setter methods
        System.out.println("Name: " + student.getName());
        System.out.println("Grade: " + student.getGrade());

        student.setName("Wick");
        student.setGrade(98);

        System.out.println("Updated Name: " + student.getName());
        System.out.println("Updated Grade: " + student.getGrade());

        // Setting an invalid grade
        student.setGrade(105); // This will print an error message
    }
}
