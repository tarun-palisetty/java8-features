package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {

    static Consumer<String> c = (s) -> System.out.println(s.toUpperCase());
    static Consumer<Student> c1 = (student) -> System.out.println(student);
    static Consumer<Student> c2 = (student) -> System.out.println(student.getName());
    static Consumer<Student> c3 = (student) -> System.out.println(student.getActivities());

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        // Print all student details.
        printAllStudents(students);

        // Print only student names and activities
        printStudentNamesAndActivities(students);

        // Print all students whose gpa is >= 3.5
        printStudentsWithGpaGe35(students);

        // Consumer chaining
        System.out.println("\n------- Consumer chaining --------");
        c.accept("consumer_chaining");
        students.forEach(student -> {
            c2.andThen(c3).accept(student);
        });
    }

    private static void printStudentsWithGpaGe35(List<Student> students) {
        System.out.println("\n------- Print all students whose gpa is >= 3.5 --------");
        students.forEach(student -> {
            if (student.getGpa() >= 3.5) {
                c2.andThen(c3).accept(student);
            }
        });
    }

    private static void printAllStudents(List<Student> students) {
        System.out.println("\n------- Print all student details --------");
        students.forEach(student -> c1.accept(student));
    }

    private static void printStudentNamesAndActivities(List<Student> students) {
        System.out.println("\n------- Print all student names and activities --------");
        students.forEach(student -> {
            c2.andThen(c3).accept(student);
        });
    }
}
