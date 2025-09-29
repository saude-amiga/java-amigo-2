package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.repository.PerguntaRepository;

public class JdbcPerguntaRepository implements PerguntaRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcPerguntaRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
