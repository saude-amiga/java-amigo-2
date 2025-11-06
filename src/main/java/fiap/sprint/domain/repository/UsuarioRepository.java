package fiap.sprint.domain.repository;

import fiap.sprint.domain.model.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario criarUsuario(String nome, String email, String senha, boolean funcionario );
    Usuario alterarSenha(String senha);
    Usuario alterarEmail(String email);
    Usuario alterarNome(int id, String novoNome);

    void deletarUsuario(int id);
    List<Usuario> listarUsuarios();

    Usuario getUsuarioByEmail(String email);

    Usuario getUsuarioById(int id);
}
