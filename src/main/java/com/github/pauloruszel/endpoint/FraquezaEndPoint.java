package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.model.Fraqueza;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons/fraqueza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FraquezaEndPoint {

    @GET
    public List<Fraqueza> getFraquezas() {
        return Fraqueza.listAll();
    }

    @GET
    @Path("{id}")
    public Response getFraquezas(@PathParam("id") Long id) {
        Fraqueza fraqueza = Fraqueza.findById(id);
        if (fraqueza != null) {
            return Response.ok(fraqueza).status(Response.Status.OK).build();
        }
        return Response.ok(fraqueza).status(Response.Status.NOT_FOUND).build();
    }

}
