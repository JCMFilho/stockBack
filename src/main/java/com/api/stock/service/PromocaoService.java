package com.api.stock.service;

import com.api.stock.entity.Promocao;
import com.api.stock.interfaces.IPromocaoService;
import com.api.stock.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocaoService implements IPromocaoService {

    @Autowired
    PromocaoRepository promocaoRepository;

    @Override
    public List<Promocao> getPromocaoByTipo(String tipo){
        return promocaoRepository.findByTipo(tipo);
    }
}
