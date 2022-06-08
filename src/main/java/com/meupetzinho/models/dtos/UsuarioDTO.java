package com.meupetzinho.models.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class UsuarioDTO {
    @NotEmpty
    private String login;
    @NotEmpty
    private String senha;
    @NotEmpty
    private List<String> cargos;
    @NotEmpty
    private String nome;
    private String nomePet;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String login, String senha, List<String> cargos, String nome, String nomePet) {
        this.login = login;
        this.senha = senha;
        this.cargos = cargos;
        this.nome = nome;
        this.nomePet = nomePet;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<String> getCargos() {
        return cargos;
    }

    public void setCargos(List<String> cargos) {
        this.cargos = cargos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomeAnimal) {
        this.nomePet = nomeAnimal;
    }
}
