package com.api.stock.repository;

import com.api.stock.entity.Endereco;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    List<Endereco> findAllByidUsuarioId(String id);
}
