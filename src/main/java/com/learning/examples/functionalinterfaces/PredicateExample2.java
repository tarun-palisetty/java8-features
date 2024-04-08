package com.learning.examples.functionalinterfaces;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample2 {

    static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (student) -> student.getGpa() > 3.5;

    public static void main(String[] args) {


        List<Student> students = StudentDatabase.getAllStudents();

        getStudentsWithGradeLevelGe3(students);
        getStudentsWithGpaGr3(students);
        getStudentsWithGradeLevelGe3AndGpaGr3(students);
    }

    public static void getStudentsWithGradeLevelGe3(List<Student> students) {
        System.out.println("--------- getStudentsWithGradeLevelGe3 -----------");
        students.forEach(student -> {
            if (p1.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void getStudentsWithGpaGr3(List<Student> students) {
        System.out.println("\n--------- getStudentsWithGpaGr3 -----------");
        students.forEach(student -> {
            if (p2.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void getStudentsWithGradeLevelGe3AndGpaGr3(List<Student> students) {
        System.out.println("\n--------- getStudentsWithGradeLevelGe3AndGpaGr3 -----------");
        students.forEach(student -> {
            if (p1.and(p2).test(student)) {
                System.out.println(student);
            }
        });
    }
}
