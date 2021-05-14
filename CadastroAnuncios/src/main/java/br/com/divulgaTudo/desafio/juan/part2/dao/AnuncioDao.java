package br.com.divulgaTudo.desafio.juan.part2.dao;

import javax.persistence.EntityManager;

import br.com.divulgaTudo.desafio.juan.part2.model.Anuncio;

/**
 * Data 05/05/2021 Classe Dao que representa um anuncioDao
 * 
 * @author Juan
 *
 */
public class AnuncioDao {

	private EntityManager manager;

	/**
	 * Construtor que recebe um EntityManager
	 * 
	 * @param manager
	 */
	public AnuncioDao(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Recebe um objeto do tipo anuncio e o persist no banco de dados.
	 * 
	 * @param anuncio
	 */
	public void cadastrarAnuncio(Anuncio anuncio) {
		this.manager.persist(anuncio);
	}

	/**
	 * Recebe um objeto do tipo anuncio e o atualiza no banco de dados.
	 * 
	 * @param anuncio
	 */
	public void atualizarAnuncio(Anuncio anuncio) {
		this.manager.merge(anuncio);
	}

	/**
	 * Recebe um objeto do tipo anuncio e o remove no banco de dados.
	 * 
	 * @param anuncio
	 */
	public void removerAnuncio(Anuncio anuncio) {
		anuncio = this.manager.merge(anuncio);
		this.manager.remove(anuncio);
	}
}
