package fiap.sprint.infrastructure.persistence;

import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.infrastructure.exceptions.InfraestruturaException;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcUsuarioRepository implements UsuarioRepository {
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

            String sqlUsuario = """
                    INSERT INTO USUARIO (NOME, EMAIL, SENHA)
                    VALUES (?, ?, ?)
                    """;

            preparedStatement = connection.prepareStatement(sqlUsuario);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                connection.rollback();
                throw new InfraestruturaException("Erro ao inserir novo usuário, nenhuma linha afetada");
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
            return new Usuario(usuarioId.intValue(), nome, email, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InfraestruturaException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario alterarSenha(String senha) {
        return null;
    }

    @Override
    public Usuario alterarEmail(String email) {
        return null;
    }

    @Override
    public Usuario alterarNome(String nome) {
        return null;
    }

    @Override
    public void deletarUsuario(int id) {

    }

    @Override
    public List<Usuario> listarUsuarios() {
        return List.of();
    }
}
