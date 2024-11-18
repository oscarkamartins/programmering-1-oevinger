package studentClass;

public class Student {
    private String name;
    private int exerciseCount;

    public Student(String name, int exerciseCount) {
        this.name = name;
        this.exerciseCount = exerciseCount;
    }

    public String getName() {
        return name;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public void increaseExerciseCount(int increase) {
        this.exerciseCount += increase;
    }

    public String toString() {
        String string = "Name: " + name + "\nExercise count: " + exerciseCount + "\n";
        return string;
    }
}