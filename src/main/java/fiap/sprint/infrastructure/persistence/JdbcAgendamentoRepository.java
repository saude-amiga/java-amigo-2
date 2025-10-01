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
import java.util.ArrayList;
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
                    INSERT INTO AGENDAMENTO (DATA, DESCRICAO, PACIENTEID)
                    VALUES (?, ?, ?)
                    """;

            preparedStatement = connection.prepareStatement(sqlAgendamento, new String[]{"ID"}  );
            preparedStatement.setDate(1, new java.sql.Date(data.getTime()));
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
                SELECT ID, DATA, DESCRICAO, PACIENTEID, CONFIRMADO
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

    @Override
    public ArrayList<Agendamento> listarAgendamentos() {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT ID, DATA, DESCRICAO, PACIENTEID, CONFIRMADO FROM Agendamento";

        try (
                Connection connection = this.databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                Date data = resultSet.getDate("DATA"); // java.sql.Date
                String descricao = resultSet.getString("DESCRICAO");
                int pacienteId = resultSet.getInt("PACIENTEID");
                String confirmado = resultSet.getString("CONFIRMADO");

                boolean isConfirmado = "Y".equalsIgnoreCase(confirmado);

                Agendamento agendamento = new Agendamento(id, data, descricao, pacienteId, isConfirmado);
                agendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar agendamentos", e);
        }
        return agendamentos;
    }

    @Override
    public void deletarAgendamento(int idAgendamento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "DELETE FROM AGENDAMENTO WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idAgendamento);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Nenhum agendamento encontrado com ID: " + idAgendamento);
            }

            connection.commit();
        } catch (SQLException | InfraestruturaException e) {
            throw new RuntimeException("Erro ao deletar agendamento", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new AgendamentoException("Erro ao fechar a query em agendamento");
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
    }

}


