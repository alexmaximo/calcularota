package br.com.calcularota.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RestConfiguration extends ResourceConfig {

	public RestConfiguration() {
		packages(this.getClass().getPackage().getName());
		register(JacksonFeature.class);
	}

}
