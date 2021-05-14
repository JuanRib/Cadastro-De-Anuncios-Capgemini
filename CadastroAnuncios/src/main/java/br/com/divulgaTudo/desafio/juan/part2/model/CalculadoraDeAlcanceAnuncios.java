package br.com.divulgaTudo.desafio.juan.part2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Data 05/05/2021 Classe modelo que representa a Calculadora de alcance de
 * anuncios.
 * 
 * @author Juan
 *
 */
@Entity
@Table(name = "calculadora_Alcance")
public class CalculadoraDeAlcanceAnuncios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoAnuncio;
	private Double valorInvestimento;
	private Double quantidadeDeVisualizacoes;
	private Double quantidadeCliquesVisualizacao;
	private Double quantidadeCompartilhamento;
	private Double quantidadeVisualizacaoCompartilhamento;
	private Double quantidadeAproximadaDeVis;

	@ManyToOne
	private Anuncio anuncio;

	/**
	 * Construtor vazio
	 */
	public CalculadoraDeAlcanceAnuncios() {
	}

	/**
	 * Construtor que recebe as vari�veis nomeAnuncio, valorInvestimento e anuncio,
	 * Al�m de inicializar demais vari�veis da classe.
	 * 
	 * @param nomeDoAnuncio
	 * @param valorInvestimento
	 * @param anuncio
	 */
	public CalculadoraDeAlcanceAnuncios(String nomeDoAnuncio, Double valorInvestimento, Anuncio anuncio) {
		this.setValorInvestimento(valorInvestimento);
		this.anuncio = anuncio;
		this.nomeDoAnuncio = nomeDoAnuncio;
		this.quantidadeDeVisualizacoes = quantidadeDeVisualizacoes(valorInvestimento);
		this.quantidadeCliquesVisualizacao = quantidadeCliquesVisualizacao(quantidadeDeVisualizacoes);
		this.quantidadeCompartilhamento = quantidadeCompartilhamento(quantidadeCliquesVisualizacao);
		this.quantidadeVisualizacaoCompartilhamento = quantidadeVisualizacaoCompartilhamento(
				quantidadeCompartilhamento);
		this.quantidadeAproximadaDeVis = quantidadeAproximadaDeVis(quantidadeVisualizacaoCompartilhamento);

	}

	/**
	 * M�todo que retorna a quantidade de visualiza��es.
	 * 
	 * @return retorna quantidadeDeVisualizacoes.
	 */
	public Double getQuantidadeDeVisualizacoes() {
		return quantidadeDeVisualizacoes;
	}

	/**
	 * M�todo que retorna a quantidade de cliques por visualiza��es.
	 * 
	 * @return retorna quantidadeCliquesVisualizacao.
	 */
	public Double getQuantidadeCliquesVisualizacao() {
		return quantidadeCliquesVisualizacao;
	}

	/**
	 * M�todo que retorna a quantidade de compartilhamento.
	 * 
	 * @return retorna compartilhamento.
	 */
	public Double getQuantidadeCompartilhamento() {
		return quantidadeCompartilhamento;
	}

	/**
	 * M�todo que retorna a quantidade de visualiza��o por compartilhamento.
	 * 
	 * @return retorna quantidadeVisualizacaoCompartilhamento.
	 */
	public Double getQuantidadeVisualizacaoCompartilhamento() {
		return quantidadeVisualizacaoCompartilhamento;
	}

	/**
	 * M�todo que retorna o valor de investimento.
	 * 
	 * @return retorna valorInvestimento.
	 */
	public Double getValorInvestimento() {
		return valorInvestimento;
	}

	/**
	 * M�todo que define um valor para variavel valorInvestimento.
	 * 
	 * @param valorInvestimento.
	 */
	public void setValorInvestimento(Double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}

	/**
	 * M�todo que retorna a quantidade aproximada de visualiza��o.
	 * 
	 * @return retorna quantidadeAproximadaDeVis.
	 */
	public Double getQuantidadeAproximadaDeVis() {
		return quantidadeAproximadaDeVis;
	}

	/**
	 * Faz calculo de quantidade de visualiza��es.
	 * 
	 * @param valorInvestido valor informado do tipo double.
	 * @return retorna quantidade de visualiza��es.
	 */
	public Double quantidadeDeVisualizacoes(Double valorInvestido) {
		if (valorInvestido > 0) {
			Double qvi = valorInvestido * 30;
			return qvi;
		}
		return null;

	}

	/**
	 * Faz calculo da quantidade de cliques por visualiza��o.
	 * 
	 * @param qvi vari�vel que representa a quantidade de vizualiza��es.
	 * @return retorna a quantidade de cliques por visualiza��o.
	 */
	public Double quantidadeCliquesVisualizacao(Double qvi) {
		if (qvi > 0) {
			Double qdc = (qvi * 12) / 100;
			return qdc;
		}
		return null;

	}

	/**
	 * Faz calculo da quantidade de compartilhamento.
	 * 
	 * @param qdc vari�vel que quantidade de cliques por visualiza��o.
	 * @return retorna a quantidade de compartilhamento.
	 */
	public Double quantidadeCompartilhamento(Double qdc) {
		if (qdc > 0) {
			Double qdComp = (qdc * 3) / 20;
			return qdComp;
		}
		return null;

	}

	/**
	 * Faz o calculo da quantidade de visualiza�ao por compartilhamento.
	 * 
	 * @param qdComp vari�vel que representa a quantidade de compartilhamento.
	 * @return retorna a quantidade de visualizacao por compartilhamento.
	 */
	public Double quantidadeVisualizacaoCompartilhamento(Double qdComp) {
		if (qdComp > 0) {
			Double qvpc = qdComp * 40;
			return qvpc;
		}
		return null;

	}

	/**
	 * Faz o calculo da quantidade aproximada de visualiza��es.
	 * 
	 * @param qvpc vari�vel que representa a quantidade de visualizacao por,
	 *             compartilhamento.
	 * @return retorna a quantidade de aproximada de visualiza��es.
	 */
	public Double quantidadeAproximadaDeVis(Double qvpc) {
		if (qvpc > 0) {
			Double valorAproximado = qvpc;
			for (int i = 0; i <= 3; i++) {
				Double quantidadeCliquesVisualizacao = quantidadeCliquesVisualizacao(qvpc);
				Double quantidadeCompartilhamento = quantidadeCompartilhamento(quantidadeCliquesVisualizacao);
				valorAproximado += quantidadeVisualizacaoCompartilhamento(quantidadeCompartilhamento);
			}
			return valorAproximado;

		}
		return null;

	}

	/**
	 * M�todo que retorna o nome do anuncio.
	 * 
	 * @return retorna nomeDoAnuncio.
	 */
	public String getNomeDoAnuncio() {
		return nomeDoAnuncio;
	}

	/**
	 * M�todo que define um valor para variavel nomeDoAnuncio.
	 * 
	 * @param nomeDoAnuncio.
	 */
	public void setNomeDoAnuncio(String nomeDoAnuncio) {
		this.nomeDoAnuncio = nomeDoAnuncio;
	}

}
