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
    public Usuario alterarNome(int id, String nome) {
        return usuarioRepository.alterarNome(id,nome);
    }

    @Override
    public Usuario alterarEmail(String email) {
        return null;
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) usuarioRepository.listarUsuarios();
    }

    @Override
    public void deletarUsuario(int id) {
        usuarioRepository.deletarUsuario(id);
    }

    @Override
    public Usuario login(String email, String senha) {
        if (loginExiste(email, senha)){
            return usuarioRepository.getUsuarioByEmail(email);
        }
    }

    private boolean loginExiste(String email, String senha){
        ArrayList<Usuario> listaUsuario = this.listarUsuarios();
        for(Usuario usuario: listaUsuario){
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }

}
