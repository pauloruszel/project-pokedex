package com.github.pauloruszel.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum GeneroEnum {

    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino"),
    OUTROS("O", "Outros");

    private String chave;
    private String valor;

}
