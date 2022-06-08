package com.meupetzinho.models.dtos;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AgendamentoDTO {
    @NotNull
    private Long veterinario;
    @NotNull
    private Long usuarioCliente;

    private LocalDate dataDoAgendamento;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long veterinario, Long usuarioCliente, LocalDate dataDoAgendamento) {
        this.veterinario = veterinario;
        this.usuarioCliente = usuarioCliente;
        this.dataDoAgendamento = dataDoAgendamento;
    }

    public Long getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Long veterinario) {
        this.veterinario = veterinario;
    }

    public Long getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Long usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public LocalDate getDataDoAgendamento() {
        return dataDoAgendamento;
    }

    public void setDataDoAgendamento(LocalDate dataDoAgendamento) {
        this.dataDoAgendamento = dataDoAgendamento;
    }
}
