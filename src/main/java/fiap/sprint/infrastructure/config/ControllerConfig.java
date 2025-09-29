package fiap.sprint.infrastructure.config;

import fiap.sprint.domain.service.AcessoService;
import fiap.sprint.domain.service.PerguntaService;
import fiap.sprint.domain.service.UsuarioService;
import fiap.sprint.interfaces.*;
import jakarta.enterprise.context.ApplicationScoped;

public class ControllerConfig {

    @ApplicationScoped
    public AcessoController acessoController(AcessoService acessoService) {
        return new AcessoControllerImpl(acessoService);
    }

    @ApplicationScoped
    public AcessoController acessoController(AcessoService acessoService) {
        return new AcessoControllerImpl(acessoService);
    }

    @ApplicationScoped
    public AcessoController acessoController(AcessoService acessoService) {
        return new AcessoControllerImpl(acessoService);
    }

    @ApplicationScoped
    public PerguntaController perguntaController(PerguntaService perguntaService) {
        return new PerguntaControllerImpl(perguntaService);
    }

    @ApplicationScoped
    public UsuarioController usuarioController(UsuarioService usuarioService) {
        return new UsuarioControllerImpl(usuarioService);
    }
}
