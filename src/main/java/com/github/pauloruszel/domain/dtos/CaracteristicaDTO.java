package com.github.pauloruszel.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaracteristicaDTO implements BaseDTO {

    private Long id;
    private String nomeCaracteristica;
    private String altura;
    private String peso;
    private String idade;

}
