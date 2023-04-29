package com.api.stock.service;

import com.api.stock.entity.Carrinho;
import com.api.stock.entity.ProdutoCarrinho;
import com.api.stock.entity.Usuario;
import com.api.stock.interfaces.ICarrinhoService;
import com.api.stock.repository.CarrinhoRepository;
import com.api.stock.repository.ProdutoCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrinhoService implements ICarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ProdutoCarrinhoRepository produtoCarrinhoRepository;

    @Override
    public Carrinho getCarrinhoPorUsuarioId(String id) {
        return carrinhoRepository.getByUserId(id);
    }

    @Override
    public Carrinho inserirProdutoCarrinho(ProdutoCarrinho produtoCarrinho) {
        Carrinho carrinho = getCarrinhoPorUsuarioId(produtoCarrinho.getUsuarioId());
        ProdutoCarrinho itemCarrinho = produtoCarrinhoRepository.getByProductIdAndUserId(produtoCarrinho.getProduto().getId(),produtoCarrinho.getUsuarioId());
        if(itemCarrinho != null){
            produtoCarrinho.setId(itemCarrinho.getId());
        }
        if(carrinho == null || carrinho.getId() == null){
            carrinho = inserirCarrinho(produtoCarrinho);
        }else if(itemCarrinho == null){
            carrinho.setTotal(carrinho.getTotal()+1);
            carrinhoRepository.saveAndFlush(carrinho);
        }
        produtoCarrinho.setCarrinho(carrinho);
        produtoCarrinhoRepository.saveAndFlush(produtoCarrinho);
        return getCarrinhoPorUsuarioId(produtoCarrinho.getUsuarioId());
    }

    @Override
    public void atualizarProdutoCarrinho(ProdutoCarrinho produtoCarrinho) {
        Optional<ProdutoCarrinho> item = produtoCarrinhoRepository.findById(produtoCarrinho.getId());
        if(item.isPresent()){
            ProdutoCarrinho itemCarrinho = item.get();
            itemCarrinho.setQuantidade(produtoCarrinho.getQuantidade());
            produtoCarrinhoRepository.saveAndFlush(itemCarrinho);
        }
    }

    @Override
    public void deleteItemCarrinho(Integer id) {
        Optional<ProdutoCarrinho> produtoCarrinho = produtoCarrinhoRepository.findById(id);
        if(produtoCarrinho.isPresent()){
            Carrinho carrinho = produtoCarrinho.get().getCarrinho();
            carrinho.setTotal(carrinho.getTotal() - 1);
            carrinhoRepository.saveAndFlush(carrinho);
            produtoCarrinhoRepository.deleteById(id);
        }
    }


    private Carrinho inserirCarrinho(ProdutoCarrinho produtoCarrinho){
        Carrinho carrinho = new Carrinho();
        carrinho.setTotal(1);
        Usuario usu = new Usuario();
        usu.setId(produtoCarrinho.getUsuarioId());
        carrinho.setIdUsuario(usu);
        carrinhoRepository.saveAndFlush(carrinho);
        return carrinho;
    }
}
