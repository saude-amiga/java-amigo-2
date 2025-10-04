package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.infrastructure.exceptions.InfraestruturaException;
import oracle.jdbc.proxy.annotation.Pre;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUsuarioRepository implements UsuarioRepository {
    private final String tableNome = "USUARIOSAUDE";
    private final DatabaseConnection databaseConnection;

    public JdbcUsuarioRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Usuario criarUsuario(String nome, String email, String senha) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sqlUsuario = "INSERT INTO "+tableNome+" (NAME, EMAIL, SENHA) VALUES (?, ?, ?) ";
            preparedStatement = connection.prepareStatement(sqlUsuario, new String[]{"ID"});
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao inserir novo usuário, nenhuma linha afetada");
            }
            int usuarioId;
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuarioId = generatedKeys.getBigDecimal(1).toBigInteger().intValue();
                } else {
                    connection.rollback();
                    throw new InfraestruturaException("Erro ao salvar usuário, nenhum ID gerado");
                }
            }
            connection.commit();
            return new Usuario(usuarioId, nome, email, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InfraestruturaException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alterarSenha(int id, String senha) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = this.databaseConnection.getConnection();
        connection.setAutoCommit(false);

        String sql = "UPDATE " + tableNome + " SET SENHA = ? WHERE ID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, senha);
        preparedStatement.setInt(2, id);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            connection.rollback();
            throw new InfraestruturaException("Erro ao atualizar senha, nenhum usuário encontrado com o ID: " + id);
        }

        connection.commit();

    } catch (SQLException | InfraestruturaException e) {
        throw new RuntimeException(e);
    } finally {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public void alterarEmail(int id, String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "UPDATE " + tableNome + " SET EMAIL = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao atualizar email, nenhum usuário encontrado com o ID: " + id);
            }

            connection.commit();

        } catch (SQLException | InfraestruturaException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void alterarNome(int id, String nome) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.databaseConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "UPDATE " + tableNome + " SET NAME = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao atualizar nome, nenhum usuário encontrado com o ID: " + id);
            }

            connection.commit();

        } catch (SQLException | InfraestruturaException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deletarUsuario(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

    try {
        connection = this.databaseConnection.getConnection();
        connection.setAutoCommit(false);

        String sql = "DELETE FROM " + tableNome + " WHERE ID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            connection.rollback();
            throw new InfraestruturaException("Erro ao deletar usuário, nenhum usuário encontrado com o ID: " + id);
        }

        connection.commit();

    } catch (SQLException | InfraestruturaException e) {
        throw new RuntimeException(e);
    } finally {
        try {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.databaseConnection.getConnection();
            String sql = "SELECT ID, NAME, EMAIL, SENHA FROM " + tableNome;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String senha = resultSet.getString("SENHA");

                usuarios.add(new Usuario(id, nome, email, senha));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }

}
