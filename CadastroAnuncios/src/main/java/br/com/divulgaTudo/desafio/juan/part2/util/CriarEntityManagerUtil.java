package br.com.divulgaTudo.desafio.juan.part2.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Data 05/05/2021 Classe que cria uma EntityManager.
 * 
 * @author Juan
 *
 */
public class CriarEntityManagerUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("DivulgaTudoParte2");;

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();

	}
}
