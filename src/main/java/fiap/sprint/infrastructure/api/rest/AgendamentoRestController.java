package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.interfaces.AgendamentoController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/agendamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AgendamentoRestController {
    private final AgendamentoController AgendamentoController;
}
