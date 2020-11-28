package com.github.pauloruszel.resource;

import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.TipoDTO;
import com.github.pauloruszel.domain.model.Tipo;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;
import com.github.pauloruszel.service.TipoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons/tipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoResource {

    @Inject
    TipoService tipoService;

    @GET
    public List<Tipo> getTipos() {
        return tipoService.findAll();
    }

    @GET
    @Path("{id}")
    public Response getTipo(@PathParam("id") Long id) throws ParametroInvalidoException {
        TipoDTO tipo = tipoService.getById(id);
        if (tipo != null) {
            return Response.ok(tipo).status(Response.Status.OK).build();
        }
        return Response.ok(tipo).status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addTipo(@RequestBody @Valid TipoDTO dto) throws ParametroInvalidoException {
        TipoDTO retorno = tipoService.save(dto);
        return Response.ok(retorno).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response updateTipo(@RequestBody @Valid TipoDTO dto) throws ParametroInvalidoException {
        TipoDTO retorno = tipoService.update(dto);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    @Transactional
    public Response deleteTipo(@PathParam("id") Long id) throws ParametroInvalidoException {
        MensagemRetornoDTO mensagemRetornoDTO = tipoService.delete(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return Response.ok(mensagemRetornoDTO).status(Response.Status.OK).build();
        }
        return Response.ok(mensagemRetornoDTO).status(Response.Status.NOT_FOUND).build();
    }

}
