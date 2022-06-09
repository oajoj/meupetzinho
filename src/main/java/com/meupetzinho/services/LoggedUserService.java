package com.meupetzinho.services;

import com.meupetzinho.models.Usuario;
import com.meupetzinho.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoggedUserService {

    private final UsuarioRepository repository;

    public LoggedUserService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario getLoggedUser(){
        var usuarioAtual = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return repository.findByLogin(usuarioAtual.getUsername()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
