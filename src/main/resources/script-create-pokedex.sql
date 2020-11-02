-- DROP TABLE IF EXISTS public.pokemon;
-- DROP TABLE IF EXISTS public.tipo;
-- DROP TABLE IF EXISTS public.habilidade;
-- DROP TABLE IF EXISTS public.fraqueza;


CREATE TABLE public.habilidade
(
    idHabilidade INT GENERATED ALWAYS AS IDENTITY,
    nmHabilidade varchar(70) null,
    idPokemon    INT,
    PRIMARY KEY (idHabilidade)
);


CREATE TABLE public.fraqueza
(
    idFraqueza INT GENERATED ALWAYS AS IDENTITY,
    nmFraqueza varchar(70) null,
    idPokemon  INT,
    PRIMARY KEY (idFraqueza)
);

CREATE TABLE public.tipo
(
    idTipo    INT GENERATED ALWAYS AS IDENTITY,
    nmtipo    varchar(70) null,
    idPokemon INT,
    PRIMARY KEY (idTipo)
);

CREATE TABLE public.pokemon
(
    idPokemon   INT GENERATED ALWAYS AS IDENTITY,
    dsAltura    varchar(10),
    dsCategoria varchar(40),
    dsGenero    varchar(1) not null,
    nmPokemon   varchar(50),
    dsPeso      varchar(10),
    PRIMARY KEY (idPokemon)
);

ALTER TABLE public.habilidade
    ADD CONSTRAINT fk_pokemon_habilidade
        FOREIGN KEY (idPokemon)
            REFERENCES public.pokemon (idPokemon);


ALTER TABLE public.fraqueza
    ADD CONSTRAINT fk_pokemon_fraqueza
        FOREIGN KEY (idPokemon)
            REFERENCES public.pokemon (idPokemon);

ALTER TABLE public.tipo
    ADD CONSTRAINT fk_pokemon_tipo
        FOREIGN KEY (idPokemon)
            REFERENCES public.pokemon (idPokemon);
