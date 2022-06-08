package com.meupetzinho;

import com.meupetzinho.repositories.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeupetzinhoApplication {

    private final UsuarioRepository repository;

    public MeupetzinhoApplication(UsuarioRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MeupetzinhoApplication.class, args);
    }

}
