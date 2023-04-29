package com.api.stock.repository;

import com.api.stock.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarrinhoRepository  extends JpaRepository<Carrinho,Integer> {

    @Query("SELECT C FROM Carrinho C WHERE C.idUsuario.id =:id")
    Carrinho getByUserId(@Param("id") String id);
}
