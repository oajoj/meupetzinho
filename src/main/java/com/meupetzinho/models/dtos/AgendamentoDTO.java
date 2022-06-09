package com.meupetzinho.models.dtos;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AgendamentoDTO {
    @NotNull
    private Long veterinario;

    private LocalDate dataDoAgendamento;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Long veterinario, LocalDate dataDoAgendamento) {
        this.veterinario = veterinario;
        this.dataDoAgendamento = dataDoAgendamento;
    }

    public Long getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Long veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDate getDataDoAgendamento() {
        return dataDoAgendamento;
    }

    public void setDataDoAgendamento(LocalDate dataDoAgendamento) {
        this.dataDoAgendamento = dataDoAgendamento;
    }
}
