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
@Table(name = "Categoria", schema = "pokedex")
public class Categoria extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmCategoria", length = 70)
    private String nomeCategoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "stAtivo", nullable = false)
    private SituacaoPadraoEnum ativo;

}
