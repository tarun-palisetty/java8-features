package com.learning.examples.streams;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorExample {

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        System.out.println("Get students sorted by grade level: " + sortStudentsByGrade(students));
    }

    public static List<Student> sortStudentsByGrade(List<Student> students) {

        Comparator<Student> comparatorByName = Comparator.comparing(Student::getName);
        Comparator<Student> comparatorByGradeLevel = Comparator.comparing(Student::getGradeLevel);
        Comparator<Student> comparatorByGpa = Comparator.comparing(Student::getGpa);

        return students.stream()
                .sorted(comparatorByGpa)
                .collect(Collectors.toList());
    }
}
