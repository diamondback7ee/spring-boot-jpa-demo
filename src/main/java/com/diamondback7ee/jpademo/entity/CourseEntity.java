package com.diamondback7ee.jpademo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject", nullable = false)
    @NonNull
    private String subject;

    @Column(name = "code", nullable = false)
    @NonNull
    private String code;

    @Column(name = "description", nullable = false)
    @NonNull
    private String description;

    @OneToMany(mappedBy = "courseEntity", cascade = CascadeType.ALL)
    private List<GradeEntity> gradeEntities;
}
