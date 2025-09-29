package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.UsuarioRepository;

public class JdbcAgendamentoRepository implements AgendamentoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcAgendamentoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
