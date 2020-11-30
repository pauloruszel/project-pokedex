package com.github.pauloruszel.resource.config;

import com.github.pauloruszel.domain.dtos.ResponseApiDTO;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.Response.status;

public abstract class BaseResource {

    protected Response toResponse(final Status status, final Object data) {
        final var response = new ResponseApiDTO();

        response.setCode(valueOf(status.getStatusCode()));
        response.setData(data);

        return status(status)
                .entity(response)
                .build();
    }

}
