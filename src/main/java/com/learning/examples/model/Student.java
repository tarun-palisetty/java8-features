package com.learning.examples.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private int age;
    private List<String> activities;
}
