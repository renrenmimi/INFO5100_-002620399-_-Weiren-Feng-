package Exercises.exercise1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            Student s;
            if (i % 2 == 0) {
                s = new FullTimeStudent("Student " + i);
                ((FullTimeStudent)s).addExamScore(r.nextInt(100), r.nextInt(100));
            } else {
                s = new PartTimeStudent("Student " + i);
            }

            for (int j = 0; j < 15; j++) {
                s.addQuizScore(r.nextInt(100)); 
            }
            session.addStudent(s);
        }
        session.calculateAverageQuizScores();
        session.printQuizScoresInOrder();
        session.printPartTimeStudentNames();
        session.printExamScoresOfFullTimeStudents();
    }
}
