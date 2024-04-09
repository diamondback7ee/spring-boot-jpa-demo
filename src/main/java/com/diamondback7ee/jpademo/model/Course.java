package com.diamondback7ee.jpademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Course {
    @NotNull
    @NonNull
    private String subject;
    @NotNull
    @NonNull
    private String code;
    @NotNull
    @NonNull
    private String description;

    @JsonIgnore
    private List<Grade> grades;
}
