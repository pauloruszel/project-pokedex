package com.github.pauloruszel.resource.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api/v1")
@OpenAPIDefinition(
        info = @Info(
                description = "Realize a busca por Pokémon pelo nome ou usando o número do Pokédex Nacional.",
                title = "Projeto Pokedex",
                version = "0.0.1",
                contact = @Contact(
                        name = "Paulo Ruszel",
                        email = "paulo.ruszel.santos@gmail.com",
                        url = "https://github.com/pauloruszel"
                )
        )
)
public class ApplicationResource extends Application {
}
