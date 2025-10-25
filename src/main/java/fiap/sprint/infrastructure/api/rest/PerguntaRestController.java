package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.interfaces.PerguntaController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Pergunta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerguntaRestController {
    private final PerguntaController perguntaController;
    public PerguntaRestController(PerguntaController perguntaController){
        this.perguntaController = perguntaController;
    }
}
