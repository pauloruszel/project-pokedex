package com.github.pauloruszel.resource;

import com.github.pauloruszel.domain.dtos.FraquezaDTO;
import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.model.Fraqueza;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;
import com.github.pauloruszel.service.FraquezaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons/fraqueza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FraquezaResource {

    @Inject
    FraquezaService fraquezaService;

    @GET
    public List<Fraqueza> getFraquezas() {
        return fraquezaService.findAll();
    }

    @GET
    @Path("{id}")
    public Response getFraqueza(@PathParam("id") Long id) throws ParametroInvalidoException {
        FraquezaDTO fraqueza = fraquezaService.getById(id);
        if (fraqueza != null) {
            return Response.ok(fraqueza).status(Response.Status.OK).build();
        }
        return Response.ok(fraqueza).status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addFraqueza(@RequestBody @Valid FraquezaDTO dto) throws ParametroInvalidoException {
        FraquezaDTO retorno = fraquezaService.save(dto);
        return Response.ok(retorno).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response updateFraqueza(@RequestBody @Valid FraquezaDTO dto) throws ParametroInvalidoException {
        FraquezaDTO retorno = fraquezaService.update(dto);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    @Transactional
    public Response deleteFraqueza(@PathParam("id") Long id) throws ParametroInvalidoException {
        MensagemRetornoDTO mensagemRetornoDTO = fraquezaService.delete(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return Response.ok(mensagemRetornoDTO).status(Response.Status.OK).build();
        }
        return Response.ok(mensagemRetornoDTO).status(Response.Status.NOT_FOUND).build();
    }


}
