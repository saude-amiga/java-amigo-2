package fiap.sprint.domain.service;

import fiap.sprint.domain.model.Usuario;

import java.util.ArrayList;

public interface UsuarioService {
    Usuario criarUsuario(String nome, String email, String senha );
    Usuario alterarNome(int id, String nome);
    Usuario alterarEmail(String email);
    ArrayList<Usuario> listarUsuarios();
    boolean loginExiste(String email, String senha);
    void deletarUsuario(int id);
}
