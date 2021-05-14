package br.com.divulgaTudo.desafio.juan.part2.dao;

import javax.persistence.EntityManager;

import br.com.divulgaTudo.desafio.juan.part2.model.Cliente;

/**
 * Data 05/05/2021 Classe Dao que representa um clienteDao
 * 
 * @author Juan
 *
 */
public class ClienteDao {

	private EntityManager manager;

	/**
	 * Construtor que recebe um EntityManager
	 * 
	 * @param manager
	 */
	public ClienteDao(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Recebe um objeto do tipo cliente e o persist no banco de dados.
	 * 
	 * @param cliente
	 */
	public void cadastrarCliente(Cliente cliente) {
		this.manager.persist(cliente);
	}

	/**
	 * Recebe um objeto do tipo cliente e o atualiza no banco de dados.
	 * 
	 * @param cliente
	 */
	public void atualizarCliente(Cliente cliente) {
		this.manager.merge(cliente);
	}

	/**
	 * Recebe um objeto do tipo cliente e o remove no banco de dados.
	 * 
	 * @param cliente
	 */
	public void removerCliente(Cliente cliente) {
		cliente = this.manager.merge(cliente);
		this.manager.remove(cliente);
	}
}
