package com.api.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.model.ProdutoDTO;
import com.api.stock.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "API Produto")
@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Operation(summary = "Buscar produto")
	@GetMapping("")
	public ProdutoDTO buscarProduto(@Parameter(description = "Id do departamento") @RequestParam(value = "departamento", required=false) Integer idDepartamento, 
			@Parameter(description = "Id da categoria") @RequestParam(value = "categoria", required=false) Integer idCategoria, 
			@Parameter(description = "Id do filtro") @RequestParam(value = "filtro", required=false) Integer idFiltro){
		return produtoService.getProduto();
	}
	
	@Operation(summary = "Cadastrar produto")
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoDTO postProduto(@RequestBody ProdutoDTO produto) {
		return produto;
	}
	
	@Operation(summary = "Atualizar produto")
	@PutMapping("")
	public ProdutoDTO putUsuario(@RequestBody ProdutoDTO produto) {
		return produto;
	}
	
	@Operation(summary = "Excluir produto")
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUsuario(@PathVariable("id") Integer id) {
		
	}
	
}
