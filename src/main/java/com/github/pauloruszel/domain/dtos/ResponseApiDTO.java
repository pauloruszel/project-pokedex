package com.github.pauloruszel.domain.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseApiDTO implements BaseDTO {

    private String code;
    private Object data;
    private String erro;

}
