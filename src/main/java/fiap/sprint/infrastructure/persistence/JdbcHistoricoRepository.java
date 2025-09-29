package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.repository.HistoricoRepository;

public class JdbcHistoricoRepository implements HistoricoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcHistoricoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
