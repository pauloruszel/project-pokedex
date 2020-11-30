package com.github.pauloruszel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FraquezaPokemon", schema = "pokedex")
public class FraquezaPokemon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFraquezaPokemon", length = 4, precision = 10)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idFraqueza")
    private Fraqueza fraqueza;

    @ManyToOne
    @JoinColumn(name = "idPokemon")
    private Pokemon pokemon;

}
