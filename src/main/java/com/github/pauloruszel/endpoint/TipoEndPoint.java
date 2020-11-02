package com.github.pauloruszel.endpoint;

import com.github.pauloruszel.model.Tipo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemons/tipo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoEndPoint {

    @GET
    public List<Tipo> getTipos() {
        return Tipo.listAll();
    }

    @GET
    @Path("{id}")
    public Response getTipo(@PathParam("id") Long id) {
        Tipo tipo = Tipo.findById(id);
        if (tipo != null) {
            return Response.ok(tipo).status(Response.Status.OK).build();
        }
        return Response.ok(tipo).status(Response.Status.NOT_FOUND).build();
    }

}
