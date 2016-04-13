package br.com.calcularota.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.calcularota.entities.Mapa;
import br.com.calcularota.service.MapaService;

@RequestScoped
@Path("cadastrar")
public class CadastrarMapaRest {

	@Inject
	private MapaService mapaService;

	@Path("/mapas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarMapas() {
		List<Mapa> mapas = mapaService.findAllMapas();
		return Response.status(200).entity(mapas).build();
	}

	@Path("/mapa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarMapa(Mapa mapa) {
		mapaService.save(mapa);
		return Response.status(201).build();
	}

	@Path("/mapa/{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarMapa(@PathParam("id") Integer id, Mapa mapa) {

		Mapa mapaExiste = mapaService.findMapa(mapa);

		if (mapaExiste == null) {
			return Response.status(404).build();
		}

		mapaExiste.setMapa(mapa.getMapa());
		mapaExiste.setOrigem(mapa.getOrigem());
		mapaExiste.setDestino(mapa.getDestino());
		mapaExiste.setDistancia(mapa.getDistancia());

		mapaService.atualizar(mapaExiste);

		return Response.status(201).build();

	}

	@Path("/mapa/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response excluirUsuario(@PathParam("id") Integer id) {

		Mapa mapaExiste = mapaService.findMapaById(id);

		if (mapaExiste == null) {
			return Response.status(404).build();
		}

		mapaService.excluir(mapaExiste);

		return Response.status(201).build();

	}

}
