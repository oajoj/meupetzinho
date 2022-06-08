package com.meupetzinho.services.impl;

import com.meupetzinho.models.Veterinario;
import com.meupetzinho.repositories.VeterinarioRepository;
import com.meupetzinho.services.BaseService;
import com.meupetzinho.utils.PropertiesUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VeterinarioService implements BaseService<Veterinario> {

    private final VeterinarioRepository repository;

    private final PropertiesUtils propertiesUtils;


    public VeterinarioService(VeterinarioRepository repository, PropertiesUtils propertiesUtils) {
        this.repository = repository;
        this.propertiesUtils = propertiesUtils;
    }

    @Override
    public Veterinario listarPorId(Long id) {
        if(id == null) return null;
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso não encontrado"));
    }
    @Override
    public List<Veterinario> listar() {
        return repository.findAll();
    }

    @Override
    public Veterinario salvar(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    public Veterinario atualizar(Long id, Veterinario novoVeterinario) {
        var veterinario = listarPorId(id);
        BeanUtils.copyProperties(novoVeterinario, veterinario, propertiesUtils.getNullPropertyNames(novoVeterinario));
        return repository.save(veterinario);
    }

    @Override
    public void remover(Long id) {
        listarPorId(id);
        repository.deleteById(id);
    }
}
