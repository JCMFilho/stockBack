package com.api.stock.repository;

import com.api.stock.entity.Avaliacao;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, String> {
}