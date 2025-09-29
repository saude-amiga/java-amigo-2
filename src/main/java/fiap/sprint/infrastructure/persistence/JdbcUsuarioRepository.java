package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.repository.UsuarioRepository;

public class JdbcUsuarioRepository implements UsuarioRepository {
    private final DatabaseConnection databaseConnection;

    public JdbcUsuarioRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
