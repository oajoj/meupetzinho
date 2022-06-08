package com.meupetzinho.controllers;

import com.meupetzinho.models.Usuario;
import com.meupetzinho.models.dtos.UsuarioDTO;
import com.meupetzinho.models.requests.LoginRequest;
import com.meupetzinho.models.response.JwtResponse;
import com.meupetzinho.services.LoginService;
import com.meupetzinho.services.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Value("${jwt.expiration}")
    private Long expiration;
    private final UsuarioService usuarioService;

    private final LoginService loginService;

    public LoginController(UsuarioService service, LoginService loginService) {
        this.usuarioService = service;
        this.loginService = loginService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> autenticarUsuario(@Valid @RequestBody LoginRequest loginRequest){
        var jwt = loginService.autenticarUsuario(loginRequest);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwt)
                .body(new JwtResponse(jwt, expiration));
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
        var usuarioSalvo = usuarioService.salvar(usuarioDTO);
        return ResponseEntity
                .created(linkTo(methodOn(UsuarioController.class).listarPorId(usuarioSalvo.getId())).toUri())
                .body(usuarioSalvo);
    }
}
