package fi.agileo.javaee.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;

public class CalculatorApp extends ResourceConfig {

	public CalculatorApp() {
		packages("fi.agileo.javaee");
	}
}
