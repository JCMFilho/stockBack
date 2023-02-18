package com.api.stock.interfaces;

import com.api.stock.entity.Departamento;

import java.util.List;

public interface IDepartarmentoService {

    List<Departamento> listarDepartamentos();

    Departamento salvarDepartamento(Departamento departamento);
}
