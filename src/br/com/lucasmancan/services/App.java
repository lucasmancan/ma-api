package br.com.lucasmancan.services;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class App extends Application {

	private Set<Class<?>> classes;

	public Set<Class<?>> getClasses() {
		if (classes == null) {
			classes = new HashSet<>();
			classes.add(PessoaWebService.class);
		}

		return classes;
	}
}
