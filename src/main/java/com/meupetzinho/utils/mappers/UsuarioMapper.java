package com.meupetzinho.utils.mappers;

import com.meupetzinho.models.Usuario;
import com.meupetzinho.models.dtos.UsuarioDTO;
import com.meupetzinho.services.impl.CargoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {

    @Autowired
    protected CargoService service;

    @Mapping(target = "cargos", expression = "java(service.dtosParaEntidades(dto.getCargos()))")
    public abstract Usuario dtoToEntity(UsuarioDTO dto);
}
