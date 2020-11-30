--- Caracteristicas
INSERT INTO pokedex.categoria (stativo, nmcategoria) VALUES('', '');
INSERT INTO pokedex.genero (stativo, nmgenero) VALUES('', '');
INSERT INTO pokedex.pokemon (nmpokemon, idcategoria, idgenero) VALUES('', 0, 0);
INSERT INTO pokedex.caracteristica (dsaltura, dsidade, nmcaracteristica, dspeso, idpokemon) VALUES('', '', '', '', 0);

--- Atributos
INSERT INTO pokedex.fraqueza (stativo, nmfraqueza) VALUES('', '');
INSERT INTO pokedex.fraquezapokemon (idfraqueza, idpokemon) VALUES(0, 0);
INSERT INTO pokedex.habilidade (stativo, nmhabilidade) VALUES('', '');
INSERT INTO pokedex.habilidadepokemon (idhabilidade, idpokemon) VALUES(0, 0);

--- Tipos e Categorias
INSERT INTO pokedex.tipofraqueza (stativo, nmtipofraqueza, idfraqueza) VALUES('', '', 0);
INSERT INTO pokedex.tipohabilidade (stativo, nmtipohabilidade, idhabilidade) VALUES('', '', 0);
INSERT INTO pokedex.categoriahabilidade (stativo, nmcategoriahabilidade, idhabilidade) VALUES('', '', 0);
