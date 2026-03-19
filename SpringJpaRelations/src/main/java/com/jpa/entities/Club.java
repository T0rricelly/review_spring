package com.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "club")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;



    // Relacion 1 a 1
    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_coach")
    private Coach coach;

    // Relacion Muchos a 1
    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players;

    // Relacion muchos a 1
    @ManyToOne(targetEntity = FootballAssociation.class)
    @JoinColumn(name = "id_association")
    private FootballAssociation footballAssociation;

    // Relacion muchos a muchos
    @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
    @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition"))
    private List<FootballCompetition> footballCompetitions;
}
