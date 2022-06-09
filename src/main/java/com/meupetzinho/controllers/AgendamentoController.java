package com.meupetzinho.controllers;

import com.meupetzinho.models.Agendamento;
import com.meupetzinho.models.dtos.AgendamentoDTO;
import com.meupetzinho.services.impl.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> listarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.listarPorId(id));
    }

    @GetMapping("/meus-agendamentos")
    public ResponseEntity<List<Agendamento>> listarPorUsuario() {
        return ResponseEntity.ok(service.listarPorUsuario());
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Agendamento> salvar(@RequestBody @Valid AgendamentoDTO agendamento) {
        var novoAgendamento = service.salvar(agendamento);
        return ResponseEntity
                .created(linkTo(methodOn(AgendamentoController.class).listarPorId(novoAgendamento.getId())).toUri())
                .body(novoAgendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Long id, @RequestBody AgendamentoDTO agendamentoDTO) {
        return ResponseEntity.ok(service.atualizar(id, agendamentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
