package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.converter.PokemonConverter;
import com.github.pauloruszel.dto.PokemonDTO;
import com.github.pauloruszel.model.Pokemon;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

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

    @GET
    public List<Pokemon> getPokemons() {
        return Pokemon.listAll();
    }

    @GET
    @Path("{id}")
    public Response getPokemon(@PathParam("id") Long id) {
        Pokemon pokemonEncontrado = Pokemon.findById(id);
        if (pokemonEncontrado != null) {
            return Response.ok(pokemonEncontrado).status(Response.Status.OK).build();
        }
        return Response.ok(pokemonEncontrado).status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Transactional
    public Response addPokemon(@RequestBody @Valid PokemonDTO dto) {
        Pokemon pokemon = PokemonConverter.converter(dto);
        pokemon.persist();
        return Response.ok(pokemon).status(Response.Status.CREATED).build();
    }

    @PUT
    @Transactional
    public Response updatePokemon(@RequestBody @Valid PokemonDTO dto) {
        Pokemon pokemon = Pokemon.findById(dto.getId());
        if (pokemon != null) {
            pokemon = PokemonConverter.converter(pokemon, dto);
            return Response.ok(pokemon).status(Response.Status.OK).build();
        }
        return Response.ok(pokemon).status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id:[1-9][0-9]*}")
    @Transactional
    public Response deletePokemon(@PathParam("id") Long id) {
        Pokemon pokemon = Pokemon.findById(id);
        if (pokemon != null && pokemon.isPersistent()) {
            pokemon.delete();
            return Response.ok(pokemon).status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(pokemon).status(Response.Status.NOT_FOUND).build();
    }
}
