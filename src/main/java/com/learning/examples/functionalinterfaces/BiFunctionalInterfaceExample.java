package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionalInterfaceExample {

    static Predicate<Student> p1 = student -> student.getGradeLevel() > 3;

    static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> f1 = (((students, studentPredicate) -> {

        Map<String, Double> studentMap = new HashMap<>();

        students.forEach(student -> {
            if (studentPredicate.test(student)) {
                studentMap.put(student.getName(), student.getGpa());
            }
        });

        return studentMap;
    }));

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        System.out.println(f1.apply(students, p1));
    }
}
