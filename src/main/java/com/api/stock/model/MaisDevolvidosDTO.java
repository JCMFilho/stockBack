package com.api.stock.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaisDevolvidosDTO {
    private Long qtde;

    private String departamento;

    private String data;

    public MaisDevolvidosDTO(MaisDevolvidosInterfaceDTO produtoDepartamentoInterfaceDTO) {
        this.qtde = produtoDepartamentoInterfaceDTO.getQtde();
        this.departamento = produtoDepartamentoInterfaceDTO.getDepartamento();
        this.data = produtoDepartamentoInterfaceDTO.getData();
    }

    public interface MaisDevolvidosInterfaceDTO {
        Long getQtde();

        String getDepartamento();

        String getData();
    }
}
