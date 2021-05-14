package br.com.divulgaTudo.desafio.juan.part2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Data 05/05/2021 Classe modelo que representa um anuncio
 * 
 * @author Juan
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	/**
	 * Construtor vazio
	 */
	public Cliente() {
	}

	/**
	 * Construtor que recebe a variável nome.
	 * 
	 * @param nome
	 */
	public Cliente(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o nome.
	 * 
	 * @return retorna nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que define um valor para variavel nome.
	 * 
	 * @param nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
