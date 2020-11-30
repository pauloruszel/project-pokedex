package com.github.pauloruszel.resource;

import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;
import com.github.pauloruszel.resource.config.BaseResource;
import com.github.pauloruszel.service.PokemonService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/pokemons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource extends BaseResource {

    @Inject
    PokemonService pokemonService;

    @GET
    public Response getPokemons() {
        return toResponse(Status.OK, pokemonService.findAll());
    }

    @GET
    @Path("{id:[1-9][0-9]*}")
    public Response getPokemon(@PathParam("id") @NotNull Long id) throws ParametroInvalidoException {
        final var retorno = pokemonService.getById(id);
        if (retorno != null) {
            return toResponse(Status.OK, retorno);
        }
        return toResponse(Status.NOT_FOUND, null);
    }

    @POST
    public Response addPokemon(@RequestBody @Valid PokemonDTO dto) throws ParametroInvalidoException {
        PokemonDTO retorno = pokemonService.save(dto);
        return toResponse(Status.CREATED, retorno);
    }

    @PUT
    @Path("{id:[1-9][0-9]*}")
    public Response updatePokemon(@PathParam("id") @NotNull Long id,
                                  @RequestBody @Valid PokemonDTO dto) throws ParametroInvalidoException {
        final var retorno = pokemonService.update(id, dto);
        if (retorno != null) {
            return toResponse(Status.OK, retorno);
        }
        return toResponse(Status.NOT_FOUND, null);
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    public Response deletePokemon(@PathParam("id") @NotNull Long id) throws ParametroInvalidoException {
        final var mensagemRetornoDTO = pokemonService.delete(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return toResponse(Status.OK, mensagemRetornoDTO);
        }
        return toResponse(Status.NOT_FOUND, mensagemRetornoDTO);
    }
}
