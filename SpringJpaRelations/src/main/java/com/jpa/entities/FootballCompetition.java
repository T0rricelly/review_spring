package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "football_competition")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FootballCompetition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "quantity_price", nullable = false, length = 10)
    private Integer quantityPrice;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false, columnDefinition = "DATE")
    private LocalDate endtDate;
}
