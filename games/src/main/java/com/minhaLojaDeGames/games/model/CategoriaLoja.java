package com.minhaLojaDeGames.games.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class CategoriaLoja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria; /* IDENTIFICAÇÃO DA CATEGORIA */
	
	@NotNull
	@Size(min = 2, max = 100)
	@NotBlank
	private String nomeCategoria; /* PLAYSTATION 3,4 OU 5, XBOX ONE OU 360, PC, SWITCH*/
	
	@ManyToOne
	@JsonIgnoreProperties("categoria")
	private Produto produto;
	
		
	
	/*METODOS GETTERS AND SETTERS */
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	


}
