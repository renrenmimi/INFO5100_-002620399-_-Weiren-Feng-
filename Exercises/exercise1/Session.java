package Exercises.exercise1;

import java.util.ArrayList;
import java.util.Collections;

public class Session {
    private ArrayList<Student> students;

    public Session() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        if (this.students.size() < 20) {
            this.students.add(s);
        }
        else {
            System.out.println("Error: Maximum Capacity.");
        }
    }

    public void calculateAverageQuizScores() {
        for (Student s : this.students) {
            int total = 0;
            for (int score : s.getQuizScores()) {
                total += score;
            }
            double average = total / s.getQuizScores().size();
            System.out.println(s.getName() + " (" + s.getType() + ") - Average Quiz Score: " + average);
        }
    }

    public void printQuizScoresInOrder() {
        ArrayList<Integer> allScores = new ArrayList<>();
        for (Student s : this.students) {
            allScores.addAll(s.getQuizScores());
        }
        Collections.sort(allScores);
        System.out.println("All quiz scores in ascending order: " + allScores);
    }

    public void printPartTimeStudentNames() {
        System.out.println("Part-Time Students:");
        for (Student s : this.students) {
            if (s instanceof PartTimeStudent) {
                System.out.println(s.getName());
            }
        }
    }

    public void printExamScoresOfFullTimeStudents() {
        System.out.println("Exam Scores of Full-Time Students:");
        for (Student s : this.students) {
            if (s instanceof FullTimeStudent) {
                System.out.println(s.getName() + " - Exam Scores: " + s.getExamScores());
            }
        }
    }
}
