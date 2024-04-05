package com.diamondback7ee.jpademo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {
    @Id
    private Long id;
    private String subject;
    private String code;
    private String description;
}
