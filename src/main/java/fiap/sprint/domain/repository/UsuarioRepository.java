package fiap.sprint.domain.repository;

import fiap.sprint.domain.model.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario criarUsuario(String nome, String email, String senha );
    Usuario alterarSenha(String senha);
    Usuario alterarEmail(String email);
    Usuario alterarNome(String nome);
    void deletarUsuario(int id);
    List<Usuario> listarUsuarios();

}
