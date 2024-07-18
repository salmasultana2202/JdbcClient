package com.example.jdbcClientDemo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Integer grade;

    public StudentResponse toStudentResponse(){
        return  StudentResponse.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .grade(this.grade)
                .build();
    }
}
