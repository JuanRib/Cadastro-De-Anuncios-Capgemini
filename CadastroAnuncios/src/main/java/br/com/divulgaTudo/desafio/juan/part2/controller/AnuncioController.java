package br.com.divulgaTudo.desafio.juan.part2.controller;

import java.sql.Date;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.divulgaTudo.desafio.juan.part2.dao.AnuncioDao;
import br.com.divulgaTudo.desafio.juan.part2.dao.CalculadoraDeAlcanceAnunciosDao;
import br.com.divulgaTudo.desafio.juan.part2.dao.ClienteDao;
import br.com.divulgaTudo.desafio.juan.part2.model.Anuncio;
import br.com.divulgaTudo.desafio.juan.part2.model.CalculadoraDeAlcanceAnuncios;
import br.com.divulgaTudo.desafio.juan.part2.model.Cliente;
import br.com.divulgaTudo.desafio.juan.part2.util.CriarEntityManagerUtil;
import br.com.divulgaTudo.desafio.juan.part2.vo.RelatorioDeAnuncioVo;

/**
 * Data 06/05/2021 Classe anuncio é responsável por popular o banco de dados,
 * relacionadas a anúncios e apresentar os resultados dos filtros no console.
 * 
 * @author juan
 * @version 1.0
 */
public class AnuncioController {

