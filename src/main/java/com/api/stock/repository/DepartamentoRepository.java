package com.api.stock.repository;

import com.api.stock.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, String> {
    Departamento findByNome(String name);
}
