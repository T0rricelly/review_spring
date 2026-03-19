package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "football_association")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FootballAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String president;


    // Relacion a muchos
    @OneToMany(targetEntity = Club.class, fetch = FetchType.LAZY, mappedBy = "footballAssociation")
    private List<Club> clubs;
}