	/**
	 * Faz a chamada do método que popula o banco, e exibe no console os resultados
	 * das consultas e com seus filtros.
	 * 
	 * @param args array de argumentos.
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
                  
		AnuncioPopularBanco();
		
		EntityManager manager = CriarEntityManagerUtil.getEntityManager();

		System.out.println("********************** - SQL SEM FILTRO - **********************");
		CalculadoraDeAlcanceAnunciosDao alcanceAnunciosDao = new CalculadoraDeAlcanceAnunciosDao(manager);
		List<RelatorioDeAnuncioVo> relatorioAlcanceDoAnuncio = alcanceAnunciosDao.RelatorioAlcanceDoAnuncio();
		System.out.println("\"********************** - RESULTADO RELATORIO SEM FILTRO - **********************\"");
		relatorioAlcanceDoAnuncio.forEach(System.out::println);

		System.out.println("********************** - SQL COM FILTRO DE DATA - **********************");
		List<RelatorioDeAnuncioVo> relatorioFiltroData = alcanceAnunciosDao.RelatorioFiltroData(new Date(2021, 04, 30),
				new Date(2021, 05, 30));
		System.out.println(
				"\"********************** - RESULTADO RELATORIO COM FILTRO DE DATA - **********************\"");
		relatorioFiltroData.forEach(System.out::println);

		System.out.println("********************** - SQL COM FILTRO DE CLIENTE - **********************");
		Cliente cliente = manager.find(Cliente.class, 1l);
		List<RelatorioDeAnuncioVo> relatorioPorCliente = alcanceAnunciosDao.RelatorioPorCliente(cliente);
		System.out.println(
				"\"********************** - RESULTADO RELATORIO COM FILTRO DE CLIENTE - **********************\"");
		relatorioPorCliente.forEach(System.out::println);
	}

	/**
	 * Método responsável por inserir dados no banco de dados.
	 */
	@SuppressWarnings({ "deprecation", "resource" })
	public static void AnuncioPopularBanco() {
		// Este metodo popula o banco com anuncios pre-definido,
		// e com um anuncio preenchido atraves do console.
		EntityManager manager = CriarEntityManagerUtil.getEntityManager();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Informe o nome do cliente: ");
		String nomeCliente = scanner.next();
		System.out.println("Informe o nome do anuncio: ");
		String nomeAnuncio = scanner.next();
		System.out.println("Informe o valor investido do anuncio (Colocar valor separado por virgula ex 12,5): ");
		Double valorInvestido = scanner.nextDouble();

		System.out.println("Informe o ano de inicio: ");
		int anoInicio = scanner.nextInt();
		System.out.println("Informe o mes de inicio: ");
		int mesInicio = scanner.nextInt();
		System.out.println("Informe o dia de inicio: ");
		int diaInicio = scanner.nextInt();

		System.out.println("Informe o ano de fim: ");
		int anoFim = scanner.nextInt();
		System.out.println("Informe o mes de fim: ");
		int mesFim = scanner.nextInt();
		System.out.println("Informe o dia de fim: ");
		int diaFim = scanner.nextInt();

		Cliente cliente = new Cliente(nomeCliente);
		Anuncio anuncio = new Anuncio(nomeAnuncio, cliente, valorInvestido, new Date(anoInicio, mesInicio, diaInicio),
				new Date(anoFim, mesFim, diaFim));
		CalculadoraDeAlcanceAnuncios alcanceAnuncios = new CalculadoraDeAlcanceAnuncios(anuncio.getNomeAnuncio(),
				anuncio.getInvestimentoPorDia(), anuncio);

		Cliente clienteJuan = new Cliente("JUAN");
		Anuncio anuncioCelular = new Anuncio("CELULAR", clienteJuan, 100.00, new Date(2021, 04, 30),
				new Date(2021, 05, 30));
		CalculadoraDeAlcanceAnuncios alcanceAnunciosCelular = new CalculadoraDeAlcanceAnuncios(
				anuncioCelular.getNomeAnuncio(), anuncioCelular.getInvestimentoPorDia(), anuncioCelular);

		Cliente clientePablo = new Cliente("PABLO");
		Anuncio anuncioComputador = new Anuncio("COMPUTADOR", clientePablo, 970.00, new Date(2021, 05, 25),
				new Date(2021, 06, 19));
		CalculadoraDeAlcanceAnuncios alcanceAnunciosComputador = new CalculadoraDeAlcanceAnuncios(
				anuncioComputador.getNomeAnuncio(), anuncioComputador.getInvestimentoPorDia(), anuncioComputador);

		Cliente clienteVinicius = new Cliente("VINICIUS");
		Anuncio anuncioVideoGame = new Anuncio("VIDEOGAME", clienteVinicius, 300.00, new Date(2021, 02, 12),
				new Date(2021, 03, 14));
		CalculadoraDeAlcanceAnuncios alcanceAnunciosVideoGame = new CalculadoraDeAlcanceAnuncios(
				anuncioVideoGame.getNomeAnuncio(), anuncioVideoGame.getInvestimentoPorDia(), anuncioVideoGame);

		ClienteDao clienteDao = new ClienteDao(manager);
		AnuncioDao anuncioDao = new AnuncioDao(manager);
		CalculadoraDeAlcanceAnunciosDao calculadoraDeAlcanceAnunciosDao = new CalculadoraDeAlcanceAnunciosDao(manager);

		manager.getTransaction().begin();

		clienteDao.cadastrarCliente(cliente);
		anuncioDao.cadastrarAnuncio(anuncio);
		calculadoraDeAlcanceAnunciosDao.cadastrarCalculadoraDeAlcanceAnuncios(alcanceAnuncios);

		clienteDao.cadastrarCliente(clienteJuan);
		anuncioDao.cadastrarAnuncio(anuncioCelular);
		calculadoraDeAlcanceAnunciosDao.cadastrarCalculadoraDeAlcanceAnuncios(alcanceAnunciosCelular);

		clienteDao.cadastrarCliente(clientePablo);
		anuncioDao.cadastrarAnuncio(anuncioComputador);
		calculadoraDeAlcanceAnunciosDao.cadastrarCalculadoraDeAlcanceAnuncios(alcanceAnunciosComputador);

		clienteDao.cadastrarCliente(clienteVinicius);
		anuncioDao.cadastrarAnuncio(anuncioVideoGame);
		calculadoraDeAlcanceAnunciosDao.cadastrarCalculadoraDeAlcanceAnuncios(alcanceAnunciosVideoGame);

		manager.getTransaction().commit();

		manager.close();

	}

}