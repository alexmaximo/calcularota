package br.com.calcularota.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.calcularota.entities.Mapa;
import br.com.calcularota.service.RotaService;

@RequestScoped
@Path("calcular")
public class CalcularRotaRest {

	@Inject
	private RotaService rotaService;

	@Path("/rotas")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listarRotas(Mapa mapa) {
		List<Mapa> rotas = rotaService.calcularRota(mapa);
		return Response.status(200).entity(rotas).build();
	}

}
