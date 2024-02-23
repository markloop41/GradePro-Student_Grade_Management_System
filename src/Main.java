import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {

    // class fields
    private String name;
    private List<Integer> grades;

    // parameterized constructor
    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    // getters and setters for each Field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}

class StudentGradeManagementSystem {
    private final ArrayList<Student> students;

    public StudentGradeManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, List<Integer> grades) {
        Student student = new Student(name, grades);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("List of students and their grades:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName() + ", Grades: " + student.getGrades());
            }
        }
    }

    public void searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println("Name: " + student.getName() + ", Grades: " + student.getGrades());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void calculateAverageGrade(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                List<Integer> grades = student.getGrades();
                int sum = 0;
                for (int grade : grades) {
                    sum += grade;
                }
                double average = (double) sum / grades.size();
                System.out.println("Average grade for " + student.getName() + ": " + average);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void calculateClassAverage() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            ArrayList<Integer> allGrades = new ArrayList<>();
            for (Student student : students) {
                allGrades.addAll(student.getGrades());
            }
            int sum = 0;
            for (int grade : allGrades) {
                sum += grade;
            }
            double average = (double) sum / allGrades.size();
            System.out.println("Class average grade: " + average);
        }
    }

    public void removeStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                students.remove(student);
                System.out.println(student.getName() + " removed successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}

class Main{
    public static void main(String[] args) {
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Display all students");
            System.out.println("3. Search for a student by name");
            System.out.println("4. Calculate average grade of a student");
            System.out.println("5. Calculate class average grade");
            System.out.println("6. Remove a student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grades (comma-separated): ");
                    String gradesInput = scanner.nextLine();
                    String[] gradesArray = gradesInput.split(",");
                    List<Integer> grades = new ArrayList<>();
                    for (String grade : gradesArray) {
                        grades.add(Integer.parseInt(grade.trim()));
                    }
                    system.addStudent(name, grades);
                    break;
                case 2:
                    system.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String searchName = scanner.nextLine();
                    system.searchStudentByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    String avgName = scanner.nextLine();
                    system.calculateAverageGrade(avgName);
                    break;
                case 5:
                    system.calculateClassAverage();
                    break;
                case 6:
                    System.out.print("Enter student name: ");
                    String removeName = scanner.nextLine();
                    system.removeStudent(removeName);
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}