package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.model.Habilidade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons/habilidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabilidadeEndPoint {

    @GET
    public List<Habilidade> getHabilidades() {
        return Habilidade.listAll();
    }

    @GET
    @Path("{id}")
    public Response getHabilidade(@PathParam("id") Long id) {
        Habilidade habilidade = Habilidade.findById(id);
        if (habilidade != null) {
            return Response.ok(habilidade).status(Response.Status.OK).build();
        }
        return Response.ok(habilidade).status(Response.Status.NOT_FOUND).build();
    }

}
