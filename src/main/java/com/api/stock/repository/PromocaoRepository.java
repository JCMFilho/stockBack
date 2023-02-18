package com.api.stock.repository;

import com.api.stock.entity.Promocao;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

    List<Promocao> findByTipo(String tipo);
}