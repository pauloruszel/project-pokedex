package com.github.pauloruszel.resource;

import com.github.pauloruszel.domain.dtos.HabilidadeDTO;
import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.model.Habilidade;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;
import com.github.pauloruszel.service.HabilidadeService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons/habilidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabilidadeResource {

    @Inject
    HabilidadeService habilidadeService;

    @GET
    public List<Habilidade> getHabilidades() {
        return habilidadeService.findAll();
    }

    @GET
    @Path("{id}")
    public Response getHabilidade(@PathParam("id") Long id) throws ParametroInvalidoException {
        HabilidadeDTO habilidade = habilidadeService.getById(id);
        if (habilidade != null) {
            return Response.ok(habilidade).status(Response.Status.OK).build();
        }
        return Response.ok(habilidade).status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addHabilidade(@RequestBody @Valid HabilidadeDTO dto) throws ParametroInvalidoException {
        HabilidadeDTO retorno = habilidadeService.save(dto);
        return Response.ok(retorno).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response updateHabilidade(@RequestBody @Valid HabilidadeDTO dto) throws ParametroInvalidoException {
        HabilidadeDTO retorno = habilidadeService.update(dto);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    @Transactional
    public Response deleteHabilidade(@PathParam("id") Long id) throws ParametroInvalidoException {
        MensagemRetornoDTO mensagemRetornoDTO = habilidadeService.delete(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return Response.ok(mensagemRetornoDTO).status(Response.Status.OK).build();
        }
        return Response.ok(mensagemRetornoDTO).status(Response.Status.NOT_FOUND).build();
    }

}
