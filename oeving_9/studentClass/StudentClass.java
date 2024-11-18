package studentClass;

import java.util.HashMap;
import java.util.Scanner;

public class StudentClass {
    private HashMap<String, Student> students;
    private int studentCount = 0;

    public StudentClass(String[] studentNames) {
        HashMap<String, Student> students = new HashMap<String, Student>();

        for (String studentName : studentNames) {
            students.put(studentName, new Student(studentName, 0));
            studentCount += 1;
        }

        this.students = students;
    }

    public HashMap<String, Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public int getExerciseCount(String student) {
        if (getStudents().containsKey(student)) {
            return getStudents().get(student).getExerciseCount();
        } else {
            return 0;
        }
    }

    public void addStudent(String name) {
        students.put(name, new Student(name, 0));
    }

    public void increaseStudent(String student) {
        if (getStudents().containsKey(student)) {
            students.put(student, new Student(student, getStudents().get(student).getExerciseCount() + 1));
        }
    }

    public String toString() {
        String string = "";

        for (Student student : getStudents().values()) {
            string += student.toString() + "\n";
        }

        return string;
    }

    public static void main(String[] args) {
        String[] studentNames = { "Oscar", "Ali", "Michelle" };
        StudentClass studentClass = new StudentClass(studentNames);
        System.out.printf(studentClass.toString());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pick an option");
            System.out.println("1. Get number of students");
            System.out.println("2. Check exercise count for student");
            System.out.println("3. Add student");
            System.out.println("4. Increase exercise count for student");
            System.out.println("5. View class");
            System.out.println("6. Quit");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println(studentClass.getStudentCount());
            } else if (option.equals("2")) {
                System.out.println("Name of student:");
                String name = scanner.nextLine();
                System.out.println(studentClass.getExerciseCount(name));
            } else if (option.equals("3")) {
                System.out.println("Name of student:");
                String name = scanner.nextLine();
                studentClass.addStudent(name);
            } else if (option.equals("4")) {
                System.out.println("Name of student:");
                String name = scanner.nextLine();
                studentClass.increaseStudent(name);
            } else if (option.equals("5")) {
                System.out.println(studentClass);
            } else if (option.equals("6")) {
                break;
            } else {
                System.out.println("Pick a valid option");
            }
        }
        scanner.close();
    }
}
