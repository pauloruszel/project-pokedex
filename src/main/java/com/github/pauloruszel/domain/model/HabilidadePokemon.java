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
@Table(name = "HabilidadePokemon", schema = "pokedex")
public class HabilidadePokemon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHabilidadePokemon", length = 4, precision = 10)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idHabilidade", referencedColumnName = "idhabilidade")
    private Habilidade habilidade;

    @ManyToOne
    @JoinColumn(name = "idPokemon", referencedColumnName = "idpokemon")
    private Pokemon pokemon;

}
