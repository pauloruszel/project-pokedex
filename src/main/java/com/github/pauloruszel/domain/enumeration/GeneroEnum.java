package com.github.pauloruszel.domain.enumeration;

public enum GeneroEnum {

    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino"),
    OUTROS("O", "Outros");

    private String chave;
    private String valor;

    GeneroEnum(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return valor;
    }
}
