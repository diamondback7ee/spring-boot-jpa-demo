package com.diamondback7ee.jpademo.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    @NotNull
    private String name;
    @NotNull
    private LocalDate birthDate;
}
