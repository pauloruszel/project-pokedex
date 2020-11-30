package com.github.pauloruszel.pokemon;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class PokemonResourceTest {

    private static final String PATH_API = "/api/v1/pokemons";

    @Test
    void testPokemonEndpoint() {
        given()
                .when().get(PATH_API)
                .then()
                .statusCode(200)
                .body("code", is(String.valueOf(200)))
                .body("erro", nullValue())
                .body("data.size()", is(1))
                .body("data[0].id", notNullValue())
                .body("data[0].id", is(1))
                .body("data[0].nomePokemon", notNullValue())
                .body("data[0].nomePokemon", is("Pikachu"))
                .body("data.categoria[0].id", is(1))
                .body("data.categoria[0].ativo", notNullValue())
                .body("data.categoria[0].ativo", is("A"))
                .body("data.categoria[0].nomeCategoria", notNullValue())
                .body("data.categoria[0].nomeCategoria", is("Mouse"))
                .body("data.genero[0].id", notNullValue())
                .body("data.genero[0].id", is(1))
                .body("data.genero[0].ativo", notNullValue())
                .body("data.genero[0].ativo", is("A"))
                .body("data.genero[0].nomeGenero", notNullValue())
                .body("data.genero[0].nomeGenero", is("MASCULINO"));
    }

}
