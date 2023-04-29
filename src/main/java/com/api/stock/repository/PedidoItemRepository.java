package com.api.stock.repository;

import com.api.stock.entity.PedidoItem;
import com.api.stock.model.MaisDevolvidosDTO;
import com.api.stock.model.ProdutoDepartamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoItemRepository  extends JpaRepository<PedidoItem,Integer> {
    @Query(value = "SELECT QTDE, PRODUTO,DEPARTAMENTO\n" +
            "FROM (\n" +
            "  SELECT \n" +
            "    SUM(PI.QUANTIDADE) AS QTDE, \n" +
            "    P.NOME AS PRODUTO, \n" +
            "    D.NOME AS DEPARTAMENTO, \n" +
            "    ROW_NUMBER() OVER (PARTITION BY D.ID ORDER BY SUM(PI.QUANTIDADE) DESC) AS ROW_NUM\n" +
            "  FROM PEDIDO_ITEM PI\n" +
            "  LEFT JOIN PRODUTO P ON P.ID = PI.PRODUTO_ID \n" +
            "  LEFT JOIN DEPARTAMENTO D ON D.ID = P.DEPARTAMENTO_ID \n" +
            "  GROUP BY P.NOME, D.NOME, D.ID\n" +
            ") SUBQUERY\n" +
            "WHERE ROW_NUM <= 3\n" +
            "ORDER BY DEPARTAMENTO, QTDE DESC",nativeQuery = true)
    List<ProdutoDepartamentoDTO.ProdutoDepartamentoInterfaceDTO> findTop3ProdutosPorDepartamento();

    @Query(value = "SELECT total_acessos as qtde, produto, departamento FROM (\n" +
            "  SELECT \n" +
            "    SUM(p.total_acessos) as total_acessos, \n" +
            "    p.nome as produto, \n" +
            "    d.nome as departamento, \n" +
            "    ROW_NUMBER() OVER (PARTITION BY d.id ORDER BY SUM(p.total_acessos) DESC) AS row_num\n" +
            "  FROM produto p\n" +
            "  LEFT JOIN departamento d ON d.id = p.departamento_id\n" +
            "  GROUP BY p.nome, d.nome\n" +
            ") subquery\n" +
            "WHERE row_num <= 4\n" +
            "ORDER BY departamento, total_acessos DESC",nativeQuery = true)
    List<ProdutoDepartamentoDTO.ProdutoDepartamentoInterfaceDTO> findTop4ProdutosMaisAcessados();

    @Query(value = "SELECT count(*) as qtde, d.nome as departamento, p.data from pedido p \n" +
            "left join pedido_item pi \n" +
            "on p.id = pi.pedido_id \n" +
            "left join produto p2 \n" +
            "on p2.id = pi.produto_id \n" +
            "LEFT JOIN departamento d \n" +
            "on d.id = p2.departamento_id \n" +
            "WHERE p.status = 'Devolvido'\n" +
            "group by 2,3\n" +
            "order by data desc",nativeQuery = true)
    List<MaisDevolvidosDTO.MaisDevolvidosInterfaceDTO> maisDevolvidos();
}
