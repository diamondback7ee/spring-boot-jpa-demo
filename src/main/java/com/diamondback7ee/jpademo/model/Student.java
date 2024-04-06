package com.diamondback7ee.jpademo.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NotNull
    private String name;
    @NotNull
    private LocalDate birthDate;
}
