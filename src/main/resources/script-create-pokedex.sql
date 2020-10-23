-- DROP TABLE IF EXISTS public.tipo;
-- DROP TABLE IF EXISTS public.habilidade;
-- DROP TABLE IF EXISTS public.fraqueza;
-- DROP TABLE IF EXISTS public.pokemon;

CREATE TABLE public.habilidade
(
    idHabilidade INT GENERATED ALWAYS AS IDENTITY,
    nmHabilidade varchar(70) null,
    PRIMARY KEY (idHabilidade)
);

CREATE TABLE public.fraqueza
(
    idFraqueza INT GENERATED ALWAYS AS IDENTITY,
    nmFraqueza varchar(70) null,
    PRIMARY KEY (idFraqueza)
);

CREATE TABLE public.tipo
(
    idTipo INT GENERATED ALWAYS AS IDENTITY,
    nmtipo varchar(70) null,
    PRIMARY KEY (idTipo)
);

CREATE TABLE public.pokemon
(
    idPokemon    INT GENERATED ALWAYS AS IDENTITY,
    idTipo       INT,
    idHabilidade INT,
    idFraqueza   INT,
    dsAltura     varchar(10),
    dsCategoria  varchar(40),
    dsGenero     varchar(1) not null,
    nmPokemon    varchar(50),
    dsPeso       varchar(10),
    PRIMARY KEY (idPokemon)
);

ALTER TABLE public.pokemon
    ADD CONSTRAINT fk_habilidade
        FOREIGN KEY (idhabilidade)
            REFERENCES public.habilidade (idhabilidade);


ALTER TABLE public.pokemon
    ADD CONSTRAINT fk_fraqueza
        FOREIGN KEY (idfraqueza)
            REFERENCES public.fraqueza (idfraqueza);

ALTER TABLE public.pokemon
    ADD CONSTRAINT fk_tipo
        FOREIGN KEY (idtipo)
            REFERENCES public.tipo (idtipo);


