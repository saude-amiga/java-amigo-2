package fiap.sprint.infrastructure.config;

import fiap.sprint.application.*;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.HistoricoRepository;
import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.domain.service.*;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceConfig {

    @ApplicationScoped
    public AcessoService acessoService(HistoricoRepository historicoRepository) {
        return new AcessoServiceImpl(historicoRepository);
    }

    @ApplicationScoped
    public AgendamentoService agendamentoService(AgendamentoRepository agendamentoRepository) {
        return new AgendamentoServiceImpl(agendamentoRepository);
    }

    @ApplicationScoped
    public HistoricoService historicoService(HistoricoRepository historicoRepository) {
        return new HistoricoServiceImpl(historicoRepository);
    }

    @ApplicationScoped
    public PerguntaService perguntaService(PerguntaRepository perguntaRepository) {
        return new PerguntaServiceImpl(perguntaRepository);
    }

    @ApplicationScoped
    public UsuarioService usuarioService(UsuarioRepository usuarioRepository) {
        return new UsuarioServiceImpl(usuarioRepository);
    }
}
