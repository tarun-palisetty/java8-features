package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {

    static Predicate<Student> predicate = student -> student.getGradeLevel() > 2;

    static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {

        Map<String, Double> studentGradeMap = new HashMap<>();

        students.forEach(student -> {
            if (predicate.test(student)) {
                studentGradeMap.put(student.getName(), student.getGpa());
            }
        });

        return studentGradeMap;
    });

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        System.out.println(studentFunction.apply(students));
    }
}
