package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.interfaces.HistoricoController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/historico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HistoricoRestController {
    private final HistoricoController historicoController;
}
