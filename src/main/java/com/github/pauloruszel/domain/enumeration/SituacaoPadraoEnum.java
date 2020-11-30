package com.github.pauloruszel.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SituacaoPadraoEnum {

    A("Ativa"),
    I("Inativa");

    private String descricao;

}
