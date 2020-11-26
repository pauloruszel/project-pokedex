package com.github.pauloruszel.resource;

import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.model.Pokemon;
import com.github.pauloruszel.exception.ParametroInvalidoException;
import com.github.pauloruszel.service.PokemonService;
import com.github.pauloruszel.domain.util.MensagemUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PokemonResource {

    @Inject
    PokemonService pokemonService;

    @GET
    public List<Pokemon> getPokemons() {
        return pokemonService.findAll();
    }

    @GET
    @Path("{id}")
    public Response getPokemon(@PathParam("id") Long id) throws ParametroInvalidoException {
        PokemonDTO retorno = pokemonService.getById(id);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addPokemon(@RequestBody @Valid PokemonDTO dto) throws ParametroInvalidoException {
        PokemonDTO retorno = pokemonService.save(dto);
        return Response.ok(retorno).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response updatePokemon(@RequestBody @Valid PokemonDTO dto) throws ParametroInvalidoException {
        PokemonDTO retorno = pokemonService.update(dto);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    @Transactional
    public Response deletePokemon(@PathParam("id") Long id) throws ParametroInvalidoException {
        MensagemRetornoDTO mensagemRetornoDTO = pokemonService.delete(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return Response.ok(mensagemRetornoDTO).status(Response.Status.OK).build();
        }
        return Response.ok(mensagemRetornoDTO).status(Response.Status.NOT_FOUND).build();
    }
}
