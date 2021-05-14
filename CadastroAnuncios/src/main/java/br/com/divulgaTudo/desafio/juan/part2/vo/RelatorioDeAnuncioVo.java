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
	 * M�todo construtor de Relatorio anuncio vo
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
	 * M�todo que retorna o nomeAnuncio.
	 * 
	 * @return retorna o nomeAnuncio.
	 */
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	/**
	 * M�todo que retorna o investimentoTotal.
	 * 
	 * @return retorna o investimentoTotal.
	 */
	public Double getInvestimentoTotal() {
		return investimentoTotal;
	}

	/**
	 * M�todo que retorna o quantidade de visualiza��es.
	 * 
	 * @return retorna a quantidade de visualiza��es.
	 */
	public Double getQvi() {
		return qvi;
	}

	/**
	 * M�todo que retorna a quantidade de cliques por visualiza��o.
	 * 
	 * @return retorna a quantidade de cliques por visualiza��o.
	 */
	public Double getQdc() {
		return qdc;
	}

	/**
	 * M�todo que retorna a quantidade de compartilhamentos.
	 * 
	 * @return retorna a quantidade de compartilhamentos.
	 */
	public Double getQdComp() {
		return qdComp;
	}

	/**
	 * M�todo que sobescreve o toString gerando um formato para um
	 * relatorioDeAnuncio
	 */
	@Override
	public String toString() {
		return "RelatorioDeAnuncioVo [nomeAnuncio=" + nomeAnuncio + ", investimentoTotal=" + investimentoTotal
				+ ", quantidadeDeVisualizacoes =" + qvi + ", quantidadeCliquesVisualizacao =" + qdc
				+ ", quantidadeCompartilhamento =" + qdComp + "]";
	}

}
