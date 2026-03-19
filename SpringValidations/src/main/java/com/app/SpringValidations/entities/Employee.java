package com.app.SpringValidations.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private Long phone;
    private String email;
    private Byte age;
    private double height;
    private boolean married;
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_department")
    private Department department;

}
