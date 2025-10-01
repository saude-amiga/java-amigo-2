package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.infrastructure.exceptions.InfraestruturaException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class JdbcAgendamentoRepository implements AgendamentoRepository {

    private final DatabaseConnection databaseConnection;

    public JdbcAgendamentoRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void confirmarAgendamento(int agendamentoId, Date data) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sqlAgendamento = """
                    UPDATE AGENDAMENTOS SET CONFIRMADO = ?, DATA=? WHERE ID = ?
                    """;

            preparedStatement = connection.prepareStatement(sqlAgendamento);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setDate(2, (java.sql.Date) data);
            preparedStatement.setInt(3, agendamentoId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao atualizar agendamento, nenhuma linha afetada");
            }

            final Long usuarioId;

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuarioId = generatedKeys.getLong(1);
                } else {
                    connection.rollback();
                    throw new InfraestruturaException("Erro ao salvar contrato, nenhuma linha foi afetada");
                }
            } catch (InfraestruturaException e) {
                throw new RuntimeException(e);
            }
            connection.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (InfraestruturaException e) {
                throw new RuntimeException(e);
            }
        }
    @Override
    public void criarAgendamento(String conteudo){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sqlAgendamento = """
                    UPDATE AGENDAMENTOS SET CONFIRMADO = ?, DATA=? WHERE ID = ?
                    """;

            preparedStatement = connection.prepareStatement(sqlAgendamento);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setDate(2, (java.sql.Date) data);
            preparedStatement.setInt(3, agendamentoId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao atualizar agendamento, nenhuma linha afetada");
            }

            final Long usuarioId;

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuarioId = generatedKeys.getLong(1);
                } else {
                    connection.rollback();
                    throw new InfraestruturaException("Erro ao salvar contrato, nenhuma linha foi afetada");
                }
            } catch (InfraestruturaException e) {
                throw new RuntimeException(e);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InfraestruturaException e) {
            throw new RuntimeException(e);
        }
    }
}


