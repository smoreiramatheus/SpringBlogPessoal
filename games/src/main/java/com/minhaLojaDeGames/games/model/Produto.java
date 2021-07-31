package com.minhaLojaDeGames.games.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdProdutos;
	
	@Size(min = 2 , max = 100)
	private String equipamentos;
	
	@Size(min = 2 , max = 100)
	private String amiibos;
	
	@Size(min = 2 , max = 100)
	private String colecionaveis;
	
	
	@Size(min = 2 , max = 100)
	private String jogos;
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List <CategoriaLoja> categoria;
		
	

	/*METODOS GETTERS AND SETTERS */
	public int getIdProdutos() {
		return IdProdutos;
	}

	public void setIdProdutos(int idProdutos) {
		IdProdutos = idProdutos;
	}

	
	public String getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}

	public String getAmiibos() {
		return amiibos;
	}

	public void setAmiibos(String amiibos) {
		this.amiibos = amiibos;
	}

	public String getColecionaveis() {
		return colecionaveis;
	}

	public void setColecionaveis(String colecionaveis) {
		this.colecionaveis = colecionaveis;
	}

	public String getJogos() {
		return jogos;
	}

	public void setJogos(String jogos) {
		this.jogos = jogos;
	}
	
	public List<CategoriaLoja> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaLoja> categoria) {
		this.categoria = categoria;
	}
	
	
}
