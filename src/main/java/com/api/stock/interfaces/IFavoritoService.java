package com.api.stock.interfaces;

import com.api.stock.entity.Favorito;
import com.api.stock.model.FavoritoDTO;

public interface IFavoritoService {

    Favorito adicionarFavorito(FavoritoDTO favorito);

    void removerFavorito(Integer id);
}
