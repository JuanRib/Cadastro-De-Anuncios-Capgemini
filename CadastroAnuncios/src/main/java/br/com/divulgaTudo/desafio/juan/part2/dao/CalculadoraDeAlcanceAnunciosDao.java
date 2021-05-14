package br.com.divulgaTudo.desafio.juan.part2.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.divulgaTudo.desafio.juan.part2.model.CalculadoraDeAlcanceAnuncios;
import br.com.divulgaTudo.desafio.juan.part2.model.Cliente;
import br.com.divulgaTudo.desafio.juan.part2.vo.RelatorioDeAnuncioVo;

/**
 * Data 05/05/2021 Classe Dao que representa um CalculadoraDeAlcanceAnunciosDao
 * 
 * @author Juan
 *
 */
public class CalculadoraDeAlcanceAnunciosDao {

	private EntityManager manager;

	/**
	 * Construtor que recebe um EntityManager
	 * 
	 * @param manager
	 */
	public CalculadoraDeAlcanceAnunciosDao(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * Recebe um objeto do tipo CalculadoraDeAlcanceAnuncios e o persist no banco de
	 * dados.
	 * 
	 * @param CalculadoraDeAlcanceAnuncios.
	 */
	public void cadastrarCalculadoraDeAlcanceAnuncios(CalculadoraDeAlcanceAnuncios calculadora) {
		this.manager.persist(calculadora);
	}

	/**
	 * Recebe um objeto do tipo CalculadoraDeAlcanceAnuncios e o atualiza no banco
	 * de dados.
	 * 
	 * @param CalculadoraDeAlcanceAnuncios.
	 */
	public void atualizarCliente(CalculadoraDeAlcanceAnuncios calculadora) {
		this.manager.merge(calculadora);
	}

	/**
	 * Recebe um objeto do tipo CalculadoraDeAlcanceAnuncios e o remove no banco de
	 * dados.
	 * 
	 * @param CalculadoraDeAlcanceAnuncios.
	 */
	public void removerCliente(CalculadoraDeAlcanceAnuncios calculadora) {
		calculadora = this.manager.merge(calculadora);
		this.manager.remove(calculadora);
	}

	/**
	 * Faz um seleção do tipo relatorio e recebe uma lista com os elementos
	 * selecionados sem nenhum filtro.
	 * 
	 * @return uma lista do tipo RelatorioDeAnuncioVo.
	 */
	public List<RelatorioDeAnuncioVo> RelatorioAlcanceDoAnuncio() {
		String jpql = "SELECT new br.com.divulgaTudo.desafio.juan.part2.vo.RelatorioDeAnuncioVo("
				+ " anuncio.nomeAnuncio, " + "SUM(calculadora.valorInvestimento) AS total, "
				+ "calculadora.quantidadeDeVisualizacoes, " + "calculadora.quantidadeCliquesVisualizacao, "
				+ "calculadora.quantidadeCompartilhamento) " + "FROM CalculadoraDeAlcanceAnuncios calculadora "
				+ "JOIN calculadora.anuncio anuncio " + "GROUP BY anuncio.nomeAnuncio "
				+ "ORDER BY calculadora.valorInvestimento";

		return manager.createQuery(jpql, RelatorioDeAnuncioVo.class).getResultList();
	}

	/**
	 * Faz um seleção do tipo relatorio e recebe uma lista com os elementos
	 * selecionados com filtro de intervalo de datas.
	 * 
	 * @param dataIni
	 * @param dataFim
	 * @return uma lista do tipo RelatorioDeAnuncioVo.
	 * @throws Exception
	 */
	public List<RelatorioDeAnuncioVo> RelatorioFiltroData(Date dataIni, Date dataFim) throws Exception {
		String jpql = "SELECT new br.com.divulgaTudo.desafio.juan.part2.vo.RelatorioDeAnuncioVo("
				+ "calculadora.nomeDoAnuncio, " + "SUM(calculadora.valorInvestimento) AS total, "
				+ "calculadora.quantidadeDeVisualizacoes," + "calculadora.quantidadeCliquesVisualizacao, "
				+ "calculadora.quantidadeCompartilhamento)" + "FROM CalculadoraDeAlcanceAnuncios calculadora "
				+ "WHERE anuncio.dataDeInicio BETWEEN :dataIni AND :dataFim " + "GROUP BY calculadora.nomeDoAnuncio "
				+ "ORDER BY calculadora.valorInvestimento";

		return manager.createQuery(jpql, RelatorioDeAnuncioVo.class).setParameter("dataIni", dataIni)
				.setParameter("dataFim", dataFim).getResultList();
	}

	/**
	 * * Faz um seleção do tipo relatorio e recebe uma lista com os elementos
	 * selecionados com filtro de cliente.
	 * 
	 * @param cliente
	 * @return uma lista do tipo RelatorioDeAnuncioVo.
	 */
	public List<RelatorioDeAnuncioVo> RelatorioPorCliente(Cliente cliente) {
		String jpql = "SELECT new br.com.divulgaTudo.desafio.juan.part2.vo.RelatorioDeAnuncioVo("
				+ "calculadora.nomeDoAnuncio, " + "SUM(calculadora.valorInvestimento) AS total, "
				+ "calculadora.quantidadeDeVisualizacoes," + "calculadora.quantidadeCliquesVisualizacao, "
				+ "calculadora.quantidadeCompartilhamento)" + "FROM CalculadoraDeAlcanceAnuncios calculadora "
				+ "WHERE anuncio.cliente = :cliente";

		return manager.createQuery(jpql, RelatorioDeAnuncioVo.class).setParameter("cliente", cliente).getResultList();

	}
}
