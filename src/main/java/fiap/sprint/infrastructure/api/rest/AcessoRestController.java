package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.interfaces.AcessoController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Acesso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcessoRestController {
    private final AcessoController acessoController;
    public AcessoRestController(AcessoController acessoController){
        this.acessoController = acessoController;
    }
}
