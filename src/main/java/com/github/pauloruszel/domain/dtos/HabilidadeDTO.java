package com.github.pauloruszel.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabilidadeDTO implements BaseDTO {

    private Long id;
    private String nomeHabilidade;
    private PokemonDTO pokemonDTO;

}
