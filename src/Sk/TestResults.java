package Sk;

import java.util.stream.*;
import java.util.*;

public class TestResults
{
    public static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
        ArrayList<String> user = new ArrayList<>();
        students.sorted(Comparator.comparing(Student::getScore).reversed()).forEach(s -> {
            String name = s.getName();
            int score = s.getScore();
            if(score >= passingScore){
                user.add(name);
            }}
        );
        return user;
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);
    }
}