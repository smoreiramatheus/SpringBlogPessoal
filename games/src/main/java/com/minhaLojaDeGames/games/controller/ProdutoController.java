package com.minhaLojaDeGames.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.minhaLojaDeGames.games.model.Produto;
import com.minhaLojaDeGames.games.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(repository.findAll());		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetByIdProduto(@PathVariable Long idProduto){
		return repository.findById(idProduto).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}	
	
	@GetMapping ("/jogos/{jogos}")
	public ResponseEntity<List<Produto>> GetByEquipamentos(@PathVariable String jogos){
		return ResponseEntity.ok(repository.findAllByJogosContainingIgnoreCase(jogos));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long idProduto) {
		repository.deleteById(idProduto);
	}
	

}
