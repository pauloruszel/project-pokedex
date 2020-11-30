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
@Table(name = "TipoFraqueza", schema = "pokedex")
public class TipoFraqueza extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoFraqueza", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmTipoFraqueza", length = 70)
    private String nomeTipoFraqueza;

    @ManyToOne
    @JoinColumn(name = "idFraqueza")
    private Fraqueza fraqueza;

    @Enumerated(EnumType.STRING)
    @Column(name = "stAtivo", nullable = false)
    private SituacaoPadraoEnum ativo;

}
