package com.api.stock.interfaces;

import com.api.stock.entity.Promocao;

import java.util.List;

public interface IPromocaoService {

    List<Promocao> getPromocaoByTipo(String tipo);
}
