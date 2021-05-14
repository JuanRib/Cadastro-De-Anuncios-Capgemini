package br.com.divulgaTudo.desafio.juan.part2.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Data 05/05/2021 Classe modelo que representa um anuncio
 * 
 * @author Juan
 *
 */
@Entity
@Table(name = "anuncio")
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeAnuncio;
	@ManyToOne
	private Cliente cliente;
	@Column(name = "data_de_inicio")
	private Date dataDeInicio;
	@Column(name = "data_de_termino")
	private Date dataDeTermino;
	@Column(name = "investimento_por_dia")
	private Double investimentoPorDia;

	/**
	 * Construtor vazio
	 */
	public Anuncio() {
	}

	/**
	 * Construtor que recebe as variaveis anteriomente citadas
	 * 
	 * @param nomeAnuncio
	 * @param cliente
	 * @param investimentoPorDia
	 * @param dataDeInicio
	 * @param dataDeTermino
	 */
	public Anuncio(String nomeAnuncio, Cliente cliente, Double investimentoPorDia, Date dataDeInicio,
			Date dataDeTermino) {
		this.nomeAnuncio = nomeAnuncio;
		this.dataDeInicio = dataDeInicio;
		this.dataDeTermino = dataDeTermino;
		this.cliente = cliente;
		this.investimentoPorDia = investimentoPorDia;
	}

	/**
	 * Método que retorna o id gerado pelo banco.
	 * 
	 * @return retorna id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Método que define um valor para variavel id.
	 * 
	 * @param id.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método que retorna o nome do anuncio.
	 * 
	 * @return retorna nomeAnuncio.
	 */
	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	/**
	 * Método que define um valor para variavel nomeAnuncio.
	 * 
	 * @param nomeAnuncio.
	 */
	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	/**
	 * Método que retorna a data de inicio.
	 * 
	 * @return retorna dataDeInicio.
	 */
	public Date getDataDeInicio() {
		return dataDeInicio;
	}

	/**
	 * Método que define um valor para variavel dataDeInicio.
	 * 
	 * @param dataDeInicio.
	 */
	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	/**
	 * Método que retorna a data de termino.
	 * 
	 * @return retorna dataDeTermino.
	 */
	public Date getDataDeTermino() {
		return dataDeTermino;
	}

	/**
	 * Método que define um valor para variavel dataDeTermino.
	 * 
	 * @param dataDeTermino.
	 */
	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}

	/**
	 * Método que retorna o investimento por dia.
	 * 
	 * @return retorna investimentoPorDia.
	 */
	public Double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	/**
	 * Método que define um valor para variavel investimentoPorDia.
	 * 
	 * @param investimentoPorDia.
	 */
	public void setInvestimentoPorDia(Double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}

	/**
	 * Método que retorna o cliente.
	 * 
	 * @return retorna cliente.
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Método que define um valor para variavel cliente.
	 * 
	 * @param cliente.
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Método que sobescreve o toString.
	 */
	@Override
	public String toString() {
		return getNomeAnuncio();
	}

}
