package com.github.pauloruszel.service;

import com.github.pauloruszel.domain.dtos.HabilidadeDTO;
import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.PokemonDTO;
import com.github.pauloruszel.domain.model.Habilidade;
import com.github.pauloruszel.domain.model.Pokemon;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class HabilidadeService extends BaseService {

    @Inject
    PokemonService pokemonService;

    public List<Habilidade> findAll() {
        return Habilidade.listAll();
    }

    public HabilidadeDTO getById(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Habilidade habilidade = Habilidade.findById(id);
        if (Objects.isNull(habilidade))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(habilidade, HabilidadeDTO.class);
    }

    public HabilidadeDTO getByIdPokemon(final Pokemon pokemon) {
        final Habilidade habilidade = Habilidade.find("pokemon", pokemon).firstResult();
        return getConverter().map(habilidade, HabilidadeDTO.class);
    }

    public HabilidadeDTO save(final HabilidadeDTO dto) throws ParametroInvalidoException {
        if (Objects.isNull(dto))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Habilidade habilidade = getConverter().map(dto, Habilidade.class);
        habilidade.persist();
        return getConverter().map(habilidade, HabilidadeDTO.class);
    }

    public HabilidadeDTO update(final HabilidadeDTO dto) throws ParametroInvalidoException {
        if (dto == null || dto.getId() == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        Habilidade habilidade = Habilidade.findById(dto.getId());
        if (Objects.isNull(habilidade))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        habilidade = getConverter().map(dto, Habilidade.class);
        return getConverter().map(habilidade, HabilidadeDTO.class);
    }

    public MensagemRetornoDTO delete(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Habilidade habilidade = Habilidade.findById(id);
        if (Objects.isNull(habilidade))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        habilidade.delete();
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
    }

    public void savePokemonToHabilidade(final PokemonDTO dto, final Long idPokemon) throws ParametroInvalidoException {
        if (dto == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final HabilidadeDTO habilidadePokemon = dto.getHabilidade(); // Tavez eu deva pesquisar a Habilidade antes de setar
        if (habilidadePokemon == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_HABILIDADE_DTO_INVALIDO);

        final PokemonDTO pokemonDTO = getConverter().map(pokemonService.getById(idPokemon), PokemonDTO.class);
        habilidadePokemon.setPokemonDTO(pokemonDTO);

        final Habilidade habilidade = getConverter().map(habilidadePokemon, Habilidade.class);
        habilidade.persist();
    }

}
