package com.github.pauloruszel.domain.dtos;

import com.github.pauloruszel.domain.enumeration.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO implements BaseDTO {

    private Long id;
    private String nomePokemon;
    private String altura;
    private String peso;
    private GeneroEnum genero;
    private String categoria;

    private FraquezaDTO fraqueza;
    private HabilidadeDTO habilidade;
    private TipoDTO tipo;

}
