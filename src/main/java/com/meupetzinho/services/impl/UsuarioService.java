package com.meupetzinho.services.impl;

import com.meupetzinho.models.Usuario;
import com.meupetzinho.models.dtos.UsuarioDTO;
import com.meupetzinho.repositories.UsuarioRepository;
import com.meupetzinho.utils.PropertiesUtils;
import com.meupetzinho.utils.mappers.UsuarioMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    private final BCryptPasswordEncoder encoder;

    private final PropertiesUtils propertiesUtils;

    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repository, BCryptPasswordEncoder encoder, PropertiesUtils propertiesUtils, UsuarioMapper mapper) {
        this.repository = repository;
        this.encoder = encoder;
        this.propertiesUtils = propertiesUtils;
        this.mapper = mapper;
    }

    public Usuario listarPorId(Long id) {
        if(id == null) return null;
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario atualizar(Long id, UsuarioDTO usuarioDTO) {
        var usuario = listarPorId(id);
        var novoUsuario = mapper.dtoToEntity(usuarioDTO);
        BeanUtils.copyProperties(novoUsuario, usuario, propertiesUtils.getNullPropertyNames(novoUsuario));
        return repository.save(usuario);
    }

    public Usuario salvar(UsuarioDTO usuarioDTO) {
        Usuario usuarioEntidade = mapper.dtoToEntity(usuarioDTO);
        usuarioEntidade.setSenha(encoder.encode(usuarioEntidade.getSenha()));
        return repository.save(usuarioEntidade);
    }

    public void remover(Long id) {
        listarPorId(id);
        repository.deleteById(id);
    }



}
