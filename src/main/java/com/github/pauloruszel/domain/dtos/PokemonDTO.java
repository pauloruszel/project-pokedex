package com.github.pauloruszel.domain.dtos;

import com.github.pauloruszel.domain.enumeration.GeneroEnum;

public class PokemonDTO implements BaseDTO {

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

}
