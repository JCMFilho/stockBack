package com.api.stock.repository;

import com.api.stock.entity.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoCarrinhoRepository  extends JpaRepository<ProdutoCarrinho, Integer>{
    @Query("SELECT P FROM ProdutoCarrinho P WHERE P.produto.id =:id AND P.carrinho.idUsuario.id =:userId")
    ProdutoCarrinho getByProductIdAndUserId(@Param("id") Integer id, @Param("userId") String userId);
}
