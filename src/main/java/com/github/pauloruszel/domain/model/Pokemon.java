package com.github.pauloruszel.domain.model;

import com.github.pauloruszel.converter.GeneroConverter;
import com.github.pauloruszel.domain.enumeration.GeneroEnum;

import javax.persistence.*;

@Entity
public class Pokemon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPokemon", length = 4, precision = 10)
    private Long id;

    @Column(name = "nmPokemon", length = 50)
    private String nomePokemon;

    @Column(name = "dsAltura", length = 10)
    private String altura;

    @Column(name = "dsPeso", length = 10)
    private String peso;

    @Column(name = "dsGenero", length = 1)
    @Convert(converter = GeneroConverter.class)
    private GeneroEnum genero;

    @Column(name = "dsCategoria", length = 40)
    private String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
