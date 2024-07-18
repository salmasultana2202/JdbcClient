package com.example.jdbcClientDemo.domain;

import lombok.Data;

@Data
public class StudentRequest {

    private String name;
    private Integer age;
    private Integer grade;

    public Student toStudent() {
        return Student.builder()
                .name(this.name)
                .age(this.age)
                .grade(this.grade)
                .build();
    }
}
