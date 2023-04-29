package com.api.stock.controller;

import com.api.stock.entity.Produto;
import com.api.stock.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.stock.model.ProdutoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@CrossOrigin
@RestController
@Tag(name = "API Produto")
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	IProdutoService produtoService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar produto")
	public Produto buscarProduto(@Parameter(description = "Id do produto") @PathVariable(value = "id") Integer id){
		return produtoService.getProduto(id);
	}

	@GetMapping("/nome/{nome}")
	@Operation(summary = "Buscar produto")
	public List<ProdutoDTO> buscarProdutosPorNome(@RequestParam(value="idUsuario", required = false) String idUsuario,@Parameter(description = "Nome do produto") @PathVariable(value = "nome") String nome){
		return produtoService.buscarProdutosPorNome(nome,idUsuario);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Cadastrar produto")
	public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO produto) {
		return produtoService.salvarProduto(produto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Excluir produto")
	public void deleteProduto(@PathVariable("id") Integer id) {
		produtoService.deleteProduto(id);
	}

	@GetMapping("/listar-todos")
	@Operation(summary = "Listar todos os produtos")
	public List<ProdutoDTO> listarProdutos(@RequestParam(value="idUsuario", required = false) String idUsuario){
		return produtoService.listarProdutos(idUsuario);
	}
	@GetMapping("/meus-favoritos")
	@Operation(summary = "Listar todos os produtos favoritos do usuário")
	public List<ProdutoDTO> findFavoritosByUsuario(@RequestParam("idUsuario") String idUsuario){
		return produtoService.findFavoritosByUsuario(idUsuario);
	}

	@GetMapping("/listar-por-departamento/{departamento}")
	@Operation(summary = "Listar todos os produtos por departamento")
	public List<ProdutoDTO> listarProdutosPorDepartamento(@PathVariable("departamento") Integer departamento, @RequestParam(value="idUsuario", required = false) String idUsuario){
		return produtoService.listarProdutosPorDepartamento(departamento,idUsuario);
	}

}
