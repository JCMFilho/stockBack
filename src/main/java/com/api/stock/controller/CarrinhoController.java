package com.api.stock.controller;

import com.api.stock.entity.Carrinho;
import com.api.stock.entity.ProdutoCarrinho;
import com.api.stock.interfaces.ICarrinhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Tag(name = "API Carrinho")
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    ICarrinhoService carrinhoService;

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Buscar carrinho", description = "Retorna carrinho de um usuário")
    public Carrinho buscarCarrinhoPorUsuario(@PathVariable("idUsuario") String id){
        return carrinhoService.getCarrinhoPorUsuarioId(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Inserir no carrinho", description = "Insere produtos no carrinho do usuário")
    public Carrinho inserirProdutoCarrinho(@RequestBody ProdutoCarrinho produtoCarrinho){
        return carrinhoService.inserirProdutoCarrinho(produtoCarrinho);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Inserir no carrinho", description = "Insere produtos no carrinho do usuário")
    public void atualizarProdutoCarrinho(@RequestBody ProdutoCarrinho produtoCarrinho){
        carrinhoService.atualizarProdutoCarrinho(produtoCarrinho);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar item do carrinho", description = "Remove um item do carrinho do usuário")
    public void deleteItemCarrinho(@PathVariable("id") Integer id){
        carrinhoService.deleteItemCarrinho(id);
    }
}
