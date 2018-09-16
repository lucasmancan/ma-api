import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class App extends Application {

	private Set<Class<?>> classes;

	public Set<Class<?>> getClasses() {
		if (classes == null) {
			classes = new HashSet<>();
			classes.add(Pessoa.class);
		}

		return classes;
	}
}
