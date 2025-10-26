package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Usuario;

import java.util.ArrayList;

public interface UsuarioController {
    Usuario criarUsuario(String nome, String email, String senha );
    Usuario alterarNome(int id, String nome);
    Usuario alterarEmail(String email);
    ArrayList<Usuario> listarUsuarios();
    boolean loginExiste(String email, String senha);
    void deletarUsuario(int id);
}
