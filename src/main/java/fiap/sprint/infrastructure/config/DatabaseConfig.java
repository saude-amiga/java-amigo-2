package fiap.sprint.infrastructure.config;

import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.HistoricoRepository;
import fiap.sprint.domain.repository.PerguntaRepository;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.infrastructure.persistence.*;
import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DatabaseConfig {

    @ApplicationScoped
    public DatabaseConnection databaseConnection(AgroalDataSource dataSource) {
        return new DatabaseConnectionImpl(dataSource);
    }

    @ApplicationScoped
    public AgendamentoRepository agendamentoRepository(DatabaseConnection databaseConnection) {
        return new JdbcAgendamentoRepository(databaseConnection);
    }

    @ApplicationScoped
    public HistoricoRepository historicoRepository(DatabaseConnection databaseConnection) {
        return new JdbcHistoricoRepository(databaseConnection);
    }

    @ApplicationScoped
    public PerguntaRepository perguntaRepository(DatabaseConnection databaseConnection) {
        return new JdbcPerguntaRepository(databaseConnection);
    }

    @ApplicationScoped
    public UsuarioRepository usuarioRepository(DatabaseConnection databaseConnection) {
        return new JdbcUsuarioRepository(databaseConnection);
    }

}