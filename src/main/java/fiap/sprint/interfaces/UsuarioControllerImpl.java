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
    public Usuario alterarNome(String nome) {
        return usuarioService.alterarNome(nome);
    }

    @Override
    public Usuario alterarEmail(String email) {
        return usuarioService.alterarEmail(email);
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @Override
    public boolean loginExiste(String email, String senha) {
        return usuarioService.loginExiste(String email, String senha);
    }
}
