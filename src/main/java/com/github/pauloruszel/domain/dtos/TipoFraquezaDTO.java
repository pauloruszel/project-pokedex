package com.github.pauloruszel.domain.dtos;

import com.github.pauloruszel.domain.enumeration.SituacaoPadraoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoFraquezaDTO implements BaseDTO {

    private Long id;
    private String nomeTipoFraqueza;
    private FraquezaDTO fraqueza;
    private SituacaoPadraoEnum ativo;

}
