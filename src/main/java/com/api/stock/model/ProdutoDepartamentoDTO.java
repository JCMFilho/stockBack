package com.api.stock.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoDepartamentoDTO {
    private Long qtde;
    private String produto;
    private String departamento;

    public ProdutoDepartamentoDTO(ProdutoDepartamentoInterfaceDTO produtoDepartamentoInterfaceDTO) {
        this.qtde = produtoDepartamentoInterfaceDTO.getQtde();
        this.produto = produtoDepartamentoInterfaceDTO.getProduto();
        this.departamento = produtoDepartamentoInterfaceDTO.getDepartamento();
    }

    public interface ProdutoDepartamentoInterfaceDTO {
        Long getQtde();
        String getProduto();
        String getDepartamento();
    }
}
