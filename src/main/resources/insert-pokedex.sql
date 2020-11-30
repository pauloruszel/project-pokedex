--- Caracteristicas
INSERT INTO pokedex.categoria (stativo, nmcategoria) VALUES('A', 'Mouse');
INSERT INTO pokedex.caracteristica (dsaltura, dsidade, nmcaracteristica, dspeso) VALUES('0.4 m', 'Sem dados', 'Pikachu', '6.0 kg');

--- Generos
INSERT INTO pokedex.genero (idgenero, stativo, nmgenero) VALUES(1, 'A', 'MASCULINO');
INSERT INTO pokedex.genero (idgenero, stativo, nmgenero) VALUES(2, 'A', 'FEMININO');
INSERT INTO pokedex.genero (idgenero, stativo, nmgenero) VALUES(3, 'A', 'OUTROS');

INSERT INTO pokedex.pokemon (nmpokemon, idcaracteristica, idcategoria, idgenero) VALUES('Pikachu', 1, 1, 1);

--- Atributos de Fraqueza e Habilidade
INSERT INTO pokedex.fraqueza (stativo, nmfraqueza) VALUES('A', 'Terra');
INSERT INTO pokedex.fraquezapokemon (idfraqueza, idpokemon) VALUES(1, 1);
INSERT INTO pokedex.habilidade (stativo, nmhabilidade) VALUES('A', 'Static');
INSERT INTO pokedex.habilidadepokemon (idhabilidade, idpokemon) VALUES(1, 1);

--- Tipos e Categorias
INSERT INTO pokedex.tipofraqueza (stativo, nmtipofraqueza, idfraqueza) VALUES('A', 'Sem dados', 1);
INSERT INTO pokedex.tipohabilidade (stativo, nmtipohabilidade, idhabilidade) VALUES('A', 'Elétrico', 1);
INSERT INTO pokedex.categoriahabilidade (stativo, nmcategoriahabilidade, idhabilidade) VALUES('A', 'Eletricidade estática que causa paralisia.', 1);
