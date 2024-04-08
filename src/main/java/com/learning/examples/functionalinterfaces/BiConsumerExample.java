package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        printStudentNamesAndActivities();

    }

    public static void printStudentNamesAndActivities() {

        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println("Name: " + name + " Activities: " + activities);

        List<Student> students = StudentDatabase.getAllStudents();

        students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));

    }
}
