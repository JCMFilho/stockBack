package com.api.stock.service;

import com.api.stock.entity.Favorito;
import com.api.stock.interfaces.IFavoritoService;
import com.api.stock.model.FavoritoDTO;
import com.api.stock.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritoService implements IFavoritoService {

    @Autowired
    FavoritoRepository repository;

    @Override
    public Favorito adicionarFavorito(FavoritoDTO favorito) {
        return repository.saveAndFlush(new Favorito(favorito));
    }

    @Override
    public void removerFavorito(Integer id) {
        repository.deleteById(id);
    }
}
