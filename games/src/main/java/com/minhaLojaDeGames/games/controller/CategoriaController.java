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

import com.minhaLojaDeGames.games.model.CategoriaLoja;
import com.minhaLojaDeGames.games.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaLoja>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaLoja> GetByIdcategoria(@PathVariable Long idCategoria){
		return repository.findById(idCategoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/plataformas/{plataformas}")
	public ResponseEntity<List<CategoriaLoja>> GetByNomeCategoria(@PathVariable String nomeCategoria){
		return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));		
	}
	
	@PostMapping
	public ResponseEntity<CategoriaLoja> post (@RequestBody CategoriaLoja categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
		
	}
	
	@PutMapping
	public ResponseEntity<CategoriaLoja> put (@RequestBody CategoriaLoja categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long idCategoria) {
		repository.deleteById(idCategoria);
	}
	
	

}
