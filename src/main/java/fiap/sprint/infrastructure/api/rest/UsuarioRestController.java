package fiap.sprint.infrastructure.api.rest;

import fiap.sprint.interfaces.UsuarioController;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestController {

    private final UsuarioController usuarioController;
    public UsuarioRestController(UsuarioController usuarioController){
        this.usuarioController = usuarioController;
    }
}
