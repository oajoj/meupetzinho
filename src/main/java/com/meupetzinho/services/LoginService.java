package com.meupetzinho.services;

import com.meupetzinho.models.requests.LoginRequest;
import com.meupetzinho.security.jwt.JwtUtils;
import com.meupetzinho.services.impl.UsuarioService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final UsuarioService usuarioService;

    public LoginService(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.usuarioService = usuarioService;
    }

    public String autenticarUsuario(LoginRequest loginRequest) {
        usuarioService.listarPorLogin(loginRequest.getLogin());
        var authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtUtils.generateJwtToken(authentication);
    }


}
