package com.meupetzinho.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Veterinario veterinario;

    @ManyToOne
    private Usuario usuarioCliente;

    private LocalDate dataDoAgendamento;

    public Agendamento() {
    }

    public Agendamento(Long id, Veterinario veterinario, Usuario usuarioCliente, LocalDate dataDoAgendamento) {
        this.id = id;
        this.veterinario = veterinario;
        this.usuarioCliente = usuarioCliente;
        this.dataDoAgendamento = dataDoAgendamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public LocalDate getDataDoAgendamento() {
        return dataDoAgendamento;
    }

    public void setDataDoAgendamento(LocalDate dataDoAgendamento) {
        this.dataDoAgendamento = dataDoAgendamento;
    }
}
