package br.com.lucasmancan.testes;

import org.junit.Test;

import br.com.lucasmancan.utils.HibernateUtil;

public class GerarTabelas {
	
	@Test
	public  void gerarTabelas (){
		HibernateUtil.getSessionFactory();
		HibernateUtil.shutdown();
	}
	
}
