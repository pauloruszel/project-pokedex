package com.github.pauloruszel.domain.model;

import com.github.pauloruszel.domain.enumeration.SituacaoPadraoEnum;
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
@Table(name = "Fraqueza", schema = "pokedex")
public class Fraqueza extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFraqueza", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmFraqueza", length = 70)
    private String nomeFraqueza;

    @Enumerated(EnumType.STRING)
    @Column(name = "stAtivo", nullable = false)
    private SituacaoPadraoEnum ativo;

}
