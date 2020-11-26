package com.github.pauloruszel.domain.dtos;

public class MensagemRetornoDTO implements BaseDTO {

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

}
