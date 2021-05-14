package br.com.divulgaTudo.desafio.juan.part2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.divulgaTudo.desafio.juan.part2.model.Anuncio;
import br.com.divulgaTudo.desafio.juan.part2.model.CalculadoraDeAlcanceAnuncios;
import br.com.divulgaTudo.desafio.juan.part2.model.Cliente;

/**
 * Data 05/05/2021 classe CalculadoraDeAlcanceAnunciosTest responsável por todos
 * os testes, relacionadas a anúncios.
 * 
 * @author juan
 * @version 1.0
 */
public class CalculadoraDeAlcanceAnunciosTest {

	/**
	 * Metodo de teste que verifica o resultado da formula: valorInvestido * 30, e
	 * retorna a quantidade de visualizações.
	 * 
	 */
	@Test
	public void valorDeInvestimento() {
		Cliente cliente = new Cliente("JUAN");
		Anuncio anuncio = new Anuncio("CELULAR", cliente, null, null, null);
		CalculadoraDeAlcanceAnuncios anuncios = new CalculadoraDeAlcanceAnuncios("CELULAR", 1.0, anuncio);
		Double visualizacoes = anuncios.quantidadeDeVisualizacoes(anuncios.getValorInvestimento());
		assertEquals(30.0, visualizacoes);
	}

	/**
	 * Metodo de teste que verifica o resultado da formula: (qvi * 12) / 100, e
	 * retorna a quantidade de cliques por visualização.
	 */
	@Test
	public void quantidadeCliquesVisualizacao() {
		Cliente cliente = new Cliente("JUAN");
		Anuncio anuncio = new Anuncio("CELULAR", cliente, null, null, null);
		CalculadoraDeAlcanceAnuncios anuncios = new CalculadoraDeAlcanceAnuncios("CELULAR", 1.0, anuncio);
		Double quantidadeCliquesVisualizacao = anuncios
				.quantidadeCliquesVisualizacao(anuncios.getQuantidadeDeVisualizacoes());
		assertEquals(3.6, quantidadeCliquesVisualizacao);

	}

	/**
	 * Metodo de teste que verifica o resultado da formula: (qdc * 3) / 20, retorna
	 * a quantidade de compartilhamento.
	 */
	@Test
	public void quantidadeCompartilhamento() {
		Cliente cliente = new Cliente("JUAN");
		Anuncio anuncio = new Anuncio("CELULAR", cliente, null, null, null);
		CalculadoraDeAlcanceAnuncios anuncios = new CalculadoraDeAlcanceAnuncios("CELULAR", 1.0, anuncio);
		Double quantidadeCompartilhamento = anuncios
				.quantidadeCompartilhamento(anuncios.getQuantidadeCliquesVisualizacao());
		assertEquals(0.54, quantidadeCompartilhamento);

	}

	/**
	 * Metodo de teste que verifica o resultado da formula: qdComp * 40, e retorna a
	 * quantidade de visualização por compartilhamento.
	 */
	@Test
	public void quantidadeVisualizacaoCompartilhamento() {
		Cliente cliente = new Cliente("JUAN");
		Anuncio anuncio = new Anuncio("CELULAR", cliente, null, null, null);
		CalculadoraDeAlcanceAnuncios anuncios = new CalculadoraDeAlcanceAnuncios("CELULAR", 1.0, anuncio);
		Double quantidadeVisualizacaoCompartilhamento = anuncios
				.quantidadeVisualizacaoCompartilhamento(anuncios.getQuantidadeCompartilhamento());
		assertEquals(21.6, quantidadeVisualizacaoCompartilhamento);

	}

	/**
	 * Metodo de teste que verifica a quantidade aproximado de visualizações, e
	 * retorna a quantidade aproximada de visualização total.
	 */
	@Test
	public void quantidadeAproximadaDeVis() {
		Cliente cliente = new Cliente("JUAN");
		Anuncio anuncio = new Anuncio("CELULAR", cliente, null, null, null);
		CalculadoraDeAlcanceAnuncios anuncios = new CalculadoraDeAlcanceAnuncios("CELULAR", 1.0, anuncio);
		Double quantidadeAproximadaDeVis = anuncios
				.quantidadeAproximadaDeVis(anuncios.getQuantidadeVisualizacaoCompartilhamento());
		assertEquals(83.80800000000002, quantidadeAproximadaDeVis);

	}

}
