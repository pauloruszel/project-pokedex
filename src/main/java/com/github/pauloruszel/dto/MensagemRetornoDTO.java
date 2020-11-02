package com.github.pauloruszel.dto;

import java.io.Serializable;
import java.util.Objects;

public class MensagemRetornoDTO implements Serializable {

    private static final long serialVersionUID = -7838190785539922891L;

    private String mensagem;

    public MensagemRetornoDTO() {
        super();
    }

    public MensagemRetornoDTO(String mensagem) {
        super();
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MensagemRetornoDTO that = (MensagemRetornoDTO) o;
        return Objects.equals(mensagem, that.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensagem);
    }
}
