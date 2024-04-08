package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (student) -> student.getGpa() > 3.5;

    static BiConsumer<String, List<String>> studentListBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

    static Consumer<Student> studentConsumer = (student -> {
        if (p1.and(p2).test(student)) {
            studentListBiConsumer
                    .accept(student.getName(), student.getActivities());
        }
    });

    public static void getFilteredStudentNamesAndActivities(List<Student> students) {

        students.forEach(studentConsumer);
    }

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        getFilteredStudentNamesAndActivities(students);
    }
}
