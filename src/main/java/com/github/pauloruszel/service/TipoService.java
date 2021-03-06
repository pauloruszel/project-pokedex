package com.github.pauloruszel.service;

import com.github.pauloruszel.domain.dtos.MensagemRetornoDTO;
import com.github.pauloruszel.domain.dtos.TipoDTO;
import com.github.pauloruszel.domain.model.Pokemon;
import com.github.pauloruszel.domain.model.Tipo;
import com.github.pauloruszel.domain.util.MensagemUtil;
import com.github.pauloruszel.exception.ParametroInvalidoException;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class TipoService extends BaseService {

    public List<Tipo> findAll() {
        return Tipo.listAll();
    }

    public TipoDTO getById(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Tipo tipo = Tipo.findById(id);
        if (Objects.isNull(tipo))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        return getConverter().map(tipo, TipoDTO.class);
    }

    public TipoDTO getByIdPokemon(final Pokemon pokemon) {
        final Tipo tipo = Tipo.find("pokemon", pokemon).firstResult();
        return getConverter().map(tipo, TipoDTO.class);
    }

    public TipoDTO save(final TipoDTO dto) throws ParametroInvalidoException {
        if (Objects.isNull(dto))
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        final Tipo tipo = getConverter().map(dto, Tipo.class);
        tipo.persist();
        return getConverter().map(tipo, TipoDTO.class);
    }

    public TipoDTO update(final TipoDTO dto) throws ParametroInvalidoException {
        if (dto == null || dto.getId() == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_DTO_INVALIDO);

        Tipo tipo = Tipo.findById(dto.getId());
        if (Objects.isNull(tipo))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        tipo = getConverter().map(dto, Tipo.class);
        return getConverter().map(tipo, TipoDTO.class);
    }

    public MensagemRetornoDTO delete(final Long id) throws ParametroInvalidoException {
        if (id == null)
            throw new ParametroInvalidoException(MensagemUtil.MSG_PARAMETRO_ID_INVALIDO);

        final Tipo tipo = Tipo.findById(id);
        if (Objects.isNull(tipo))
            throw new ParametroInvalidoException(MensagemUtil.MSG_REGISTRO_NAO_ENCONTRADO);

        tipo.delete();
        return new MensagemRetornoDTO(MensagemUtil.MSG_REGISTRO_EXCLUIDO);
    }

}
