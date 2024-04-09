package com.diamondback7ee.jpademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    @NotNull
    @NonNull
    private String name;
    @NotNull
    @NonNull
    private LocalDate birthDate;

    @JsonIgnore
    private List<Grade> grades;
}
