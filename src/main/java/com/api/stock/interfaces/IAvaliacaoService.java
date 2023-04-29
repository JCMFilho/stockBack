package com.api.stock.interfaces;

import com.api.stock.entity.Avaliacao;
import com.api.stock.model.AvaliacaoDTO;

public interface IAvaliacaoService {


	Avaliacao saveAvaliacao(AvaliacaoDTO avaliacaoDTO);

}
