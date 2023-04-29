package com.api.stock.repository;

import com.api.stock.entity.Produto;
import com.api.stock.model.ProdutoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value = "SELECT new com.api.stock.model.ProdutoDTO(p, f.id) FROM Produto p left join Favorito f on p.id = f.idProduto.id and f.idUsuario.id =:idUsuario WHERE p.departamento.id = :id")
    List<ProdutoDTO> listarPorDepartamento(@Param("id") Integer id, @Param("idUsuario") String idUsuario);

    @Query(value = "SELECT new com.api.stock.model.ProdutoDTO(p, f.id) FROM Produto p left join Favorito f on p.id = f.idProduto.id and f.idUsuario.id =:idUsuario")
    List<ProdutoDTO> listarProdutos(@Param("idUsuario") String idUsuario);

    @Query(value = "SELECT p FROM Produto p WHERE p.id = :id")
    Produto buscarPorId(@Param("id") Integer id);

    @Query(value = "SELECT new com.api.stock.model.ProdutoDTO(p, f.id) FROM Produto p left join Favorito f on p.id = f.idProduto.id and f.idUsuario.id =:idUsuario WHERE p.nome like CONCAT('%',:nome ,'%')")
    List<ProdutoDTO> findByNome(@Param("nome") String nome,@Param("idUsuario") String idUsuario);

    @Query(value = "SELECT new com.api.stock.model.ProdutoDTO(p, f.id) FROM Produto p INNER JOIN Favorito f on p.id = f.idProduto.id and f.idUsuario.id =:idUsuario ")
    List<ProdutoDTO> findFavoritosByUsuario(@Param("idUsuario") String idUsuario);
}