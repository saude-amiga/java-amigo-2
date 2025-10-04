package fiap.sprint.interfaces;

import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.service.UsuarioService;

import java.util.ArrayList;

public class UsuarioControllerImpl implements UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioControllerImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public Usuario criarUsuario(String nome, String email, String senha) {
        return usuarioService.criarUsuario(nome, email, senha);
    }

    @Override
    public void alterarNome(int id, String nome) {
        usuarioService.alterarNome(id, nome);
    }

    @Override
    public void alterarEmail(int id, String email) {
        usuarioService.alterarEmail(id, email);
    }

    @Override
    public void alterarSenha(int id, String senha) {
        usuarioService.alterarEmail(id, senha);
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @Override
    public boolean loginExiste(String email, String senha) {
        return usuarioService.loginExiste(email, senha);
    }

    @Override
    public void deletarUsuario(int id) {
        usuarioService.deletarUsuario(id);
    }
}
