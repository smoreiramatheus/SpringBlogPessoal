package com.minhaLojaDeGames.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaLojaDeGames.games.model.CategoriaLoja;



@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaLoja , Long>{
	public List<CategoriaLoja> findAllByNomeCategoriaContainingIgnoreCase (String nomeCategoria);

}
