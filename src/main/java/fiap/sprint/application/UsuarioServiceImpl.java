package fiap.sprint.application;

import fiap.sprint.domain.model.Usuario;
import fiap.sprint.domain.repository.UsuarioRepository;
import fiap.sprint.domain.service.UsuarioService;

import java.util.ArrayList;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario criarUsuario(String nome, String email, String senha)  {
        return usuarioRepository.criarUsuario(nome, email, senha);
    }

    @Override
    public Usuario alterarNome(String nome) {
        return null;
    }

    @Override
    public Usuario alterarEmail(String email) {
        return null;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return null;
    }

    @Override
    public boolean loginExiste(String email, String senha){
        ArrayList<Usuario> listaUsuario = this.listarUsuarios();
        for(Usuario usuario: listaUsuario){
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}
