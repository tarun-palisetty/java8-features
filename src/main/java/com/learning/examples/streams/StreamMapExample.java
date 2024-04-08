package com.learning.examples.streams;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        List<String> studentNames =
                students.stream()
                .map(Student::getName)
                        .collect(Collectors.toList());
        System.out.println("Student names: " + studentNames);

        Set<String> studentNamesInUppercase =
                students.stream()
                .map(Student::getName)
                        .map(String::toUpperCase)
                        .collect(Collectors.toSet());
        System.out.println("Set of student names: " + studentNamesInUppercase);
    }
}
