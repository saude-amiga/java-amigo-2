package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Usuario;

import java.util.ArrayList;

public interface UsuarioController {
    Usuario criarUsuario(String nome, String email, String senha );
    void alterarNome(int id,String nome);
    void alterarEmail(int id,String email);
    void alterarSenha(int id, String senha);
    ArrayList<Usuario> listarUsuarios();
    boolean loginExiste(String email, String senha);
    void deletarUsuario(int id);
}
