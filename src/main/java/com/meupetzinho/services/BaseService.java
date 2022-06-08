package com.meupetzinho.services;

import java.util.List;

public interface BaseService<T> {
    T listarPorId(Long id);
    List<T> listar();
    T salvar(T t);
    T atualizar(Long id, T t);
    void remover(Long id);
}
