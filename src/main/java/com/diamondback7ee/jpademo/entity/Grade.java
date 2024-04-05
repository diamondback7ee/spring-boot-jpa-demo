package com.diamondback7ee.jpademo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Grade {
    @Id
    private Long id;
    private String score;
}
