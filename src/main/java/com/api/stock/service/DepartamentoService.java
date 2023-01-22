package com.api.stock.service;

import com.api.stock.entity.Departamento;
import com.api.stock.interfaces.IDepartarmentoService;
import com.api.stock.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService implements IDepartarmentoService {

    @Autowired
    DepartamentoRepository repository;

    @Override
    public List<Departamento> listarDepartamentos() {
        return repository.findAll();
    }

    @Override
    public Departamento salvarDepartamento(Departamento departamento) {
        return repository.saveAndFlush(departamento);
    }
}
