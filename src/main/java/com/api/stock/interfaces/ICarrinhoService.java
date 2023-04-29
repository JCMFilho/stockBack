package com.api.stock.interfaces;

import com.api.stock.entity.Carrinho;
import com.api.stock.entity.ProdutoCarrinho;

public interface ICarrinhoService {

    Carrinho getCarrinhoPorUsuarioId(String id);

    Carrinho inserirProdutoCarrinho(ProdutoCarrinho produtoCarrinho);


    void atualizarProdutoCarrinho(ProdutoCarrinho produtoCarrinho);

    void deleteItemCarrinho(Integer id);
}
