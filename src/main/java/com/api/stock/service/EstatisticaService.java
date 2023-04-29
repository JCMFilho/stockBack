package com.api.stock.service;

import com.api.stock.interfaces.IEstatisticaService;
import com.api.stock.model.EstatisticaDTO;
import com.api.stock.model.MaisDevolvidosDTO;
import com.api.stock.model.ProdutoDepartamentoDTO;
import com.api.stock.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EstatisticaService implements IEstatisticaService {

    @Autowired
    PedidoItemRepository repository;

    @Override
    public EstatisticaDTO buscarEstatisticas() {
        EstatisticaDTO estatistica = new EstatisticaDTO();
        estatistica.setMaisVendidos(repository.findTop3ProdutosPorDepartamento().stream().map(ProdutoDepartamentoDTO::new).collect(Collectors.toList()));
        estatistica.setMaisAcessados(repository.findTop4ProdutosMaisAcessados().stream().map(ProdutoDepartamentoDTO::new).collect(Collectors.toList()));
        estatistica.setMaisDevolvidos(repository.maisDevolvidos().stream().map(MaisDevolvidosDTO::new).collect(Collectors.toList()));
        return estatistica;
    }
}
