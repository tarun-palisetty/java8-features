package com.learning.examples.streams;

import com.learning.examples.model.Student;
import com.learning.examples.model.StudentDatabase;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static void main(String[] args) {

        List<Student> students = StudentDatabase.getAllStudents();

        System.out.println("Student activities: " + getAllStudentActivities(students));

        System.out.println("Distinct activities: " + getDistinctActivities(students));

        System.out.println("Activities count: " + getActivitiesCount(students));

        System.out.println("Sorted activities: " + sortActivities(students));

    }

    public static List<String> getAllStudentActivities(List<Student> students) {

        return students.stream()
                .map(Student::getActivities) //Stream<List<String>
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static List<String> getDistinctActivities(List<Student> students) {

        return students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static long getActivitiesCount(List<Student> students) {

        return students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    public static List<String> sortActivities(List<Student> students) {

        return students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
