package com.github.pauloruszel.service;

import com.github.pauloruszel.domain.dtos.FraquezaDTO;
import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.model.Fraqueza;
import com.github.pauloruszel.domain.model.Pokemon;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class FraquezaService extends BaseService {

    @Inject
    PokemonService pokemonService;

    public List<Fraqueza> findAll() {
        return Fraqueza.listAll();
    }

    public FraquezaDTO getById(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Fraqueza fraqueza = Fraqueza.findById(id);
        if (Objects.isNull(fraqueza))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(fraqueza, FraquezaDTO.class);
    }

    public FraquezaDTO getByIdPokemon(final Pokemon pokemon) throws ParametroInvalidoException {
        if (Objects.isNull(pokemon))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Fraqueza fraqueza = Fraqueza.find("pokemon", pokemon).firstResult();
        if (Objects.isNull(fraqueza))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(fraqueza, FraquezaDTO.class);
    }

    public FraquezaDTO save(final FraquezaDTO dto) throws ParametroInvalidoException {
        if (Objects.isNull(dto))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Fraqueza fraqueza = getConverter().map(dto, Fraqueza.class);
        fraqueza.persist();
        return getConverter().map(fraqueza, FraquezaDTO.class);
    }

    public FraquezaDTO update(final FraquezaDTO dto) throws ParametroInvalidoException {
        if (dto == null || dto.getId() == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        Fraqueza fraqueza = Fraqueza.findById(dto.getId());
        if (Objects.isNull(fraqueza))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        fraqueza = getConverter().map(dto, Fraqueza.class);
        return getConverter().map(fraqueza, FraquezaDTO.class);
    }

    public MensagemRetornoDTO delete(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Fraqueza fraqueza = Fraqueza.findById(id);
        if (Objects.isNull(fraqueza))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        fraqueza.delete();
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
    }

    public void savePokemonToFraqueza(final PokemonDTO dto, final Long idPokemon) throws ParametroInvalidoException {
        if (dto == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        if (idPokemon == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final FraquezaDTO fraquezaPokemon = dto.getFraqueza(); // Tavez eu deva pesquisar a Fraqueza antes de setar
        if (fraquezaPokemon == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_FRAQUEZA_DTO_INVALIDO);

        final PokemonDTO pokemonDTO = getConverter().map(pokemonService.getById(idPokemon), PokemonDTO.class);
        fraquezaPokemon.setPokemonDTO(pokemonDTO);

        final Fraqueza fraqueza = getConverter().map(fraquezaPokemon, Fraqueza.class);
        fraqueza.persist();
    }

}
