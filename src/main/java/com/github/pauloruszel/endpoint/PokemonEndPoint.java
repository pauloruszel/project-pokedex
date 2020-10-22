package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.model.Pokemon;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pokemons")
public class PokemonEndPoint {

    @Inject
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemons() {
        return entityManager.createQuery("select p from Pokemon p", Pokemon.class).getResultList();
    }
}
