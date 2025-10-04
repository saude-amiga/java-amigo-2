package fiap.sprint.domain.repository;

import fiap.sprint.domain.model.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario criarUsuario(String nome, String email, String senha );
    void alterarSenha(int id,String senha);
    void alterarEmail(int id,String email);
    void alterarNome(int id,String nome);
    void deletarUsuario(int id);
    List<Usuario> listarUsuarios();

}
