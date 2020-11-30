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
@Table(name = "TipoHabilidade", schema = "pokedex")
public class TipoHabilidade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoHabilidade", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmTipoHabilidade", length = 70)
    private String nomeTipoHabilidade;

    @ManyToOne
    @JoinColumn(name = "idHabilidade")
    private Habilidade habilidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "stAtivo", nullable = false)
    private SituacaoPadraoEnum ativo;

}
