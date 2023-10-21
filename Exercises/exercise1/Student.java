package Exercises.exercise1;

import java.util.ArrayList;

public abstract class Student {
    String name;
    ArrayList<Integer> quizScores;

    public Student(String n) {
        this.name = n;
        this.quizScores = new ArrayList<>(); 
    }

    public void addQuizScore(int s) {
        this.quizScores.add(s);
    }

    public ArrayList<Integer> getQuizScores() {
        return this.quizScores;
    }

    public String getName() {
        return name;
    }

    abstract public String getType();

    abstract public ArrayList<Integer> getExamScores();

}

class PartTimeStudent extends Student {
    String status;
    private ArrayList<Integer> empty;

    public PartTimeStudent(String n) {
        super(n);
        status = "Part-Time";
    }

    @Override
    public String getType() {
        return status;
    }

    @Override
    public ArrayList<Integer> getExamScores() {
        return empty;
    }
}

class FullTimeStudent extends Student {
    String status;
    private ArrayList<Integer> examScores;

    public FullTimeStudent(String n) {
        super(n);
        this.examScores = new ArrayList<>();
        status = "Full-Time";
    }

    public void addExamScore(int exam1, int exam2) {
        this.examScores.add(exam1);
        this.examScores.add(exam2);
    }

    @Override
    public ArrayList<Integer> getExamScores() {
        return this.examScores;
    }

    @Override
    public String getType() {
        return status;
    }
}