package com.github.pauloruszel.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParametroInvalidoException extends Exception {

    private static final long serialVersionUID = 4890299829428933384L;

    public ParametroInvalidoException(String message) {
        super(message);
    }
}
