package com.meupetzinho.services.impl;

import com.meupetzinho.models.Agendamento;
import com.meupetzinho.models.dtos.AgendamentoDTO;
import com.meupetzinho.repositories.AgendamentoRepository;
import com.meupetzinho.services.LoggedUserService;
import com.meupetzinho.utils.PropertiesUtils;
import com.meupetzinho.utils.mappers.AgendamentoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;

    private final PropertiesUtils propertiesUtils;

    private final AgendamentoMapper mapper;

    private final LoggedUserService loggedUserService;

    public AgendamentoService(AgendamentoRepository repository, PropertiesUtils propertiesUtils, AgendamentoMapper mapper, LoggedUserService loggedUserService) {
        this.repository = repository;
        this.propertiesUtils = propertiesUtils;
        this.mapper = mapper;
        this.loggedUserService = loggedUserService;
    }

    public Agendamento listarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso não encontrado"));
    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }

    public List<Agendamento> listarPorUsuario() {
        var usuarioAtual = loggedUserService.getLoggedUser();
        return repository.findAgendamentoByUsuarioClienteLogin(usuarioAtual.getLogin());
    }

    public Agendamento salvar(AgendamentoDTO agendamentoDTO) {
        var usuarioAtual = loggedUserService.getLoggedUser();
        var agendamento = mapper.dtoToEntity(agendamentoDTO);
        agendamento.setUsuarioCliente(usuarioAtual);
        return repository.save(agendamento);
    }

    public Agendamento atualizar(Long id, AgendamentoDTO agendamentoDTO) {
        var agendamento = listarPorId(id);
        var novoAgendamento = mapper.dtoToEntity(agendamentoDTO);
        BeanUtils.copyProperties(novoAgendamento, agendamento, propertiesUtils.getNullPropertyNames(novoAgendamento));
        return repository.save(agendamento);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
