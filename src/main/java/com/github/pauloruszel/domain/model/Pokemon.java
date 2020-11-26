package com.github.pauloruszel.domain.model;

import com.github.pauloruszel.converter.GeneroConverter;
import com.github.pauloruszel.domain.enumeration.GeneroEnum;
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
public class Pokemon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPokemon", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmPokemon", length = 50)
    private String nomePokemon;

    @Column(name = "dsAltura", length = 10)
    private String altura;

    @Column(name = "dsPeso", length = 10)
    private String peso;

    @Column(name = "dsGenero", length = 1)
    @Convert(converter = GeneroConverter.class)
    private GeneroEnum genero;

    @Column(name = "dsCategoria", length = 40)
    private String categoria;

}
