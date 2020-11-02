package com.github.pauloruszel.dto;

import com.github.pauloruszel.enumeration.GeneroEnum;

import java.io.Serializable;
import java.util.Objects;

public class PokemonDTO implements Serializable {

    private static final long serialVersionUID = -8311765238189347515L;

    private Long id;
    private String nomePokemon;
    private String altura;
    private String peso;
    private GeneroEnum genero;
    private String categoria;

    private FraquezaDTO fraqueza;
    private HabilidadeDTO habilidade;
    private TipoDTO tipo;

    public PokemonDTO() {
    }

    public PokemonDTO(Long id, String nomePokemon, String altura, String peso, GeneroEnum genero, String categoria) {
        this.id = id;
        this.nomePokemon = nomePokemon;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.categoria = categoria;
    }

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

    public FraquezaDTO getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(FraquezaDTO fraqueza) {
        this.fraqueza = fraqueza;
    }

    public HabilidadeDTO getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(HabilidadeDTO habilidade) {
        this.habilidade = habilidade;
    }

    public TipoDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoDTO tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDTO that = (PokemonDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nomePokemon, that.nomePokemon) &&
                Objects.equals(altura, that.altura) &&
                Objects.equals(peso, that.peso) &&
                genero == that.genero &&
                Objects.equals(categoria, that.categoria) &&
                Objects.equals(fraqueza, that.fraqueza) &&
                Objects.equals(habilidade, that.habilidade) &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePokemon, altura, peso, genero, categoria, fraqueza, habilidade, tipo);
    }
}
