package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.converter.PokemonConverter;
import com.github.pauloruszel.dto.PokemonDTO;
import com.github.pauloruszel.model.Pokemon;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import javax.transaction.Transactional;
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

    @POST
    @Transactional
    public Response addPokemon(@RequestBody PokemonDTO dto) {
        Pokemon pokemon = PokemonConverter.converter(dto);
        pokemon.persist();
        return Response.ok(pokemon).status(Response.Status.CREATED).build();
    }
}
