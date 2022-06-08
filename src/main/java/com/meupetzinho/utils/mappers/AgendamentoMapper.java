package com.meupetzinho.utils.mappers;

import com.meupetzinho.models.Agendamento;
import com.meupetzinho.models.dtos.AgendamentoDTO;
import com.meupetzinho.services.impl.UsuarioService;
import com.meupetzinho.services.impl.VeterinarioService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AgendamentoMapper {

    @Autowired
    protected UsuarioService clienteService;

    @Autowired
    protected VeterinarioService veterinarioService;

    @Mappings({
            @Mapping(target = "usuarioCliente", expression = "java(clienteService.listarPorId(dto.getUsuarioCliente()))"),
            @Mapping(target = "veterinario", expression = "java(veterinarioService.listarPorId(dto.getVeterinario()))")
    })
    public abstract Agendamento dtoToEntity(AgendamentoDTO dto);
}
