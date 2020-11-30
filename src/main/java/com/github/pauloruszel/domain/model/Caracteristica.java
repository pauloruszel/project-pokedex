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
@Table(name = "Caracteristica", schema = "pokedex")
public class Caracteristica extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCaracteristica", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmCaracteristica", length = 70)
    private String nomeCaracteristica;

    @Column(name = "dsAltura", length = 10)
    private String altura;

    @Column(name = "dsPeso", length = 10)
    private String peso;

    @Column(name = "dsIdade", length = 10)
    private String idade;

    @OneToOne
    @JoinColumn(name = "idPokemon", referencedColumnName = "idpokemon")
    private Pokemon pokemon;

}
