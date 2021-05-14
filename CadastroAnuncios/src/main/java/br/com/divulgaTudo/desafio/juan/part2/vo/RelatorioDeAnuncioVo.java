package br.com.divulgaTudo.desafio.juan.part2.vo;

/**
 * Data 05/05/2021 Classe modelo que representa um anuncio
 * 
 * @author Juan
 *
 */
public class RelatorioDeAnuncioVo {

	private String nomeAnuncio;
	private Double investimentoTotal;
	private Double qvi;
	private Double qdc;
	private Double qdComp;

	/**
	 * Método construtor de Relatorio anuncio vo
	 * 
	 * @param nomeAnuncio
	 * @param investimentoTotal
	 * @param qvi
	 * @param qdc
	 * @param qdComp
	 */
	public RelatorioDeAnuncioVo(String nomeAnuncio, Double investimentoTotal, Double qvi, Double qdc, Double qdComp) {
		this.nomeAnuncio = nomeAnuncio;
		this.investimentoTotal = investimentoTotal;
		this.qvi = qvi;
		this.qdc = qdc;
		this.qdComp = qdComp;
	}

	/**
	 * Método que retorna o nomeAnuncio.
	 * 
	 * @return retorna o nomeAnuncio.
	 */
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	/**
	 * Método que retorna o investimentoTotal.
	 * 
	 * @return retorna o investimentoTotal.
	 */
	public Double getInvestimentoTotal() {
		return investimentoTotal;
	}

	/**
	 * Método que retorna o quantidade de visualizações.
	 * 
	 * @return retorna a quantidade de visualizações.
	 */
	public Double getQvi() {
		return qvi;
	}

	/**
	 * Método que retorna a quantidade de cliques por visualização.
	 * 
	 * @return retorna a quantidade de cliques por visualização.
	 */
	public Double getQdc() {
		return qdc;
	}

	/**
	 * Método que retorna a quantidade de compartilhamentos.
	 * 
	 * @return retorna a quantidade de compartilhamentos.
	 */
	public Double getQdComp() {
		return qdComp;
	}

	/**
	 * Método que sobescreve o toString gerando um formato para um
	 * relatorioDeAnuncio
	 */
	@Override
	public String toString() {
		return "RelatorioDeAnuncioVo [nomeAnuncio=" + nomeAnuncio + ", investimentoTotal=" + investimentoTotal
				+ ", quantidadeDeVisualizacoes =" + qvi + ", quantidadeCliquesVisualizacao =" + qdc
				+ ", quantidadeCompartilhamento =" + qdComp + "]";
	}

}
