package br.com.lucasmancan.app;

import br.com.lucasmancan.utils.HibernateUtil;

public class GerarTabelas {
	
	
	public static void main (String[]args){
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.shutdown();
	}
	
}
