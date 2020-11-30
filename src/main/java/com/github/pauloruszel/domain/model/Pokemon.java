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
@Table(name = "Pokemon", schema = "pokedex")
public class Pokemon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPokemon", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmPokemon", length = 50)
    private String nomePokemon;

    @OneToOne
    @JoinColumn(name = "idGenero")
    private Genero genero;

    @OneToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

}
