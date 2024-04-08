package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class BiPredicateExample {

    static BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.5;

    public static void getFilteredStudentsWithGradeLevelAndGpa(List<Student> students) {

        students.forEach(student -> {
            if (biPredicate.test(student.getGradeLevel(), student.getGpa())) {
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        getFilteredStudentsWithGradeLevelAndGpa(students);
    }
}
