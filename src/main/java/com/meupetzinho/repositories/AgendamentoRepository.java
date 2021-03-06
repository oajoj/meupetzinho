package com.meupetzinho.repositories;

import com.meupetzinho.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
    List<Agendamento> findAgendamentoByUsuarioClienteLogin(String login);
}