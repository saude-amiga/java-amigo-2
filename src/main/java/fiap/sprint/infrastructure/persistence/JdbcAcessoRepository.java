package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.repository.AcessoRepository;

public class JdbcAcessoRepository implements AcessoRepository {
    private final DatabaseConnection databaseConnection;
    public JdbcAcessoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
