package com.meupetzinho.services.impl;

import com.meupetzinho.models.Cargo;
import com.meupetzinho.repositories.CargoRepository;
import com.meupetzinho.services.BaseService;
import com.meupetzinho.utils.PropertiesUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoService implements BaseService<Cargo> {
    private final CargoRepository repository;

    private final PropertiesUtils propertiesUtils;

    public CargoService(CargoRepository repository, PropertiesUtils propertiesUtils) {
        this.repository = repository;
        this.propertiesUtils = propertiesUtils;
    }

    public Cargo listarPorNome(String nomeCargo){
        return repository
                .findByNome(nomeCargo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado"));
    }
    @Override
    public Cargo listarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Cargo> listar() {
        return repository.findAll();
    }

    @Override
    public Cargo salvar(Cargo cargo) {
        return repository.save(cargo);
    }

    @Override
    public Cargo atualizar(Long id, Cargo novoCargo) {
        var cargo = listarPorId(id);
        BeanUtils.copyProperties(novoCargo, cargo, propertiesUtils.getNullPropertyNames(novoCargo));
        return repository.save(cargo);
    }

    @Override
    public void remover(Long id) {
        repository.deleteById(id);
    }


    public List<Cargo> dtosParaEntidades(List<String> cargosDTO){
        if(cargosDTO == null) return null;
        List<Cargo> cargosEntidade = new ArrayList<>();
        cargosDTO.forEach(x -> cargosEntidade.add(listarPorNome(x)));
        return cargosEntidade;
    }
}
