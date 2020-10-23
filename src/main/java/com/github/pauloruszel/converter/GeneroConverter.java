package com.github.pauloruszel.converter;

import com.github.pauloruszel.enumeration.GeneroEnum;

import javax.persistence.AttributeConverter;

public class GeneroConverter implements AttributeConverter<GeneroEnum, String> {

    private static final String MASCULINO = "M";
    private static final String FEMININO = "F";
    private static final String OUTROS = "O";

    @Override
    public String convertToDatabaseColumn(GeneroEnum generoEnum) {
        switch (generoEnum) {
            case MASCULINO:
            case FEMININO:
            case OUTROS:
                return generoEnum.getChave();
            default:
                throw new IllegalArgumentException("Campo não suportado");
        }
    }

    @Override
    public GeneroEnum convertToEntityAttribute(String dataBaseValue) {
        switch (dataBaseValue) {
            case MASCULINO:
                return GeneroEnum.MASCULINO;
            case FEMININO:
                return GeneroEnum.FEMININO;
            case OUTROS:
                return GeneroEnum.OUTROS;
            default:
                throw new IllegalArgumentException("Campo não suportado");
        }
    }
}
