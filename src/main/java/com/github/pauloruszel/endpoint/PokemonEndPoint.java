package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.dto.MensagemRetornoDTO;
import com.github.pauloruszel.dto.PokemonDTO;
import com.github.pauloruszel.model.Pokemon;
import com.github.pauloruszel.service.PokemonService;
import com.github.pauloruszel.util.MensagemUtil;
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
public class PokemonEndPoint {

    @Inject
    PokemonService pokemonService;

    @GET
    public List<Pokemon> getPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GET
    @Path("{id}")
    public Response getPokemon(@PathParam("id") Long id) {
        PokemonDTO retorno = pokemonService.getPokemonById(id);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addPokemon(@RequestBody @Valid PokemonDTO dto) {
        PokemonDTO retorno = pokemonService.savePokemon(dto);
        return Response.ok(retorno).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response updatePokemon(@RequestBody @Valid PokemonDTO dto) {
        PokemonDTO retorno = pokemonService.updatePokemon(dto);
        if (retorno != null) {
            return Response.ok(retorno).status(Response.Status.OK).build();
        }
        return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    @Transactional
    public Response deletePokemon(@PathParam("id") Long id) {
        MensagemRetornoDTO mensagemRetornoDTO = pokemonService.deletePokemon(id);
        if (mensagemRetornoDTO.getMensagem().equals(MensagemUtil.MSG_REGISTRO_EXCLUIDO)) {
            return Response.ok(mensagemRetornoDTO).status(Response.Status.OK).build();
        }
        return Response.ok(mensagemRetornoDTO).status(Response.Status.NOT_FOUND).build();
    }
}
