package com.example.exer14sb.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {
    @NotEmpty(message = "Enter the ID")
    @Size(min = 3,message = "enter more than 2 ")
    private String id;
    private String name;
    @NotEmpty(message = "Enter the description")
    @Size(min = 16,message = "enter more than 15 ")
    private String description;
    @NotNull(message = "Enter number")
    @Positive
    @Min(25)
    private int capacity;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDate;
}
