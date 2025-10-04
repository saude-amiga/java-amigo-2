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
    public void alterarNome(int id, String nome) {

        usuarioRepository.alterarNome(id, nome);
    }

    @Override
    public void alterarEmail(int id, String email) {
        usuarioRepository.alterarEmail(id, email);
    }

    @Override
    public void alterarSenha(int id, String senha){
        usuarioRepository.alterarSenha(id, senha);
    }

    @Override
    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) usuarioRepository.listarUsuarios();
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

    @Override
    public void deletarUsuario(int id) {
        usuarioRepository.deletarUsuario(id);
    }
}
