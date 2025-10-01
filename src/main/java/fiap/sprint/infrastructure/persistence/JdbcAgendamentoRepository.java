package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.model.Agendamento;
import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.repository.AgendamentoRepository;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.infrastructure.exceptions.AgendamentoException;
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
                    UPDATE AGENDAMENTO SET CONFIRMADO = ? WHERE ID = ?
                    """;

            preparedStatement = connection.prepareStatement(sqlAgendamento);
            preparedStatement.setString(1, "Y");
            preparedStatement.setInt(2, agendamentoId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao atualizar agendamento, nenhuma linha afetada");
            }

//            final Long agendamentoIdRecebido;
//
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    agendamentoIdRecebido = generatedKeys.getLong(1);
//                } else {
//                    connection.rollback();
//                    throw new InfraestruturaException("Erro ao salvar contrato, nenhuma linha foi afetada");
//                }
//            } catch (InfraestruturaException e) {
//                throw new RuntimeException(e);
//            }
            connection.commit();
            } catch (SQLException | InfraestruturaException e) {
                throw new RuntimeException(e);
            }finally {
            if (preparedStatement != null) {
                try { preparedStatement.close(); } catch (SQLException e) { throw new AgendamentoException("Erro ao fechar a querie em agendamento"); }
            }
            if (connection != null) {
                try { connection.close(); } catch (SQLException e) { throw new AgendamentoException("Erro ao fechar a conexão com a tabela de agendamento"); }
            }
        }
    }


    @Override
    public Agendamento criarAgendamento(Date data, String conteudo, int pacienteId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        Long agendamentoId = null;
        try {
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sqlAgendamento = """
                    INSERT INTO AGENDAMENTO (DATA, DESCRICAO, PACIENTE_ID)
                    VALUES (?, ?, ?)
                    """;

            preparedStatement = connection.prepareStatement(sqlAgendamento);
            preparedStatement.setDate(1, (java.sql.Date) data);
            preparedStatement.setString(2, conteudo);
            preparedStatement.setInt(3, pacienteId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao inserir agendamento, nenhuma linha afetada");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    agendamentoId = generatedKeys.getLong(1);
                } else {
                    connection.rollback();
                    throw new InfraestruturaException("Erro ao salvar agendamento, nenhuma linha foi afetada");
                }
            } catch (InfraestruturaException e) {
                throw new RuntimeException(e);
            }
            connection.commit();
        } catch (SQLException | InfraestruturaException e) {
            throw new RuntimeException(e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new AgendamentoException("Erro ao fechar a querie em agendamento");
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new AgendamentoException("Erro ao fechar a conexão com a tabela de agendamento");
                }
            }
        }
        return new Agendamento(agendamentoId.intValue(), conteudo, data, pacienteId );
    }

    @Override
    public Agendamento getAgendamento(int agendamentoId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.databaseConnection.getConnection();

            String sql = """
                SELECT ID, DATA, DESCRICAO, PACIENTE_ID, CONFIRMADO
                FROM AGENDAMENTO
                WHERE ID = ?
                """;

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, agendamentoId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setId(resultSet.getInt("ID"));
                agendamento.setData(resultSet.getDate("DATA"));
                agendamento.setDescricao(resultSet.getString("DESCRICAO"));
                agendamento.setPacienteId(resultSet.getInt("PACIENTE_ID"));
                // convert 'Y'/'N' to boolean
                String confirmado = resultSet.getString("CONFIRMADO");
                agendamento.setConfirmado("Y".equalsIgnoreCase(confirmado));

                return agendamento;
            } else {
                return null; // or throw exception if preferred
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new AgendamentoException("Erro ao fechar a querie em agendamento");
            }
        }
    }

}


