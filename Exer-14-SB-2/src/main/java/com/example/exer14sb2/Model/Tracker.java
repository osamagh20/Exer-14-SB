package com.example.exer14sb2.Model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {
    @NotEmpty(message = "Enter your ID")
    @Size(min = 3,message = "enter more than 2 ")
    private String id;
    private String name;
    @NotEmpty(message = "Enter the title")
    @Size(min = 9,message = "enter more than 8 ")
    private String title;
    @NotEmpty(message = "Enter the description")
    @Size(min = 16,message = "enter more than 15 ")
    private String description;
    @NotEmpty(message = "Enter the status")
    @Pattern(regexp = "^(Not Started|In Progress|Completed)$", message = "Invalid task status. Must be Not Started, In Progress, or Completed.")
    private String status;
    @NotEmpty(message = "Enter the company name")
    @Size(min = 7,message = "enter more than 6 ")
    private String companyName;

}
