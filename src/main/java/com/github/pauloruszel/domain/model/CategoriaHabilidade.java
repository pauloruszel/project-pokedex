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
@Table(name = "CategoriaHabilidade", schema = "pokedex")
public class CategoriaHabilidade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoriaHabilidade", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmCategoriaHabilidade", length = 70)
    private String nomeCategoriaHabilidade;

    @ManyToOne
    @JoinColumn(name = "idHabilidade")
    private Habilidade habilidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "stAtivo", nullable = false)
    private SituacaoPadraoEnum ativo;

}
