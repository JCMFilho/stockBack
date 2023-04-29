package com.api.stock.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class EstatisticaDTO {

    private List<ProdutoDepartamentoDTO> maisVendidos;
    private List<ProdutoDepartamentoDTO> maisAcessados;
    private List<MaisDevolvidosDTO> maisDevolvidos;
}
